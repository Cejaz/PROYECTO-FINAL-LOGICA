import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import java.util.*;

public class Programa{

	public static String convertirUnicode(String letra,String cadena){
		
		StringBuilder str = new StringBuilder(cadena);
		int indice = -1;
		char caracter = 0;
		indice = str.lastIndexOf(letra);
		
		if(indice>=0 )
		{
			switch(letra){
				case "Á": caracter = '\u00C1';
						  break;
				case "á": caracter = '\u00E1';
					      break;
				case "é": caracter = '\u00E9';
					      break;
				case "í": caracter = '\u00ED';
					      break;
		        case "ó": caracter = '\u00F3';
					      break;
			    case "ú": caracter = '\u00FA';
					      break;
				case "ñ": caracter = '\u00F1';
					      break;
			}
			// System.out.println("\\u" + Integer.toHexString('÷' | 0x10000).substring(1));
			str.replace(indice,indice+1,""+caracter);
		}

		return str.toString();
	}

	public static void imprimir(String cadena)
	{
		String str; 
		str = convertirUnicode("Á",cadena);
		str = convertirUnicode("á",str);
		str = convertirUnicode("é",str);
		str = convertirUnicode("í",str);
		str = convertirUnicode("ó",str);
		str = convertirUnicode("ú",str);
		str = convertirUnicode("ñ",str);

		System.out.println(str);
	}

	public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
		StringBuilder str = new StringBuilder();
		StringTokenizer temp;

		for(int i = inicio; i<=fin; i++)
		{
			//System.out.println("@  "+data[i]);

			temp = new StringTokenizer(data[i],";");

			while(temp.hasMoreTokens())
			{
				System.out.print(temp.nextToken()+" ");
			}
			System.out.println();
			//str.append(data[i]+"\n");
		}

		return str;
	}

	public static void menu(){
		System.out.println("	 __________________________________________________________________");
		System.out.println("	|                              _     _                             |");
		System.out.println("	|                             ( \\---/ )                            |");
		System.out.println("	|                              ) . . (                             |");
		System.out.println("	|________________________,--._(___Y___)_,--.____________________hjw|");
		System.out.println("	|                        `--'           `--'                       |");
		System.out.println("	|		                  _   _  __                        |");
		System.out.println("	|		                 | | (_)/ _|                       |");
		System.out.println("	|		  ___ _ __   ___ | |_ _| |_ _   _                  |");
		System.out.println("	|		 / __| '_ \\ / _ \\| __| |  _| | | |                 |");
		System.out.println("	|		 \\__ \\ |_) | (_) | |_| | | | |_| |                 |");
		System.out.println("	|		 |___/ .__/ \\___/ \\__|_|_|  \\__, |                 |");
		System.out.println("	|		     | |                     __/ |                 |");
		System.out.println("	|		     |_|                    |___/                  |");
				  imprimir("	|                                                          	   |");
				  imprimir("	|                    Ingrese una opción así:		 	   |");
				  imprimir("	|                    1. Buscar canción			 	   |");
				  imprimir("	|                    2. Reproducir canción			   |");
				  imprimir("	|                    3. Mostrar Letra				   |");
				  imprimir("	|                    4. Detener Canción				   |");
				  imprimir("	|                    5. Imprimir lista de Canciones		   |");
				  imprimir("	|                    6. Salir					   |");
		System.out.println("	|__________________________________________________________________|");
		System.out.print("	Spotify$ ");
	}

	public static void main(String[] args) {
		
		//AnsiConsole.systemInstall();
		
		Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;

		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

		try{
			
			do{

				// imprimir(""+RandomHelper.random(1,10));

				System.out.println();
				//TODO: Terminar la funcion para que imprima todos los caracteres especiales que use el programa
				menu();
				//TODO: Ojo falta validar la entrada de datos
				//TODO: Recuerde usar el helper ConsoleInput y validar
				centinela = ConsoleInput.getInt();

				if(centinela == 2)
				{
					//TODO: Controlar que el archivo de la cancion exista
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();
					audio.seleccionarCancion(info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);
					audio.reproducir();
				}

				if(centinela == 3)
				{
					//TODO: Ojo, falta validar el valor ingresado
					//TODO: Falta darle formato amigable de lectura al usuario 
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();

					inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
					fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
					
					letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);
					//imprimir(letra_cancion.toString());
				}

				if(centinela == 4)
				{
					audio.detener();
				}

				if(centinela==5)
				{
					/* La informacion de las canciones esta
					en la matriz info_canciones, acá un ejemplo de como imprimir
					el nombre de la primer canción y su autor */
					
					//TODO: Ojo, falta validar el valor ingresado
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();

					inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
					fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

					System.out.println();
					imprimir("Inicio letra "+inicio_letra);
					imprimir("Fin letra "+fin_letra);
					imprimir("Nombre "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
					imprimir("Autor "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
					imprimir("Archivo "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);

					imprimir("Primera estrofa: "+canciones[inicio_letra]);
					imprimir("Última estrofa: "+canciones[fin_letra]);
					
					//TODO:Convertir a unicode mayúsculas y caracteres especiales
					//TODO:Explicar como funciona el archivo y como se analiza cada línea
					//TODO:Imprimir la lista completa
				}

			}while(centinela!=6);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			audio.detener();
		}
	}
}