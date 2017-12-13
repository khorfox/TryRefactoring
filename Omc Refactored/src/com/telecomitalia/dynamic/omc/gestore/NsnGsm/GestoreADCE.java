package com.telecomitalia.dynamic.omc.gestore.NsnGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreADCE extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/ADCE.csv";
	public final static String CHIAVE = "ADCE";
	public String name;

	public GestoreADCE(String nome, String path) {
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
		return "GestoreADCE [name=" + name + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
