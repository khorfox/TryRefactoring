package com.telecomitalia.dynamic.omc.gestore.NsnGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestorePOC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/POC.csv";
	public final static String CHIAVE = "POC";
	public String bsTxPwrMax;

	public GestorePOC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"bsTxPwrMax"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		bsTxPwrMax = estraiCampo("\"bsTxPwrMax\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+bsTxPwrMax+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestorePOC [bsTxPwrMax=" + bsTxPwrMax + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
