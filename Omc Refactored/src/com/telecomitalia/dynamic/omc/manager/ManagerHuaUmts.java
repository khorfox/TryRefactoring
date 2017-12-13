/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreGCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreRAN;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreRNC_13_0;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreUCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreUCNOPERATOR;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreUINTRAFREQNCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreUNODEB;
import com.telecomitalia.dynamic.omc.gestore.HuaUmts.GestoreUPSCH;


/**
 * @author TL000547
 * 
 */
public class ManagerHuaUmts extends ManagerGeneric {

	public ManagerHuaUmts() {
		super();
	}

	public ManagerHuaUmts(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreGCELL.CHIAVE, new GestoreGCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRAN.CHIAVE, new GestoreRAN(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRNC_13_0.CHIAVE, new GestoreRNC_13_0(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUCELL.CHIAVE, new GestoreUCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUCNOPERATOR.CHIAVE, new GestoreUCNOPERATOR(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUINTRAFREQNCELL.CHIAVE, new GestoreUINTRAFREQNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUNODEB.CHIAVE, new GestoreUNODEB(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUPSCH.CHIAVE, new GestoreUPSCH(nomeFile,dirCsv));
	}



}
