package com.telecomitalia.dynamic.omc.gestoreHuaLte;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreENODEB extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/ENODEB.csv";
	public final static String CHIAVE = "ENODEB";
	public String NAME;
	public String ENODEBID;
	public String mcc;
	public String mnc;

	public GestoreENODEB(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + 
					   "distName" + ";" + 
					   "id" + ";" + 
					   "NAME" + ";" + 
					   "ENODEBID" + ";" + 
					   "mcc" + ";" + 
					   "mnc" + ";" +
					   "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		NAME = estraiCampo("\"NAME\"");
		ENODEBID = estraiCampo("\"ENODEBID\"");
		mcc = estraiCampo("\"mcc\"");
		mnc = estraiCampo("\"mnc\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" + NAME + ";"
				+ ENODEBID + ";" 
				+ mcc + ";" 
				+ mnc + ";" 
				+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreENODEB [NAME=" + NAME + ", ENODEBID=" + ENODEBID
				+ ", mcc=" + mcc + ", mnc=" + mnc + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}



}
