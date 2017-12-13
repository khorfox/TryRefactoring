package com.telecomitalia.dynamic.omc.model;

public enum Tecnologia  {
	Gsm("GSM"),Lte ("LTE"),Umts("UMTS");
	public String sigla;
	
	Tecnologia (String sigla) {     
		this.sigla = sigla;
	}

	public static boolean isCorrect(String val){
		boolean ritorno = false;
		for (Tecnologia el: Tecnologia.values()){
			if(val.equals(el.sigla)){
				ritorno=true;
				break;
			}
		}
		return ritorno;
	}

	public static Tecnologia get(String val){
		for (Tecnologia el: Tecnologia.values()){
			if(val.equals(el.sigla)){
				return el;
			}
		}
		return null;
	}

	public static String lista(){
		String ritorno = "";
		for (Tecnologia el: Tecnologia.values()){
			ritorno = ritorno + " " + el.sigla;
		}
		return ritorno;
	}

}
