package com.telecomitalia.dynamic.omc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public abstract class Gestore {

	private static final String TAG_ID = "id=";
	private static final String TAG_DIST_NAME = "distName=";
	private static final String TAG_VERSION = "version=";
	private static final int TAG_VERSION_LENGTH = TAG_VERSION.length() + 1;
	private static final int TAG_ID_LENGTH = TAG_ID.length() + 1;
	private static final int TAG_DIST_NAME_LENGTH = TAG_DIST_NAME.length() + 1;
	protected ArrayList<String> classe = new ArrayList<String>();
	public String version;
	public String distName;
	public String id;
	protected PrintStream output;
	protected FileOutputStream file;
	protected String nomeFileOmc;
	//public String DIR_CSV = "D:/Workspace/ParsingOMC/script/csv/";
	//public String DIR_CSV = "C:/Workspace/LoadingOra/csv/";

	// Metodo che aggiunge una stringa all'array-list di stringhe
	public void put(String s) {
		classe.add(s);
	}

	// E' il metodo che estrae, in variabili, i dati contenuti nella prima riga
	// della classe
	// version; distName; id
	public void load() {

		String primaRiga = classe.get(0);
		if (primaRiga.contains("<managedObject")) {

			String temp = primaRiga.substring(primaRiga.indexOf(TAG_VERSION)
					+ TAG_VERSION_LENGTH);
			version = temp.substring(0, temp.indexOf('"'));

			temp = primaRiga.substring(primaRiga.indexOf(TAG_DIST_NAME)
					+ TAG_DIST_NAME_LENGTH);
			distName = temp.substring(0, temp.indexOf('"'));

			temp = primaRiga.substring(primaRiga.indexOf(TAG_ID)
					+ TAG_ID_LENGTH);
			id = temp.substring(0, temp.indexOf('"'));
		}
	}

	// Si spazzola tutte le righe dell'array di della classe selezionata
	protected String estraiCampo(String chiave) {
		String ritorno = "";
		for (String riga : classe) {
			int ind = riga.toUpperCase().indexOf(chiave.toUpperCase());
			if (ind > 0) {
				String temp = riga.substring(ind + chiave.length() + 1);
				ritorno = temp.substring(0, temp.indexOf("</p>"));
				break;
			}
		}
		return ritorno;
	}

	// Si spazzola tutte le righe dell'array di della classe selezionata
	// alla ricerca del nome-Lista e successivamente del nome_Item
	protected String estraiItem(String chiave, String item) {
		String ritorno = "";
		boolean trovataChiave = false;
		for (String riga : classe) {
			if (!trovataChiave){
				// Se non ho trovato la chiave, id della lista, la cerco
				if (riga.indexOf(chiave) > 0) {
					trovataChiave = true;
				}
			}	
			else{
				// test di uscita per evitare di leggere un campo item di altre liste
				if (riga.indexOf("</list>") > 0) {
					break;
				}
				// Ho già trovato la chiave Identificativa della lista
				// cerco l'item
				int ind = riga.indexOf(item);
				if (ind > 0) {
					// Ho trovato l'Item
					String temp = riga.substring(ind + item.length() + 1);
					ritorno = temp.substring(0, temp.indexOf("</p>"));
					break;
				}	
			}
		}
		return ritorno;
	}
	
	
	//String[] args
	
	// Si estrae i dati della lista, separati da virgola, in una stringa di
	// output
	protected String estraiLista(String chiave) {
		String ritorno = "";
		boolean trovato = false;
		boolean primo = true;
		// Ciclo alla ricerca del TAG chiave
		for (String riga : classe) {
			if (trovato) {

				// test di uscita
				if (riga.indexOf("</list>") > 0) {
					break;
				}
				if (primo) {
					// non inserisce il separatore
					String temp = riga.substring(riga.indexOf("<p>") + 3);
					ritorno = temp.substring(0, temp.indexOf("</p>"));
					primo = false;
				} else {
					String temp = riga.substring(riga.indexOf("<p>") + 3);
					ritorno = ritorno + ","
							+ temp.substring(0, temp.indexOf("</p>"));
				}
			}
			int ind = riga.indexOf(chiave);
			if (ind > 0) {
				trovato = true;
			}
		}
		return ritorno;
	}

	// Si estrae i valori di Freq, separati da virgola, in una stringa di outbut
	// es. di input "<p name=\"FREQ"
	protected String estraiFreqx(String chiave) {
		String ritorno = "";
		boolean primo = true;
		// Ciclo alla ricerca del TAG chiave
		for (String riga : classe) {
			// vedo se ho incontrato la chiave 
			int ind = riga.indexOf(chiave);
			if (ind > 0) {
				if (primo) {
					// non inserisce il separatore
					String temp = riga.substring(riga.indexOf("\">") + 2);
					ritorno = temp.substring(0, temp.indexOf("</p>"));
					primo = false;
				} else {
					String temp = riga.substring(riga.indexOf("\">") + 2);
					ritorno = ritorno + ","
							+ temp.substring(0, temp.indexOf("</p>"));
				}
				
			}
			
		}
		return ritorno;
	}
	
	
	// Metodo init che inizializza l'array list
	public void init() {
		classe.clear();

	}

	// Metodo interno che crea e/o apre in scrittura il file csv
	protected void inizializza(String pathCSV) {
		try {
			file = new FileOutputStream(pathCSV + getNomeFile());
			output = new PrintStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getNomeFile() {
		return "default.csv";
	}

	//
	public void termina() {

		try {
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Gestore [version=" + version + ", distName=" + distName
				+ ", id=" + id + "]";
	}

}