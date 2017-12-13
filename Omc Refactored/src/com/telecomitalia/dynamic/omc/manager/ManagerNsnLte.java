/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.NsnLte.GestoreLNBTS;
import com.telecomitalia.dynamic.omc.gestore.NsnLte.GestoreLNCEL;
import com.telecomitalia.dynamic.omc.gestore.NsnLte.GestoreLNMME;

/**
 * @author TL000547
 * 
 */
public class ManagerNsnLte extends ManagerGeneric {

	public ManagerNsnLte() {
		super();
	}

	public ManagerNsnLte(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreLNBTS.CHIAVE, new GestoreLNBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreLNCEL.CHIAVE, new GestoreLNCEL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreLNMME.CHIAVE, new GestoreLNMME(nomeFile,dirCsv));
	}
	


}
