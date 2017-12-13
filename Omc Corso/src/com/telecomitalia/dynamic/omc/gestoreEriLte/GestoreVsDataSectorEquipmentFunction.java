package com.telecomitalia.dynamic.omc.gestoreEriLte;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreVsDataSectorEquipmentFunction extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_LTE/vsDataSectorEquipmentFunction.csv";
	public final static String CHIAVE = "vsDataSectorEquipmentFunction";
	public String configuredOutputPower;
	public String reservedBy;

	
	public GestoreVsDataSectorEquipmentFunction(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"configuredOutputPower"+";"
		+"reservedBy"+";"	
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+configuredOutputPower+";"
		+reservedBy+";"
		+nomeFileOmc;
	}

	@Override
	public void load() {
		super.load();
		configuredOutputPower = estraiCampo("\"configuredOutputPower\"");
		reservedBy = estraiCampo("\"reservedBy\"");
		
		output.println(generaRiga());
	}
	

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreVsDataSectorEquipmentFunction [configuredOutputPower="
				+ configuredOutputPower + ", reservedBy=" + reservedBy
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}

	
}
