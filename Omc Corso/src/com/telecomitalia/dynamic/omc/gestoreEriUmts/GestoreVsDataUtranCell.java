package com.telecomitalia.dynamic.omc.gestoreEriUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreVsDataUtranCell extends Gestore implements GestoreInterface{

	static final String NOME_FILE = "ERI_UMTS/vsDataUtranCell.csv";
	public final static String CHIAVE="vsDataUtranCell";
	public String qRxLevMin;
	public String administrativeState;
	
	public GestoreVsDataUtranCell(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"qRxLevMin"+";"
		+"administrativeState"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		qRxLevMin = estraiCampo("\"qRxLevMin\"");
		administrativeState = estraiCampo("\"administrativeState\"");
		output.println(generaRiga());
	}
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+qRxLevMin+";"
		+administrativeState+";"
		+nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreVsDataUtranCell [qRxLevMin=" + qRxLevMin
				+ ", administrativeState=" + administrativeState + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
