package com.telecomitalia.dynamic.omc.gestore.NsnGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreBTSNE extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/BTSNE.csv";
	public final static String CHIAVE = "BTSNE";
	public String siteName;

	public GestoreBTSNE(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"siteName"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		siteName = estraiCampo("\"siteName\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+siteName+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreBTSNE [siteName=" + siteName + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
