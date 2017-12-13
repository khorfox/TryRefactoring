package com.telecomitalia.dynamic.omc.gestore.EriGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreBSC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_GSM/BSC.csv";
	public final static String CHIAVE = "BSC";
	public String TRC;
	public String MSC_NAME;
	public GestoreBSC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";" 
		+ "TRC"	+ ";" 
		+ "MSC_NAME" + ";" 
		+ "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {

		// scrive i primi dati della riga
		super.load();

		// Leggere prima tutti i dati non definiti in liste
		TRC = estraiCampo("\"TRC\"");

		// Estrae i dati della lista in una stringa con i campi separati da ","
		MSC_NAME = estraiLista("\"MSC_NAME\"");

		output.println(generaRiga());
	}

	private String generaRiga() {

		return version + ";" + distName + ";" + id + ";" 
		+ TRC + ";" 
		+ MSC_NAME + ";" 
		+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreBSC [TRC=" + TRC + ", MSC_NAME=" + MSC_NAME
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + ", nomeFileOmc=" + nomeFileOmc + "]";
	}

}
