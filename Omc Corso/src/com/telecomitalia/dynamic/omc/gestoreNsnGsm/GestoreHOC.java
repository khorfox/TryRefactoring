package com.telecomitalia.dynamic.omc.gestoreNsnGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreHOC extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/HOC.csv";
	public final static String CHIAVE = "HOC";
	public String maxMsDistanceHoThreshold;

	public GestoreHOC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"maxMsDistanceHoThreshold"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		maxMsDistanceHoThreshold = estraiCampo("\"maxMsDistanceHoThreshold\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+maxMsDistanceHoThreshold+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreHOC [maxMsDistanceHoThreshold=" + maxMsDistanceHoThreshold + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
