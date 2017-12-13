package com.telecomitalia.dynamic.omc.client;

import com.telecomitalia.dynamic.omc.Manager;

public abstract class ClientGeneric {

	public String costruttore;

	public abstract Manager getManager(String path, String nomeFile, String pathCsv);

	public String tecnologia;

	public ClientGeneric() {
		super();
	}

}