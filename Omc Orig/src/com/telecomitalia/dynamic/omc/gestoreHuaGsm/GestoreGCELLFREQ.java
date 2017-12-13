package com.telecomitalia.dynamic.omc.gestoreHuaGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLFREQ extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLFREQ.csv";
	public final static String CHIAVE = "GCELLFREQ";
	public String FREQ;

	public GestoreGCELLFREQ(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"FREQ"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		FREQ = estraiFreqx("<p name=\"FREQ");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+FREQ+";"
		+nomeFileOmc;
	}

	
	@Override
	public String toString() {
		return "GestoreGCELLFREQ [FREQ=" + FREQ + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
