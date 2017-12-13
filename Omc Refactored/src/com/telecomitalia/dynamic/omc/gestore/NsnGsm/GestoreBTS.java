package com.telecomitalia.dynamic.omc.gestore.NsnGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreBTS extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_GSM/BTS.csv";
	public final static String CHIAVE = "BTS";
	public String name;
	public String rxLevAccessMin;
	public String bsIdentityCodeBCC;
	public String bsIdentityCodeNCC;
	public String dedicatedGPRScapacity;
	public String locationAreaIdMCC;
	public String locationAreaIdMNC;
	public String locationAreaIdLAC;
	public String cellId;
	public String adminState;
	public String radioLinkTimeout;
	public String timeLimitCall;

	

	public GestoreBTS(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"name"+";"
		+"rxLevAccessMin"+";"
		+"bsIdentityCodeBCC"+";"
		+"bsIdentityCodeNCC"+";"
		+"dedicatedGPRScapacity"+";"
		+"locationAreaIdMCC"+";"
		+"locationAreaIdMNC"+";"
		+"locationAreaIdLAC"+";"
		+"cellId"+";"
		+"adminState"+";"
		+"radioLinkTimeout"+";"
		+"timeLimitCall"+";"
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
		rxLevAccessMin = estraiCampo("\"rxLevAccessMin\"");
		bsIdentityCodeBCC = estraiCampo("\"bsIdentityCodeBCC\"");
		bsIdentityCodeNCC = estraiCampo("\"bsIdentityCodeNCC\"");
		dedicatedGPRScapacity = estraiCampo("\"dedicatedGPRScapacity\"");
		locationAreaIdMCC = estraiCampo("\"locationAreaIdMCC\"");
		locationAreaIdMNC = estraiCampo("\"locationAreaIdMNC\"");
		locationAreaIdLAC = estraiCampo("\"locationAreaIdLAC\"");
		cellId = estraiCampo("\"cellId\"");
		adminState = estraiCampo("\"adminState\"");
		radioLinkTimeout = estraiCampo("\"radioLinkTimeout\"");
		timeLimitCall = estraiCampo("\"timeLimitCall\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+name+";"
		+rxLevAccessMin+";"
		+bsIdentityCodeBCC+";"
		+bsIdentityCodeNCC+";"
		+dedicatedGPRScapacity+";"
		+locationAreaIdMCC+";"
		+locationAreaIdMNC+";"
		+locationAreaIdLAC+";"
		+cellId+";"
		+adminState+";"
		+radioLinkTimeout+";"
		+timeLimitCall+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreBTS [name=" + name + ", rxLevAccessMin="
				+ rxLevAccessMin + ", bsIdentityCodeBCC=" + bsIdentityCodeBCC
				+ ", bsIdentityCodeNCC=" + bsIdentityCodeNCC
				+ ", dedicatedGPRScapacity=" + dedicatedGPRScapacity
				+ ", locationAreaIdMCC=" + locationAreaIdMCC
				+ ", locationAreaIdMNC=" + locationAreaIdMNC
				+ ", locationAreaIdLAC=" + locationAreaIdLAC + ", cellId="
				+ cellId + ", adminState=" + adminState + ", radioLinkTimeout="
				+ radioLinkTimeout + ", timeLimitCall=" + timeLimitCall
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}

}
