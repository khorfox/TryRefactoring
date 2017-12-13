package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreBTS extends Gestore implements
		GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/BTS.csv";
	public final static String CHIAVE = "BTS";
	public String BTSNAME;


	public GestoreBTS(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"BTSNAME"+";"
		+"NOMEFILE_OMC");
	}
	

	@Override
	public void load() {
		super.load();
		BTSNAME = estraiCampo("\"BTSNAME\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+BTSNAME+";"
		+nomeFileOmc;
	}
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	
	@Override
	public String toString() {
		return "GestoreBTS [BTSNAME=" + BTSNAME + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
