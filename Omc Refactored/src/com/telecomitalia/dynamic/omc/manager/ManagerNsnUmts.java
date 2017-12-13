/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.NsnUmts.GestoreADJS;
import com.telecomitalia.dynamic.omc.gestore.NsnUmts.GestoreRNC;
import com.telecomitalia.dynamic.omc.gestore.NsnUmts.GestoreWBTS;
import com.telecomitalia.dynamic.omc.gestore.NsnUmts.GestoreWCEL;


/**
 * @author TL000547
 * 
 */
public class ManagerNsnUmts  extends ManagerGeneric {

	public ManagerNsnUmts() {
		super();
	}

	public ManagerNsnUmts(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreADJS.CHIAVE, new GestoreADJS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRNC.CHIAVE, new GestoreRNC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreWBTS.CHIAVE, new GestoreWBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreWCEL.CHIAVE, new GestoreWCEL(nomeFile,dirCsv));
	}


}
