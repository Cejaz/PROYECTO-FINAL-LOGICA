import javax.swing.JOptionPane;

public class prueba {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,        " ╔═════════════════════════╗\n"                                                
	                                            + " ║           BIENVENIDOS!            ║\n"       
	                                            + " ╚═════════════════════════╝\n");

		JOptionPane.showMessageDialog(null,"                                                        █  █▀█ █▀█ █▀▀ █▀▀ █ █ █▄ █ ▀█▀ ▄▀█ █▀▄ █▀█ █▀  █ ");
		JOptionPane.showMessageDialog(null,"                                                        █  █▀▀ █▀▄ ██▄ █▄█ █▄█ █ ▀█  █  █▀█ █▄▀ █▄█ ▄█  █ ");
		JOptionPane.showMessageDialog(null,"                                                        █                                               █ ");
		JOptionPane.showMessageDialog(null,"                                                        █            █▀▄▀█ █ █ █▀ █ █▀▀ ▄▀█ █           █ ");
		JOptionPane.showMessageDialog(null,"                                                        █            █   █ █▄█ ▄█ █ █▄▄ █▀█ █▄▄         █ \n");
		

		JOptionPane.showMessageDialog(null,"                                                                BIENVENIDO A PREGUNTADOS MUSICAL! \n\n");
        JOptionPane.showMessageDialog(null,"Para continuar con el programa tienes que responder una pregunta de cultura general basica!, si no la respondes correctamente no te permitiremos el ingreso a nuestro\npreguntados. VAMOS!!! \n");
        
        String respuesta1;

        respuesta1 = JOptionPane.showInputDialog("1 ¿Cuáles son los cinco tipos de sabores primarios?\n"
                                + "a) dulce, amargo, ácido, salado y umami*\n"
                                + "b) dulce, picante, salado, amargo\n"
                                + "c) fuerte, suave, dulce, salado").toUpperCase();

                switch (respuesta1){
                    case "A" -> JOptionPane.showMessageDialog(null,"Correcto");
                
                    case "B" -> JOptionPane.showMessageDialog(null,"Incorrecto por favor vuelve a intentarlo");
                        
                    case "C" -> JOptionPane.showMessageDialog(null,"incorrecto");
        
                    default -> JOptionPane.showMessageDialog(null,"salir");
        }
                
                
                
        //System.out.println("                                                            1. Buscar canción");
		//System.out.println("                                                            2. Reproducir canción");
		//System.out.println("                                                            3. Mostrar Letra");
		//System.out.println("                                                            4. Detener Canción");
		//System.out.println("                                                            5. Imprimir lista de Canciones");
		//System.out.println("                                                            6. Salir\n");
    }
}