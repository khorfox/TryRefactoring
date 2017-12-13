/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreBSC;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreBTS;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreG2GNCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreG3GNCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELL;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLBASICPARA;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLCCBASIC;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLFREQ;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLGPRS;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLHOEDBPARA;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLHOEMG;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLHOIUO;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLMAGRP;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGCELLSERVPARA;
import com.telecomitalia.dynamic.omc.gestore.HuaGsm.GestoreGEXT3GCELL;


/**
 * @author TL000547
 * 
 */
public class ManagerHuaGsm extends ManagerGeneric {

	public ManagerHuaGsm() {
		super();
	}


	public ManagerHuaGsm(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}


	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreBSC.CHIAVE, new GestoreBSC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBTS.CHIAVE, new GestoreBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreG2GNCELL.CHIAVE, new GestoreG2GNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELL.CHIAVE, new GestoreGCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLCCBASIC.CHIAVE, new GestoreGCELLCCBASIC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLBASICPARA.CHIAVE, new GestoreGCELLBASICPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLFREQ.CHIAVE, new GestoreGCELLFREQ(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLGPRS.CHIAVE, new GestoreGCELLGPRS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOEMG.CHIAVE, new GestoreGCELLHOEMG(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOIUO.CHIAVE, new GestoreGCELLHOIUO(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLMAGRP.CHIAVE, new GestoreGCELLMAGRP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLSERVPARA.CHIAVE, new GestoreGCELLSERVPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOEDBPARA.CHIAVE, new GestoreGCELLHOEDBPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreG3GNCELL.CHIAVE, new GestoreG3GNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGEXT3GCELL.CHIAVE, new GestoreGEXT3GCELL(nomeFile,dirCsv));
	}

}
