package com.telecomitalia.dynamic.omc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public abstract class ManagerAbstract implements Manager {

	protected String DIR_PATH = "D:/Workspace/FILE_OMC/";
	protected String nomeFile;
	protected int numeroOggettiCaricati = 0;
	protected Hashtable<String, Gestore> gestoriClasse;
	protected static final String TAG_CLASS = "class=";
	public String dirCsv;
	public boolean debug = false;
	
	public ManagerAbstract() {
		super();
	}


	public void stampaNomeFile() {
		if(debug ){
			for (Gestore el : gestoriClasse.values()) {
				System.out.println(el.getNomeFile());
				el.termina();
			}
		}
	}
		public void stampaGestore(Gestore gestore) {
			if(debug ){
				System.out.println(gestore);
			}
	}

		public int parse() throws IOException {
			BufferedReader b = new BufferedReader(new FileReader(DIR_PATH
					+ nomeFile));
			String s = "";
			// Gestore è la classe generica che gestisce le managed Objet-class da
			// parsare
			Gestore gestore = null;
			boolean scrivi = false;
			while (true) {
				// Legge stringa per stringa (in s) finchè ci sono linee da leggere
				s = b.readLine();
				if (s == null) {
					break;
				} else {
					// Verifica se nella stringa c'è un inizio o fine di
					// managedObject
					boolean inizio = s.contains("<managedObject");
					boolean fine = s.contains("</managedObject>");
					if (inizio) {
						gestore = null;
						// Estrae il nome della classe
						String temp = s.substring(s.indexOf(TAG_CLASS)
								+ TAG_CLASS.length() + 1);
						String nomeClasse = temp.substring(0, temp.indexOf('"'));
						// Verifica se è una classe da gestire (hash table)
						gestore = gestoriClasse.get(nomeClasse);
						if (gestore != null) {
							scrivi = true;
							inizio = false;
							// Chiama il metodo che inizializza l'array di stringhe
							// da leggere
							// per la classe riconoasciuta
							gestore.init();
						}
					}
					if (scrivi) {
						// aggiunge una riga al sottoinsieme di righe chiuse tra i
						// tag managedObject
						gestore.put(s);
					}
					if (fine) {
						// Gestisce la lettura dell'ultima riga della classe e la
						// chiusura del file csv
						// Verifico se ho gestito una classe di interesse
						if (gestore != null) {
							gestore.load();
							stampaGestore(gestore);
							scrivi = false;
							fine = false;
							numeroOggettiCaricati++;
						}
					}
				}
			}
			stampaNomeFile();
			b.close();
			return numeroOggettiCaricati;
		
		}
	
	
}