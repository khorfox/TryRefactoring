package com.telecomitalia.dynamic.omc.manager;

import java.io.IOException;

public class ManagerEmpty extends ManagerGeneric {

	protected ManagerEmpty(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	public int parse() throws IOException {
		return 0;
	}

}
