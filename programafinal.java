import java.util.Scanner;

public class programafinal {

    public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
		StringBuilder str = new StringBuilder();

		for(int i = inicio; i<=fin; i++)
		{
			str.append(data[i]+"\n");
		}

		return str;
	}
	public static String convertirUnicode(String letra,String cadena){
		
		StringBuilder str = new StringBuilder(cadena);
		int indice = -1;
		char caracter = 0;
		indice = str.lastIndexOf(letra);
		
		if(indice>=0 )
		{
			switch(letra){
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
			str.replace(indice,indice+2,""+caracter);
		}

		return str.toString();
	}

	public static void imprimir(String cadena)
	{
		String str; 
		str = convertirUnicode("á",cadena);
		str = convertirUnicode("é",str);
		str = convertirUnicode("í",str);
		str = convertirUnicode("ó",str);
		str = convertirUnicode("ú",str);
		str = convertirUnicode("ñ",str);

		System.out.println(str);
	}
	
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //MENUS DE BIENVENIDA
        System.out.println( "                                    ╔═════════════════════════╗                          ");                                                
	    System.out.println( "                                    ║       BIENVENIDOS!      ║                          ");       
	    System.out.println( "                                    ╚═════════════════════════╝\n                        ");

		System.out.println("            ████████  █████   ██████    █████    ██████   █████   █████    ███   ██   █████  ");
        System.out.println("               ██    ██   ██  ██   ██  ██   ██  ██       ██   ██  ██   ██  ████  ██  ██   ██ ");
        System.out.println("               ██    ███████  ██   ██  ██   ██   █████   ██       ███████  ██ ██ ██  ██      ");
        System.out.println("               ██    ██   ██  ██   ██  ██   ██       ██  ██   ██  ██   ██  ██  ████  ██   ██ ");
        System.out.println("               ██    ██   ██  ██████    █████   ██████    █████   ██   ██  ██   ███   █████\n");
        
		
        //MENSAJE DE INFORMACION DE LAS REGLAS
        System.out.println("Para continuar con el programa tienes que responder cual canción es la que suena. VAMOS!!!");

        //GUARDAMOS LAS CANCIONES EN UNA LISTA
        Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
        int respuesta1=0;
        
		//GUARDAMOS LA INFORMACION DE LAS CANCIONES EN UNA LISTA
		String [] canciones;

		//GUARDAMOS LA INFORMACION DE LAS CANCIONES EN UN VECTOR
		String [][] info_canciones;

		//clase que permiten crear objetos que almacenan cadenas de caracteres que pueden ser modificadas sin necesidad de crear nuevos objetos.
		StringBuilder letra_cancion;
		


		//IMPORTAMOS LAS LETRAS DE CANCIONES
		canciones = ConsoleFile.readBigFile("recursos/letras.csv");
		
		//GUARDAMOS LAS LETRAS DE LAS CANCIONES
		info_canciones = ConsoleData.dataList(canciones);


        //HACEMOS QUE SUENA LA CANCION ALEATORIAMENTE
        
				audio.seleccionarCancion(info_canciones[1][ConsoleData.RUTA_CANCION]);
				audio.reproducir();
				

        //DEFINIMOS LAS CLASES DONDE EN CADA UNA IRAN 5 CANCIONES Y UNA MISMA PREGUNTA PARA LAS 4 CLASES.
        System.out.println("¿Cual cancion es la que sono? Escoga un numero entre el 1 y el 23");
                            System.out.println(" 1). A_Dios_le_pido");
                            System.out.println(" 2). Cielo");
                            System.out.println(" 3). Coldplay - Viva La Vida");
                            System.out.println(" 4). Como_Camaron");
                            System.out.println(" 5). Cuando_Sea_Grande");
                            System.out.println(" 6). dame_amor");
                            System.out.println(" 7). DMX_-_Party_Up");
                            System.out.println(" 8). DMX_-_Ruff_Ryders_Anthem");
                            System.out.println(" 9). En_algun_lugar");
                            System.out.println("10). Friends");
                            System.out.println("11). HEROES_DEL_SILENCIO_-_Maldito_duende");
                            System.out.println("12). La_camisa_negra");
                            System.out.println("13). La_Gasolina");
                            System.out.println("14). Laura");
                            System.out.println("15). lobo_hombre_en_Paris");
                            System.out.println("16). Me_gustas_tu");
                            System.out.println("17). musica_ligera");
                            System.out.println("18). Nada_valgo_sin_tu_amor");
                            System.out.println("19). Rayando_el_sol");
                            System.out.println("20). Rosas");
                            System.out.println("21). Video_Game_Themes_-_Mario_Party");
                            System.out.println("22). Vino_Tinto");
                            System.out.println("23). Vivo_por_ella");
                            centinela = ConsoleInput.getInt();

        do{
			if (centinela >=1 && centinela<=23){
				System.out.println("correcto");
				System.out.println();
					imprimir("Ingrese una opción así:");
					imprimir("3. Mostrar Letra");
					imprimir("4. Detener Canción");
					imprimir("5. Imprimir lista de Canciones");
					imprimir("6. Salir");
					respuesta1 = ConsoleInput.getInt();
			}
			else
				System.out.println("Incorrecto");
				System.exit(1);

				if(respuesta1 == 3)
				{
					//TODO: Ojo, falta validar el valor ingresado
					//TODO: Falta darle formato amigable de lectura al usuario 
					imprimir("Ingrese indice de la cancion, entre 0 y "+(info_canciones.length-1));
					indice_cancion = ConsoleInput.getInt();

					inicio_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.INICIO_CANCION]);
					fin_letra = ConsoleInput.stringToInt(info_canciones[indice_cancion][ConsoleData.FIN_CANCION]);
					
					letra_cancion = obtenerLetraCancion(inicio_letra,fin_letra,canciones);

					imprimir(letra_cancion.toString());
				}

				if(respuesta1 == 4)
				{
					audio.detener();
				}

				if(respuesta1 == 5)
				{
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
				}

		}while(respuesta1!=6);				
	}
}
    

            

