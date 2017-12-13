package com.telecomitalia.dynamic.omc.gestore.HuaLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreCELLOP extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/CELLOP.csv";
	public final static String CHIAVE = "CELLOP";
	public String TRACKINGAREAID;

	@Override
	public void load() {
		super.load();
		TRACKINGAREAID = estraiCampo("\"TRACKINGAREAID\"");
		output.println(generaRiga());
	}

	public GestoreCELLOP(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
				+ "TRACKINGAREAID" + ";" + "NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" + TRACKINGAREAID + ";"
				+ nomeFileOmc;
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreCELLOP [version=" + version + ", distName=" + distName
				+ ", id=" + id + ", TRACKINGAREAID=" + TRACKINGAREAID + "]";
	}

}
