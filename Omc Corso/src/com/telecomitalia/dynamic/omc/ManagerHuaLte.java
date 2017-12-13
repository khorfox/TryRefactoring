/**
 * 
 */
package com.telecomitalia.dynamic.omc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreCELLOP;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreENODEB;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreEUTRANINTERFREQNCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreEUTRANINTERNFREQ;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestoreMME;
import com.telecomitalia.dynamic.omc.gestoreHuaLte.GestorePDSCHCFG;

/**
 * @author TL000547
 * 
 */
public class ManagerHuaLte extends ManagerAbstract {

	public ManagerHuaLte(String nomeFile, String path, String pathCsv) {
		super();
		this.nomeFile = nomeFile;
		this.DIR_PATH = path;
		this.dirCsv=pathCsv;
		gestoriClasse = new Hashtable<String, Gestore>();
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreCELL.CHIAVE, new GestoreCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreMME.CHIAVE, new GestoreMME(nomeFile,dirCsv));
		gestoriClasse.put(GestoreENODEB.CHIAVE, new GestoreENODEB(nomeFile,dirCsv));
		gestoriClasse.put(GestoreEUTRANINTERFREQNCELL.CHIAVE,new GestoreEUTRANINTERFREQNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestorePDSCHCFG.CHIAVE, new GestorePDSCHCFG(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCELLOP.CHIAVE, new GestoreCELLOP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreEUTRANINTERNFREQ.CHIAVE,new GestoreEUTRANINTERNFREQ(nomeFile,dirCsv));
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
