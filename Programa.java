import java.util.*;
import java.io.File;
public class Programa {

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
	System.out.println("                                          ___________________________________________________________________________________________                                                                                     |                                                                                           |" );
	System.out.println("                                         |         ██████╗  ██████╗  ███████╗  ██████╗  ██╗   ██╗ ███╗  ██╗ ██╗ ███████╗ ██╗   ██╗   |");
        System.out.println("                                         |         ██╔══██╗ ██╔══██╗ ██╔════╝ ██╔════╝  ██║   ██║ ████╗ ██║ ██║ ██╔════╝ ╚██╗ ██╔╝   |              ");
        System.out.println("                                         |         ██████╔╝ ██████╔╝ █████╗   ██║  ██╗  ██║   ██║ ██╔██╗██║ ██║ █████╗    ╚████╔╝    |               ");
        System.out.println("                                         |         ██╔═══╝  ██╔══██╗ ██╔══╝   ██║  ╚██╗ ██║   ██║ ██║╚████║ ██║ ██╔══╝     ╚██╔╝     |            ");
        System.out.println("                                         |         ██║      ██║  ██║ ███████╗ ╚██████╔╝ ╚██████╔╝ ██║ ╚███║ ██║ ██║         ██║      |           ");
        System.out.println("                                         |         ╚═╝      ╚═╝  ╚═╝ ╚══════╝  ╚═════╝   ╚═════╝  ╚═╝  ╚══╝ ╚═╝ ╚═╝         ╚═╝      | "); 
    System.out.println("	                                 |                                                                                           |");  
		imprimir("	                                 |                                                          	  			     |");
		imprimir("	                                 |                               INGRESE UNA OPCIÓN ASÍ:        			     |");
		imprimir("	                                 |                            1. Imprimir lista de Canciones 	            		     |");
		imprimir("	                                 |                            2. Reproducir canción			                     |");
		imprimir("	                                 |                            3. Mostrar Letra				                     |");
		imprimir("	                                 |                            4. Detener Canción				             |");
		imprimir("	                                 |                            5. Mostrar datos de canciones		                     |");
		imprimir("	                                 |                            6. Salir					                     |");
	System.out.println("	     .                            |___________________________________________________________________________________________|");
		System.out.print("					  Seleccione una opcion: ");
	}
	
public static void main(String[] args) {

	try {

		String seguir;
		Scanner teclado = new Scanner(System.in);

    	System.out.println("\n                                               ██████╗  ██╗ ███████╗ ███╗  ██╗ ██╗   ██╗ ███████╗ ███╗  ██╗ ██╗ ██████╗   █████╗   ██████╗         ");
		System.out.println("                                               ██╔══██╗ ██║ ██╔════╝ ████╗ ██║ ██║   ██║ ██╔════╝ ████╗ ██║ ██║ ██╔══██╗ ██╔══██╗ ██╔════╝             ");
		System.out.println("                                               ██████╦╝ ██║ █████╗   ██╔██╗██║ ╚██╗ ██╔╝ █████╗   ██╔██╗██║ ██║ ██║  ██║ ██║  ██║ ╚█████╗                   ");
		System.out.println("                                               ██╔══██╗ ██║ ██╔══╝   ██║╚████║  ╚████╔╝  ██╔══╝   ██║╚████║ ██║ ██║  ██║ ██║  ██║  ╚═══██╗              ");
		System.out.println("                                               ██████╦╝ ██║ ███████╗ ██║ ╚███║   ╚██╔╝   ███████╗ ██║ ╚███║ ██║ ██████╔╝ ╚█████╔╝ ██████╔╝                  ");
		System.out.println("                                               ╚═════╝  ╚═╝ ╚══════╝ ╚═╝  ╚══╝    ╚═╝    ╚══════╝ ╚═╝  ╚══╝ ╚═╝ ╚═════╝   ╚════╝  ╚═════╝                   \n\n");

		System.out.println("                                                                                        █████╗");
		System.out.println("                                                                                       ██╔══██╗");
		System.out.println("                                                                                       ███████║");
		System.out.println("                                                                                       ██╔══██║");
		System.out.println("                                                                                       ██║  ██║");
		System.out.println("                                                                                       ╚═╝  ╚═╝");


		System.out.println("\n                                                    ██████╗  ██████╗  ███████╗  ██████╗  ██╗   ██╗ ███╗  ██╗ ██╗ ███████╗ ██╗   ██╗");
        System.out.println("                                                    ██╔══██╗ ██╔══██╗ ██╔════╝ ██╔════╝  ██║   ██║ ████╗ ██║ ██║ ██╔════╝ ╚██╗ ██╔╝              ");
        System.out.println("                                                    ██████╔╝ ██████╔╝ █████╗   ██║  ██╗  ██║   ██║ ██╔██╗██║ ██║ █████╗    ╚████╔╝                ");
        System.out.println("                                                    ██╔═══╝  ██╔══██╗ ██╔══╝   ██║  ╚██╗ ██║   ██║ ██║╚████║ ██║ ██╔══╝     ╚██╔╝              ");
        System.out.println("                                                    ██║      ██║  ██║ ███████╗ ╚██████╔╝ ╚██████╔╝ ██║ ╚███║ ██║ ██║         ██║              ");
        System.out.println("                                                    ╚═╝      ╚═╝  ╚═╝ ╚══════╝  ╚═════╝   ╚═════╝  ╚═╝  ╚══╝ ╚═╝ ╚═╝         ╚═╝\n"); 

		System.out.println("PARA CONTINUAR CON EL PROGRAMA TIENES QUE RESPONDER CUAL CANCIÓN ES LA QUE SUENA. VAMOS!!!\n");

		System.out.println("Presiona enter para continuar con el programa...");
		seguir = teclado.nextLine();		


		//Declaracion de variables
        Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
        int respuesta = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;

		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);


		audio.seleccionarCancion(info_canciones[RandomHelper.random(0,info_canciones.length-1)][ConsoleData.RUTA_CANCION]);
		audio.reproducir();

		File carpeta = new File("./canciones");
		String[] lista = carpeta.list();

		for(int i=0;i<lista.length-1;i++)
		{
			System.out.println("Canciones # "+i+ " : "+lista[i]);
		}
		respuesta = ConsoleInput.getInt();
		audio.detener();

											//FALTA CONTROLAR LA CANCION QUE SUENA CON LA RESPUESTA DEL USUARIO

do{
	System.out.println();
	menu();
	centinela = ConsoleInput.getInt();
	if(centinela == 1)
	{
		File carpeta1 = new File("./canciones");
		String[] lista1 = carpeta1.list();
		for(int i=0;i<lista1.length;i++)
		{
			System.out.println("Canción # "+i+ " : "+lista1[i]);
		}
	}
	if(centinela == 2)
		{	
		imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
		indice_cancion = ConsoleInput.getInt();
		audio.seleccionarCancion(info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);
		audio.reproducir();

		//Aca se controla que el archivo exista.
		File archivo = new File("./canciones");
			if (!archivo.exists()) {
    			System.out.println("OJO: ¡No existe el archivo");
			 	}
		}
				
				
	if(centinela == 3)
	{
					
	imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
	indice_cancion = ConsoleInput.getInt();

	inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
	fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
	letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);
	imprimir(letra_cancion.toString());
	}

	if(centinela == 4)
		{
		audio.detener();
		}

	if(centinela == 5)
		{
		imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
		indice_cancion = ConsoleInput.getInt();

		inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
		fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);

		System.out.println();
		imprimir("Inicio letra: "+inicio_letra);
		imprimir("Fin letra: "+fin_letra);
		imprimir("Nombre: "+info_canciones[indice_cancion][ConsoleData.NOMBRE_CANCION]);
		imprimir("Autor: "+info_canciones[indice_cancion][ConsoleData.AUTOR_CANCION]);
		imprimir("Archivo: "+info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);

		imprimir("Primera estrofa: "+canciones[inicio_letra]);
		imprimir("Última estrofa: "+canciones[fin_letra]);
		}
			
	}while(centinela!=6);				
	}
 	catch (Exception e) {
	System.out.println(e);
	}
}
}

