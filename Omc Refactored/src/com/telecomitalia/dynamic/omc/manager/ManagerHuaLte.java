/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreCELLOP;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreENODEB;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreEUTRANINTERFREQNCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreEUTRANINTERNFREQ;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestoreMME;
import com.telecomitalia.dynamic.omc.gestore.HuaLte.GestorePDSCHCFG;

/**
 * @author TL000547
 * 
 */
public class ManagerHuaLte extends ManagerGeneric {

	public ManagerHuaLte(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreCELL.CHIAVE, new GestoreCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreMME.CHIAVE, new GestoreMME(nomeFile,dirCsv));
		gestoriClasse.put(GestoreENODEB.CHIAVE, new GestoreENODEB(nomeFile,dirCsv));
		gestoriClasse.put(GestoreEUTRANINTERFREQNCELL.CHIAVE,new GestoreEUTRANINTERFREQNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestorePDSCHCFG.CHIAVE, new GestorePDSCHCFG(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCELLOP.CHIAVE, new GestoreCELLOP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreEUTRANINTERNFREQ.CHIAVE,new GestoreEUTRANINTERNFREQ(nomeFile,dirCsv));
	}

	public ManagerHuaLte() {
		super();
	}


}
