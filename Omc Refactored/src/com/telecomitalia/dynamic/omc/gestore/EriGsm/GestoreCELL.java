package com.telecomitalia.dynamic.omc.gestore.EriGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_GSM/CELL.csv";
	public final static String CHIAVE = "CELL";
	public String state;

	public GestoreCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
		+ "state" + ";" 
		+ "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		state = estraiCampo("\"state\"");

		output.println(generaRiga());
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" 
		+ state + ";"
		+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreCELL [state=" + state + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + ", nomeFileOmc="
				+ nomeFileOmc + "]";
	}

}
