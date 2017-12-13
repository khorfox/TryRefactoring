package com.telecomitalia.dynamic.omc.gestoreNsnGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreTRX extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/TRX.csv";
	public final static String CHIAVE = "TRX";
	public String tsc;
	public String initialFrequency;

	

	public GestoreTRX(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"tsc"+";"
		+"initialFrequency"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		tsc = estraiCampo("\"tsc\"");
		initialFrequency = estraiCampo("\"initialFrequency\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+tsc+";"
		+initialFrequency+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreTRX [tsc=" + tsc + ", initialFrequency="
				+ initialFrequency + ", version=" + version + ", distName="
				+ distName + ", id=" + id + "]";
	}

}
