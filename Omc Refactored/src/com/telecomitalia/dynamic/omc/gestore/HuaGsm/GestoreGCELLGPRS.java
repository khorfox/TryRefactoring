package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLGPRS extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLGPRS.csv";
	public final static String CHIAVE = "GCELLGPRS";
	public String EDGE;

	public GestoreGCELLGPRS(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"EDGE"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		EDGE = estraiCampo("\"EDGE\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+EDGE+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreGCELLGPRS [EDGE=" + EDGE + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
