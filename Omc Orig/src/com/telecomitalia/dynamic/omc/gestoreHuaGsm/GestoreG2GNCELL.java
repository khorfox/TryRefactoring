package com.telecomitalia.dynamic.omc.gestoreHuaGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreG2GNCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/G2GNCELL.csv";
	public final static String CHIAVE = "G2GNCELL";
	

	public GestoreG2GNCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"NOMEFILE_OMC");
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
		return version+";"+distName+";"+id+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreG2GNCELL [version=" + version + ", distName=" + distName
				+ ", id=" + id + "]";
	}

}
