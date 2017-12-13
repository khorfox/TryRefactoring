package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGEXT3GCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GEXT3GCELL.csv";
	public final static String CHIAVE = "GEXT3GCELL";
	public String EXT3GCELLNAME;
	
	
	public GestoreGEXT3GCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"EXT3GCELLNAME"+";"
		+"NOMEFILE_OMC");
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		EXT3GCELLNAME = estraiCampo("\"EXT3GCELLNAME\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+EXT3GCELLNAME+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreGCELLMAGRP [EXT3GCELLNAME=" + EXT3GCELLNAME + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
