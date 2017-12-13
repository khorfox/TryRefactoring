/**
 * 
 */
package com.telecomitalia.dynamic.omc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreGCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreRAN;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreRNC_13_0;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreUCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreUCNOPERATOR;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreUINTRAFREQNCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreUNODEB;
import com.telecomitalia.dynamic.omc.gestoreHuaUmts.GestoreUPSCH;


/**
 * @author TL000547
 * 
 */
public class ManagerHuaUmts extends ManagerAbstract {

	public ManagerHuaUmts(String nomeFile, String path, String pathCsv) {
		super();
		this.nomeFile = nomeFile;
		this.DIR_PATH = path;
		this.dirCsv=pathCsv;
		gestoriClasse = new Hashtable<String, Gestore>();
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreGCELL.CHIAVE, new GestoreGCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRAN.CHIAVE, new GestoreRAN(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRNC_13_0.CHIAVE, new GestoreRNC_13_0(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUCELL.CHIAVE, new GestoreUCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUCNOPERATOR.CHIAVE, new GestoreUCNOPERATOR(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUINTRAFREQNCELL.CHIAVE, new GestoreUINTRAFREQNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUNODEB.CHIAVE, new GestoreUNODEB(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUPSCH.CHIAVE, new GestoreUPSCH(nomeFile,dirCsv));
	}


	// Inizia la lettura del file
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
						gestore.init();
					}
				}
				if (scrivi) {
					// effettua la scrittura della riga
					gestore.put(s);
				}
				if (fine) {
					// Gestisce la lettura dell'ultima riga della classe e la
					// chiusura del file csv
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
