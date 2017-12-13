package com.telecomitalia.dynamic.omc.model;

public enum Costruttore  {
	Ericsonn("ERI"),Huawei ("HUA"),NokiaSiemens("NSN");

	public String sigla;
	
	Costruttore (String sigla) {     
		this.sigla = sigla;
	}

	public static boolean isCorrect(String val){
		boolean ritorno = false;
		for (Costruttore el: Costruttore.values()){
			if(val.equals(el.sigla)){
				ritorno=true;
				break;
			}
		}
		return ritorno;
	}

	public static Costruttore get(String val){
		for (Costruttore el: Costruttore.values()){
			if(val.equals(el.sigla)){
				return el;
			}
		}
		return null;
	}

	public static String lista(){
		String ritorno = "";
		for (Costruttore el: Costruttore.values()){
			ritorno = ritorno + " " + el.sigla;
		}
		return ritorno;
	}

}
