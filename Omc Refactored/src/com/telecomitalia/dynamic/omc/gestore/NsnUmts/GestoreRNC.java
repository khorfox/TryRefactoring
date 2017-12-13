package com.telecomitalia.dynamic.omc.gestore.NsnUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreRNC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_UMTS/RNC.csv";
	public final static String CHIAVE = "RNC";
	public String name;

	public GestoreRNC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"name"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		name = estraiCampo("\"name\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+name+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreBTSNE [name=" + name + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
