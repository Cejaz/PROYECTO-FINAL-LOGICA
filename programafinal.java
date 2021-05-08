import java.util.Scanner;

public class programafinal {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //MENUS DE BIENVENIDA
        System.out.println( "                                       ╔═════════════════════════╗                          ");                                                
	    System.out.println( "                                       ║       BIENVENIDOS!      ║                          ");       
	    System.out.println( "                                       ╚═════════════════════════╝\n                        ");

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
        int selec=0;
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

        if (centinela == 1)
            System.out.println("Correcto");
            audio.detener();
    

        //PRIMERA PREGUNTA
        
    }
    
}
            

