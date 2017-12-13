/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreManagedElement;
import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreRncFunction;
import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreUtranCell;
import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreUtranRelation;
import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreVsDataHsdsch;
import com.telecomitalia.dynamic.omc.gestore.EriUmts.GestoreVsDataUtranCell;

/**
 * @author TL000547
 * 
 */
public class ManagerEriUmts extends ManagerGeneric {

	public ManagerEriUmts() {
		super();
	}

	public ManagerEriUmts(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreManagedElement.CHIAVE, new GestoreManagedElement(nomeFile,dirCsv));
		gestoriClasse.put(GestoreRncFunction.CHIAVE, new GestoreRncFunction(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUtranCell.CHIAVE, new GestoreUtranCell(nomeFile,dirCsv));
		gestoriClasse.put(GestoreUtranRelation.CHIAVE, new GestoreUtranRelation(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataHsdsch.CHIAVE, new GestoreVsDataHsdsch(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataUtranCell.CHIAVE, new GestoreVsDataUtranCell(nomeFile,dirCsv));
	}

}
