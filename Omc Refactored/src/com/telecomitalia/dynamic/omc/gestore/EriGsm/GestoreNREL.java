package com.telecomitalia.dynamic.omc.gestore.EriGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreNREL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_GSM/NREL.csv";
	public final static String CHIAVE = "NREL";

	public GestoreNREL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
		+ "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" 
		+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreNREL [version=" + version + ", distName=" + distName
				+ ", id=" + id + ", nomeFileOmc=" + nomeFileOmc + "]";
	}

}
