package com.telecomitalia.dynamic.omc.gestoreHuaUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreRNC_13_0 extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/RNC_13.0.csv";
	public final static String CHIAVE = "RNC_13.0";
	
	public GestoreRNC_13_0(String nome, String path) {
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
		return "GestoreRNC_13_0 [version=" + version + ", distName=" + distName
				+ ", id=" + id + "]";
	}

}
