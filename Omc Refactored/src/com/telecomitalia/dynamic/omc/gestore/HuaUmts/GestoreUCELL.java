package com.telecomitalia.dynamic.omc.gestore.HuaUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreUCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/UCELL.csv";
	public final static String CHIAVE = "UCELL";
	public String CELLNAME;
	public String LAC;
	public String CELLID;
	public String SAC;
	public String UARFCNDOWNLINK;
	public String UARFCNUPLINK;
	public String PSCRAMBCODE;
	public String ACTSTATUS;
	public String BLKSTATUS;
	
	
	
	public GestoreUCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"CELLNAME"+";"
		+"LAC"+";"
		+"CELLID"+";"
		+"SAC"+";"
		+"UARFCNDOWNLINK"+";"
		+"UARFCNUPLINK"+";"
		+"PSCRAMBCODE"+";"
		+"ACTSTATUS"+";"
		+"BLKSTATUS"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public void load() {
		super.load();
		CELLNAME = estraiCampo("\"CELLNAME\"");
		LAC = estraiCampo("\"LAC\"");
		CELLID = estraiCampo("\"CELLID\"");
		SAC = estraiCampo("\"SAC\"");
		UARFCNDOWNLINK = estraiCampo("\"UARFCNDOWNLINK\"");
		UARFCNUPLINK = estraiCampo("\"UARFCNUPLINK\"");
		PSCRAMBCODE = estraiCampo("\"PSCRAMBCODE\"");
		ACTSTATUS = estraiCampo("\"ACTSTATUS\"");
		BLKSTATUS = estraiCampo("\"BLKSTATUS\"");
		output.println(generaRiga());
	}
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+CELLNAME+";"
		+LAC+";"
		+CELLID+";"
		+SAC+";"
		+UARFCNDOWNLINK+";"
		+UARFCNUPLINK+";"
		+PSCRAMBCODE+";"
		+ACTSTATUS+";"
		+BLKSTATUS+";"
		+nomeFileOmc;
	}
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	


	@Override
	public String toString() {
		return "GestoreUCELL [CELLNAME=" + CELLNAME + ", LAC=" + LAC
				+ ", CELLID=" + CELLID + ", SAC=" + SAC + ", UARFCNDOWNLINK="
				+ UARFCNDOWNLINK + ", UARFCNUPLINK=" + UARFCNUPLINK
				+ ", PSCRAMBCODE=" + PSCRAMBCODE + ", ACTSTATUS=" + ACTSTATUS
				+ ", BLKSTATUS=" + BLKSTATUS + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}

