import javax.swing.JOptionPane;

public class prueba {
    public static void main(String[] args) {
        
        //MENUS DE BIENVENIDA
        JOptionPane.showMessageDialog(null,        " ╔═════════════════════════╗\n"                                                
	                                            + " ║           BIENVENIDOS!            ║\n"       
	                                            + " ╚═════════════════════════╝\n");

		JOptionPane.showMessageDialog(null," ╔══════════════════════════════════════════════════╗ \n "
+"║                             PREGUNTADOS MUSICAL!                       ║ \n "  
+"╚══════════════════════════════════════════════════╝");
		
        //MENSAJE DE INFORMACION DE LAS REGLAS
        JOptionPane.showMessageDialog(null,"Para continuar con el programa tienes que responder una pregunta de cultura general basica!,\n"
        + "si no la respondes correctamente no te permitiremos el ingreso a nuestro preguntados. VAMOS!!! \n");
        
        //DEFINIMOS VARIBLES
        int respuesta1=0;
        int selec=0;
        
        //PRIMERA PREGUNTA
        do{
            do{
                respuesta1=Integer.parseInt(JOptionPane.showInputDialog("* ¿Cuáles son los cinco tipos de sabores primarios?\n"
                                                                    + "1) dulce, amargo, ácido, salado y umami*\n"
                                                                    + "2) dulce, picante, salado, amargo\n"
                                                                    + "3) fuerte, suave, dulce, salado"));
                
                
            //CONDICION PARA SACAR AL USUARIO SE SELECCIONA UN NUMERO DISTINTO A 1,2 O 3.
            if (respuesta1>=1 && respuesta1<=3) {
                    selec=1;
            }else{
                JOptionPane.showMessageDialog(null, "No es una opcion.Gracias por jugar");
                    System.exit(0);
                }

            }while(selec==0);
                
                if (respuesta1==1) {
                    JOptionPane.showMessageDialog(null, "CORRECTO");
                    JOptionPane.showInputDialog("1.Buscar canción\n"
                                                +"2. Reproducir canción\n"
                                                +"3. Mostrar Letra\n"
                                                +"4. Detener cancion\n"
                                                +"5. Imprimir Lista de canciones\n"
                                                +"6. Salir\n");

            }else if (respuesta1==2) {
                JOptionPane.showMessageDialog(null, "INCORRECTO.");
                    System.exit(0);
                    selec=2;
                }else if (respuesta1==3) {
                    JOptionPane.showMessageDialog(null, "INCORRECTO.");
                    System.exit(0);
                    selec=2;
                    }
        }while(selec!=2);
    }
}
            

