package com.telecomitalia.dynamic.omc.gestoreNsnUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreWCEL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_UMTS/WCEL.csv";
	public final static String CHIAVE = "WCEL";
	public String name;
	public String WCELMCC;
	public String WCELMNC;
	public String LAC;
	public String CId;
	public String SAC;
	public String UARFCN;
	public String PriScrCode;
	public String PtxPrimarySCH;
	public String HSDPAenabled;
	public String QrxlevMin;
	public String AdminCellState;



	public GestoreWCEL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"name"+";"
		+"WCELMCC"+";"
		+"WCELMNC"+";"
		+"LAC"+";"
		+"CId"+";"
		+"SAC"+";"
		+"UARFCN"+";"
		+"PriScrCode"+";"
		+"PtxPrimarySCH"+";"
		+"HSDPAenabled"+";"
		+"QrxlevMin"+";"
		+"AdminCellState"+";"
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
		WCELMCC = estraiCampo("\"WCELMCC\"");
		WCELMNC = estraiCampo("\"WCELMNC\"");
		LAC = estraiCampo("\"LAC\"");
		CId = estraiCampo("\"CId\"");
		SAC = estraiCampo("\"SAC\"");
		UARFCN = estraiCampo("\"UARFCN\"");
		PriScrCode = estraiCampo("\"PriScrCode\"");
		PtxPrimarySCH = estraiCampo("\"PtxPrimarySCH\"");
		HSDPAenabled = estraiCampo("\"HSDPAenabled\"");
		QrxlevMin = estraiCampo("\"QrxlevMin\"");
		AdminCellState = estraiCampo("\"AdminCellState\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+name+";"
		+WCELMCC+";"
		+WCELMNC+";"
		+LAC+";"
		+CId+";"
		+SAC+";"
		+UARFCN+";"
		+PriScrCode+";"
		+PtxPrimarySCH+";"
		+HSDPAenabled+";"
		+QrxlevMin+";"
		+AdminCellState+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreWCEL [name=" + name + ", WCELMCC=" + WCELMCC
				+ ", WCELMNC=" + WCELMNC + ", LAC=" + LAC + ", CId=" + CId
				+ ", SAC=" + SAC + ", UARFCN=" + UARFCN + ", PriScrCode="
				+ PriScrCode + ", PtxPrimarySCH=" + PtxPrimarySCH
				+ ", HSDPAenabled=" + HSDPAenabled + ", QrxlevMin=" + QrxlevMin
				+ ", AdminCellState=" + AdminCellState + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
