package com.telecomitalia.dynamic.omc.gestore.NsnLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreLNBTS extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_LTE/LNBTS.csv";
	public final static String CHIAVE = "LNBTS";
	public String name;
	
	
	public GestoreLNBTS(String nome, String path) {
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
		return "GestoreLNBTS [name=" + name + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
