package com.telecomitalia.dynamic.omc.gestore.HuaLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestorePDSCHCFG extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/PDSCHCFG.csv";
	public final static String CHIAVE = "PDSCHCFG";
	public String REFERENCESIGNALPWR;

	@Override
	public void load() {
		super.load();
		REFERENCESIGNALPWR = estraiCampo("\"REFERENCESIGNALPWR\"");
		output.println(generaRiga());
	}

	public GestorePDSCHCFG(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
				+ "REFERENCESIGNALPWR" + ";" + "NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" + REFERENCESIGNALPWR
				+ ";" + nomeFileOmc;
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestorePDSCHCFG [version=" + version + ", distName=" + distName
				+ ", id=" + id + ", REFERENCESIGNALPWR=" + REFERENCESIGNALPWR
				+ "]";
	}

}
