package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreGCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELL.csv";
	public final static String CHIAVE = "GCELL";
	public String CELLNAME;
	public String MCC;
	public String MNC;
	public String LAC;
	public String CI;
	public String ACTSTATUS;
	public String BCC;
	public String NCC;
	
	
	
	public GestoreGCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"CELLNAME"+";"
		+"MCC"+";"
		+"MNC"+";"
		+"LAC"+";"
		+"CI"+";"
		+"ACTSTATUS"+";"
		+"BCC"+";"
		+"NCC"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public void load() {
		super.load();
		CELLNAME = estraiCampo("\"CELLNAME\"");
		MCC = estraiCampo("\"MCC\"");
		MNC = estraiCampo("\"MNC\"");
		LAC = estraiCampo("\"LAC\"");
		CI = estraiCampo("\"CI\"");
		ACTSTATUS = estraiCampo("\"ACTSTATUS\"");
		BCC = estraiCampo("\"BCC\"");
		NCC = estraiCampo("\"NCC\"");
		output.println(generaRiga());
	}
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+CELLNAME+";"
		+MCC+";"
		+MNC+";"
		+LAC+";"
		+CI+";"
		+ACTSTATUS+";"
		+BCC+";"
		+NCC+";"
		+nomeFileOmc;
	}
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	


	@Override
	public String toString() {
		return "GestoreGCELL [CELLNAME=" + CELLNAME + ", MCC=" + MCC + ", MNC="
				+ MNC + ", LAC=" + LAC + ", CI=" + CI + ", ACTSTATUS="
				+ ACTSTATUS + ", BCC=" + BCC + ", NCC=" + NCC + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
