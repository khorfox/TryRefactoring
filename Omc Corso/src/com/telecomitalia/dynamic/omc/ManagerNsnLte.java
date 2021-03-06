/**
 * 
 */
package com.telecomitalia.dynamic.omc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.gestoreNsnLte.GestoreLNBTS;
import com.telecomitalia.dynamic.omc.gestoreNsnLte.GestoreLNCEL;
import com.telecomitalia.dynamic.omc.gestoreNsnLte.GestoreLNMME;

/**
 * @author TL000547
 * 
 */
public class ManagerNsnLte extends ManagerAbstract {

	public ManagerNsnLte(String nomeFile, String path, String pathCsv) {
		super();
		this.nomeFile = nomeFile;
		this.DIR_PATH = path;
		this.dirCsv=pathCsv;
		gestoriClasse = new Hashtable<String, Gestore>();
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreLNBTS.CHIAVE, new GestoreLNBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreLNCEL.CHIAVE, new GestoreLNCEL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreLNMME.CHIAVE, new GestoreLNMME(nomeFile,dirCsv));
	}
	

	// Inizia la lettura del file
	// ManagerEriGsm.parse � il metodo che effettua il parsing del nomeFile
	// passato alla classe ManagerEriGsm
	public int parse() throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(DIR_PATH
				+ nomeFile));
		String s = "";
		// Gestore � la classe generica che gestisce le managed Objet-class da
		// parsare
		Gestore gestore = null;
		boolean scrivi = false;
		while (true) {
			// Legge stringa per stringa (in s) finch� ci sono linee da leggere
			s = b.readLine();
			if (s == null) {
				break;
			} else {
				// Verifica se nella stringa c'� un inizio o fine di
				// managedObject
				boolean inizio = s.contains("<managedObject");
				boolean fine = s.contains("</managedObject>");
				if (inizio) {
					gestore = null;
					// Estrae il nome della classe
					String temp = s.substring(s.indexOf(TAG_CLASS)
							+ TAG_CLASS.length() + 1);
					String nomeClasse = temp.substring(0, temp.indexOf('"'));
					// Verifica se � una classe da gestire (hash table)
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
