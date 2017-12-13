package com.telecomitalia.dynamic.omc.gestoreNsnGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreBSC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/BSC.csv";
	public final static String CHIAVE = "BSC";
	public String name;
	public String MSC_NAME;

	

	public GestoreBSC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"name"+";"
		+"MSC_NAME"+";"
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
		MSC_NAME = estraiCampo("\"MSC_NAME\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+name+";"
		+MSC_NAME+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreBSC [name=" + name + ", MSC_NAME=" + MSC_NAME
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}

}
