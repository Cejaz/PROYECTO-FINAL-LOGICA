//DECLARACION DE VARIABLES
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import javax.swing.JOptionPane;
public class Programa{

	public static void displayVacio(int n,int m){
		for (int i=0;i<n;i++) 
		{
			for (int j=0;j<m;j++)
			{
				System.out.print("  ");
			}
			System.out.println();
		}
	}

	public static void imprimirDisplay(int n,int m){
		String simbolo = Math.random()>5?"*":" ";
		for (int i=0;i<n;i++) 
		{
			if(i+1==n)
			{
				simbolo = "#";

			}
			for (int j=0;j<m;j++)
			{
				System.out.print(i+simbolo);
			}
			System.out.println();
		}
	}

	public static void borrarDisplay(int n){
		//Se le suma 1 si se ejecuta con el bat, ya que la ultima linea es el pause
		//for (int i=0;i<=n;i++){
			//System.out.println(ansi().cursorUpLine(i));
		//}
		System.out.println(ansi().cursor(2,1));
			displayVacio(5,6);
		System.out.println(ansi().cursor(1,1));
		System.out.println(ansi().reset());
	}

	public static void animar() throws InterruptedException{
		

		Thread.sleep(1000);
		
/*
		for(int i=0;i<10;i++){
			System.out.print("\r");
			//System.out.print("\r");
			texto = texto+nuevo.charAt(i);
			System.out.print(texto);
			Thread.sleep(1000);
		}*/
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

	public static StringBuilder obtenerLetraCancion(int inicio,int fin, String[]data)
	{
		StringBuilder str = new StringBuilder();

		for(int i = inicio; i<=fin; i++)
		{
			str.append(data[i]+"\n");
		}

		return str;
	}
	//COMIENZO DEL PROGRAMA
	public static void main(String[] args) {
		//AnsiConsole.systemInstall();
		
		//DECLARACION VARIABLES DEL MENU
		Audio audio = new Audio();
		int centinela = 0;	
		int indice_cancion = 0;
		int inicio_letra = 0, fin_letra = 0;
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

		try{
			//Consolas con vt100 http://braun-home.net/michael/info/misc/VT100_commands.htm
			//System.out.println("Hallo \033[32mgreen\033[0m-text.");
			//System.out.println(ansi().eraseScreen().render("@|red Hello|@ @|green World|@"));
			//System.out.println( ansi().fg(RED).a("Hello").newline().fg(GREEN).a(" World").reset() );
			//System.out.println("\007");
			
			/*imprimirDisplay(4,16);
			Thread.sleep(1000);
			borrarDisplay(4);
			imprimirDisplay(4,16);*/

			//ANTES DE MOSTRAR LA PREGUNTA DEBEMOS REPRODUCIR UNUA CANCION ALEATORIA.
			
			
			//MENU DE CANCION
			do{
				System.out.println();
				//TODO: Terminar la funcion para que imprima todos los caracteres especiales que use el programa
				imprimir("Ingrese una opción así:");
				imprimir("1. Buscar canción");
				imprimir("2. Reproducir canción");
				imprimir("3. Mostrar Letra");
				imprimir("4. Detener Canción");
				imprimir("5. Imprimir lista de Canciones");
				imprimir("6. Salir");
				//TODO: Ojo falta validar la entrada de datos
				centinela = ConsoleInput.getInt();

				if(centinela == 2)
				{
					audio.seleccionarCancion(info_canciones[2][ConsoleData.RUTA_CANCION]);
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

					imprimir(letra_cancion.toString());
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