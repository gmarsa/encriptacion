package cript_main;

import cript_object.CriptObject;

public class CriptMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CriptObject text=new CriptObject();
		text.leerDatos();
		System.out.println(text.encriptar());
		System.out.println(text.desencriptar());
		
		
	}

}
