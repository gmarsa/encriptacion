package cript_object;

import java.util.Scanner;

public class CriptObject {
	static String mensajeOriginal = "hola";
	public String mensajeMod = "hola";
	public int clave;

	public static char alfabeto[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', '?', '!', '.', ',', '_' };

	// constructor

	// funcion para que el usuario introduzca los datos
	public void leerDatos() {
		Scanner lector2 = new Scanner(System.in);
		System.out.println("introduce una frase");
		mensajeMod = lector2.nextLine().toUpperCase();

		System.out.println("introduce la clave");
		clave = lector2.nextInt();

		lector2.close();
	}

	public CriptObject(String mensajeMod, int clave) {
		this.mensajeMod = mensajeMod;
		this.clave = clave;
	}

	// funcion encargada de encriptar los datos
	public char[] encriptar() {
		// creamos un objeto
		char[] mensajeEncriptado = new char[mensajeMod.length()];
		// recorremos el mensaje con un contador
		for (int i = 0; i < mensajeMod.length(); i++) {
			// si hay un espacio no hace nada
			if (mensajeMod.charAt(i) == ' ') {
				mensajeEncriptado[i] = mensajeMod.charAt(i);
				// en caso contrario
			} else {
				// recorremos el string de alfabeto
				for (int j = 0; j < alfabeto.length; j++) {
					// si una letra coincide:
					if (mensajeMod.charAt(i) == alfabeto[j]) {
						// se un sumatorio de la palabra del afabeto + la clave, lo del final sirve para
						// que de la vuelta
						if (clave < 0) {
							mensajeEncriptado[i] = alfabeto[(clave + alfabeto.length) - j];
							j = alfabeto.length;
							// si no hay clave le valor es el mismo basicamente
						} else {
							mensajeEncriptado[i] = alfabeto[(j + clave)];
							j = alfabeto.length;

						}

					} else {
						mensajeEncriptado[i] = mensajeMod.charAt(i);
					}

				}
			}

		}
		// retornamos el mensaje ya encriptado
		System.out.println("El mensaje " + mensajeMod + " se ha encriptado a:");
		return mensajeEncriptado;

	}

	// para desencriptar es hacer lo mismo pero al reves
	public char[] desencriptar() {
		// hacemos otro objeto
		char[] mensajeEncriptado = new char[mensajeMod.length()];
		// pues eso volvemos a hacer los mismos bucles para comparar las posiciones
		for (int i = 0; i < mensajeMod.length(); i++) {
			if (mensajeMod.charAt(i) == ' ') {
				mensajeEncriptado[i] = mensajeMod.charAt(i);
			} else {
				for (int j = 0; j < alfabeto.length; j++) {
					if (mensajeMod.charAt(i) == alfabeto[j]) {
						// al final en vez de sumar restamos la clave
						if (j < clave) {
							mensajeEncriptado[i] = alfabeto[(j + alfabeto.length) - clave];
							j = alfabeto.length;

						} else {
							mensajeEncriptado[i] = alfabeto[(j - clave)];
							j = alfabeto.length;

						}

					} else {
						mensajeEncriptado[i] = mensajeMod.charAt(i);
					}

				}
			}

		}
		System.out.println("El mensaje " + mensajeMod + " se ha desencriptado a:");
		return mensajeEncriptado;
	}

	// Metodo monoalfabetico

	public String encriptarMonoalfa(String clave) {
		// inicialitzem les variables on guardem els valors
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		// fem un bucle per a reccore la clau
		for (int x = 0; x < alfabeto.length; x++) {
			int index = 0;
			// recorrem en busca del caracter i si el trobem sortim
			for (index = 0; index < x; index++) {
				if (alfabeto.length == alfabeto.length)
					index = x;
				break;
			}
			// aquesta part no em surt
			// clave=(index + (67 - (clave %27)) % 27;
		}
		// inicialitzem
		char letra = ' ';
		// i aqui posem un valor al sb que sera ara el alfabeto
		sb = sb.append(String.valueOf(alfabeto));
		// recorrem l'alfabet
		for (int x = 0; x < alfabeto.length; x++) {
			int index;
			// fem que recorri l atre string tambe
			for (index = 0; index < sb2.length(); index++) {
				// aleshores posem el caracter x = que el index
				if (sb.charAt(x) == sb.charAt(index)) {

					break;
				}
				// guardem la posicio
				if (index == x) {
					sb2.append(sb.charAt(x));

				}

			}

		}
		// i aqui en teoria hauria de sortir xifrat pero xd
		return (sb2.toString());
	
	}
	
/*	public String desEncriptarMonoalfa(String clave) {
		//aqui no he arribat pero hauria de ser el metode anterior pero restant
	}*/

	public CriptObject() {

	}

	public String fAlfabeto(String alfabeto) {
		return alfabeto;
	}

	public String fMensajeOriginal(String mensajeOriginal) {
		return mensajeOriginal;
	}

	public String fMensajeMod(String mensajeMod) {
		return mensajeMod;
	}
}
