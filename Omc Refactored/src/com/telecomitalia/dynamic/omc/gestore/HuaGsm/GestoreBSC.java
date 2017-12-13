package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreBSC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/BSC.csv";
	public final static String CHIAVE = "BSC";
	
	public GestoreBSC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"NOMEFILE_OMC");
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
	public String getNomeFile() {
		return NOME_FILE;
	}

	


	@Override
	public String toString() {
		return "GestoreBSC [version=" + version + ", distName=" + distName
				+ ", id=" + id + "]";
	}

}
