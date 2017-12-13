package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreG3GNCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/G3GNCELL.csv";
	public final static String CHIAVE = "G3GNCELL";
	

	public GestoreG3GNCELL(String nome, String path) {
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
		return "GestoreG3GNCELL [version=" + version + ", distName=" + distName
				+ ", id=" + id + "]";
	}

}
