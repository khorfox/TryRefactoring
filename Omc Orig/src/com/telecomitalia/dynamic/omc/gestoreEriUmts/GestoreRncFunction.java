package com.telecomitalia.dynamic.omc.gestoreEriUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreRncFunction extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_UMTS/RncFunction.csv";
	public final static String CHIAVE = "RncFunction";
	public String mcc;
	public String mnc;

	

	public GestoreRncFunction(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"mcc"+";"
		+"mnc"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	
		
	@Override
	public void load() {
		
		// scrive i primi dati della riga
		super.load();
		
		mcc = estraiCampo("\"mcc\"");
		mnc = estraiCampo("\"mnc\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+mcc+";"
		+mnc+";"
		+nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreRncFunction [mcc=" + mcc + ", mnc=" + mnc + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
