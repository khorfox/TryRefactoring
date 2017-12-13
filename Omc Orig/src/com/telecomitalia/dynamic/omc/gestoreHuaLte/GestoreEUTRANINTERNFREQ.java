package com.telecomitalia.dynamic.omc.gestoreHuaLte;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreEUTRANINTERNFREQ extends Gestore implements
		GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/EUTRANINTERNFREQ.csv";
	public final static String CHIAVE = "EUTRANINTERNFREQ";
	public String DLEARFCN;

	@Override
	public void load() {
		super.load();
		DLEARFCN = estraiCampo("\"DLEARFCN\"");
		output.println(generaRiga());

	}

	public GestoreEUTRANINTERNFREQ(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
				+ "DLEARFCN" + ";" + "NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" + DLEARFCN + ";"
				+ nomeFileOmc;
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreEUTRANINTERNFREQ [version=" + version + ", distName="
				+ distName + ", id=" + id + ", DLEARFCN=" + DLEARFCN + "]";
	}

}
