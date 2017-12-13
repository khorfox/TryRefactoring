package com.telecomitalia.dynamic.omc.gestore.EriUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreVsDataHsdsch extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_UMTS/vsDataHsdsch.csv";
	public final static String CHIAVE = "vsDataHsdsch";
	public String administrativeState;

	
	

	@Override
	public void load() {
		super.load();
		administrativeState = estraiCampo("\"administrativeState\"");
				
		output.println(generaRiga());
	}

	public GestoreVsDataHsdsch(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"administrativeState"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+administrativeState+";"
		+nomeFileOmc;
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreVsDataHsdsch [administrativeState="
				+ administrativeState + ", version=" + version + ", distName="
				+ distName + ", id=" + id + "]";
	}


}
