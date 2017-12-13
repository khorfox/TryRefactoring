package com.telecomitalia.dynamic.omc.gestore.EriUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreUtranRelation extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_UMTS/UtranRelation.csv";
	public final static String CHIAVE = "UtranRelation";
		

	@Override
	public void load() {
		super.load();
		output.println(generaRiga());
	}

	public GestoreUtranRelation(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+nomeFileOmc;
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreUtranRelation [version=" + version + ", distName="
				+ distName + ", id=" + id + "]";
	}


}
