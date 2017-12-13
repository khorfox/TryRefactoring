package com.telecomitalia.dynamic.omc.gestoreHuaGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLMAGRP extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLMAGRP.csv";
	public final static String CHIAVE = "GCELLMAGRP";
	public String TSC;
	
	
	public GestoreGCELLMAGRP(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"TSC"+";"
		+"NOMEFILE_OMC");
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		TSC = estraiCampo("\"TSC\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+TSC+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreGCELLMAGRP [TSC=" + TSC + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
