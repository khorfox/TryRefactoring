package com.telecomitalia.dynamic.omc.gestore.HuaLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreMME extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/MME.csv";
	public final static String CHIAVE = "MME";
	public String DESCRIPTION;

	public GestoreMME(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
				+ "DESCRIPTION" + ";" + "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		DESCRIPTION = estraiCampo("\"DESCRIPTION\"");
		output.println(generaRiga());
	}

	private String generaRiga() {

		return version + ";" + distName + ";" + id + ";" + DESCRIPTION + ";"
				+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreMME [DESCRIPTION=" + DESCRIPTION + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
