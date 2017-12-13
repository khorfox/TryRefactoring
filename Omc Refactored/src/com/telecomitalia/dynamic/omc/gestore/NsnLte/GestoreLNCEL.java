package com.telecomitalia.dynamic.omc.gestore.NsnLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreLNCEL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_LTE/LNCEL.csv";
	public final static String CHIAVE = "LNCEL";
	public String name;
	public String mcc;
	public String mnc;
	public String lcrId;
	public String cellName;
	public String pMax;
	public String dlCellPwrRed;
	public String administrativeState;
	public String phyCellId;
	public String tac;
	public String earfcnDL;
	


	public GestoreLNCEL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"name"+";"
		+"mcc"+";"
		+"mnc"+";"
		+"lcrId"+";"
		+"cellName"+";"
		+"pMax"+";"
		+"dlCellPwrRed"+";"
		+"administrativeState"+";"
		+"phyCellId"+";"
		+"tac"+";"
		+"earfcnDL"+";"
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
		mcc = estraiCampo("\"mcc\"");
		mnc = estraiCampo("\"mnc\"");
		lcrId = estraiCampo("\"lcrId\"");
		cellName = estraiCampo("\"cellName\"");
		pMax = estraiCampo("\"pMax\"");
		dlCellPwrRed = estraiCampo("\"dlCellPwrRed\"");
		administrativeState = estraiCampo("\"administrativeState\"");
		phyCellId = estraiCampo("\"phyCellId\"");
		tac = estraiCampo("\"tac\"");
		earfcnDL = estraiCampo("\"earfcnDL\"");
		output.println(generaRiga());
	}

	private String generaRiga() {

		return version+";"+distName+";"+id+";"
		+name+";"
		+mcc+";"
		+mnc+";"
		+lcrId+";"
		+cellName+";"
		+pMax+";"
		+dlCellPwrRed+";"
		+administrativeState+";"
		+phyCellId+";"
		+tac+";"
		+earfcnDL+";"
		+nomeFileOmc;
	}


	@Override
	public String toString() {
		return "GestoreLNCEL [name=" + name + ", mcc=" + mcc + ",  mnc=" + mnc + ",lcrId="
				+ lcrId + ", cellName=" + cellName + ", pMax=" + pMax
				+ ", dlCellPwrRed=" + dlCellPwrRed + ", administrativeState="
				+ administrativeState + ", phyCellId=" + phyCellId + ", tac=" + tac
				+ ", earfcnDL=" + earfcnDL + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
