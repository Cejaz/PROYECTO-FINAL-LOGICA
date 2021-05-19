import java.util.*;

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
		System.out.println("	                                 |___________________________________________________________________________________________|");
		System.out.print("					  Seleccione una opcion: ");
	}
	
	public static void main(String[] args) {
		
		//Declaracion de variables
		Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
		int respuesta = 0;
		String [] canciones;
		String [][] info_canciones;
		StringBuilder letra_cancion;
		int seleccion_actual = 0;
		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		info_canciones = ConsoleData.dataList(canciones);

	//Comenzamos con el programa
	try {

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
		ConsoleInput.getString();		

		//Guardamos la cancion reproducida aleatoriamente en la variable seleccion_actual.
		seleccion_actual = RandomHelper.random(0,info_canciones.length-1);
		audio.seleccionarCancion(info_canciones[seleccion_actual][ConsoleData.RUTA_CANCION]);
		audio.reproducir();

		//Mostramos los nombres de las canciones que hay en la carpeta.
		for(int i=0;i<info_canciones.length;i++)
		{
			System.out.println("Cancion # "+i+ " : "+info_canciones[i][ConsoleData.NOMBRE_CANCION]);
		}
		System.out.print("\nSeleccione la cancion que esta sonando: ");
		//Guardamos la respuesta del usuario en la variable respuesta.
		respuesta = ConsoleInput.getInt();
		audio.detener();

		//Creamos la condicion de que si la seleccion_actual del usuario es igual a la respuesta le decimos al usuario si es correcto o no su respuesta.
		if(seleccion_actual == respuesta)
		{
			System.out.println("\nCorrecto\n");
			System.out.println("Su cancion es : "+info_canciones[seleccion_actual][ConsoleData.NOMBRE_CANCION]);
		}
		else
		{
			System.out.println("\nCanción incorrecta, gracias por jugar. Por favor dar enter para salir del programa");
			ConsoleInput.getString();
			System.exit(0);
		}

		//Mostramos el menu cada vez que hay una respuesta.
		do{
			System.out.println();
			menu();
			centinela = ConsoleInput.getInt();

			//Opcion 1
			for(int i=0;i<info_canciones.length;i++)
		{
			System.out.println("Canciones # "+i+ " : "+info_canciones[i][ConsoleData.NOMBRE_CANCION]);
		}
			//Opcion 2
			if(centinela == 2)
			{	
				imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
				indice_cancion = ConsoleInput.getInt();
				audio.seleccionarCancion(info_canciones[indice_cancion][ConsoleData.RUTA_CANCION]);
				audio.reproducir();
			}
					
			//Opcion 3		
			if(centinela == 3)
			{			
				imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
				indice_cancion = ConsoleInput.getInt();

				inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
				fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
				letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);
				imprimir(letra_cancion.toString());
			}
			//Opcion 4
			if(centinela == 4)
			{
				audio.detener();
			}
			//Opcion 5
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
			//Opcion 6	
		}while(centinela!=6);				
	}
	//Atrapamos los errores.
 	catch (Exception e) 
	{
		System.out.println("Ha ocurrido un error en el programa"+ e);
	}
}
}


