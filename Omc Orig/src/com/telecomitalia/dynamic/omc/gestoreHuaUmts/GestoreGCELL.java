package com.telecomitalia.dynamic.omc.gestoreHuaUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/GCELL.csv";
	public final static String CHIAVE = "GCELL";
	public String CELLNAME;

	public GestoreGCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"CELLNAME"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		CELLNAME = estraiCampo("\"CELLNAME\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+CELLNAME+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreGCELL [CELLNAME=" + CELLNAME + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
