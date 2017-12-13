package com.telecomitalia.dynamic.omc.gestore.EriGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreCHANNEL_GROUP extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_GSM/CHANNEL_GROUP.csv";
	public final static String CHIAVE = "CHANNEL_GROUP";
	public String NUMREQEGPRSBPC;
	public String DCHNO;
	public String SDCCH;

	public GestoreCHANNEL_GROUP(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
		+ "NUMREQEGPRSBPC" + ";" 
		+ "DCHNO" + ";"
		+ "SDCCH" + ";"
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
		NUMREQEGPRSBPC = estraiCampo("\"NUMREQEGPRSBPC\"");
		SDCCH = estraiCampo("\"SDCCH\"");

		// Estrae i dati della lista in una stringa con i campi separati da ","
		DCHNO = estraiLista("\"DCHNO\"");

		output.println(generaRiga());

	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" 
		+ NUMREQEGPRSBPC + ";"
		+ DCHNO + ";" 
		+ SDCCH + ";" 
		+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreCHANNEL_GROUP [NUMREQEGPRSBPC=" + NUMREQEGPRSBPC
				+ ", DCHNO=" + DCHNO + ", SDCCH=" + SDCCH + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
