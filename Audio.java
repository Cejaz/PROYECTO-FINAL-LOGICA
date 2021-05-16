import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Audio extends Thread{
	
	//https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Sequencer.html
	private String sonido;	
	private Sequencer sequencer;
	private boolean esta_reproduciendose;
	private long tiempo;

	public void seleccionarCancion(String ruta_cancion){
		sonido = ruta_cancion;
	}

	public void empezar(int posicion)
	{
		if(!esta_reproduciendose)
		{
			try {
	        	sequencer = MidiSystem.getSequencer(); // Get the default Sequencer

	            if (sequencer==null) {
	                System.err.println("Sequencer device not supported");
	                return;
	            } 
	            sequencer.open(); // Open device
	            // Create sequence, the File must contain MIDI file data.
	            Sequence sequence = MidiSystem.getSequence(new File(sonido));
	            sequencer.setSequence(sequence); // load it into sequencer
	            if(posicion>0)
	            {
	            	sequencer.setTickPosition(posicion);
	            }
	            sequencer.start();  // start the playback
	            esta_reproduciendose = true;

	        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
	            //ex.printStackTrace();
	            System.out.println("Error al reproducir el archivo, revise la ruta y vuelva a intentarlo.");
	            esta_reproduciendose = false;
	        }
		}
		else{
			System.out.println("Hay un archivo actualmente en reproducci\u00f3n");
			System.out.println("Detenga la canci\u00f3n y seleccione una nueva");
		}
	}

	public void detener(){
		if(sequencer!=null)
    	{
        	if(sequencer.isOpen())
        	{
        		sequencer.stop();
        		sequencer.close();
        	}
    	}
    	esta_reproduciendose = false;
	}

	public void empezarHilo()
	{
		if(!esta_reproduciendose)
		{
			this.start();
		}
		//System.out.println(this.getState());
	}

	public void reproducir(){
		empezar(0);
		empezarHilo();
	}

	public void fragmentoAleatorio(){
		empezar(RandomHelper.random(0,(int)sequencer.getTickLength()));
		empezarHilo();
	}

	public void run(){

		//System.out.println(esta_reproduciendose);
		while(esta_reproduciendose){
			if(sequencer != null)
			{
				if(!sequencer.isRunning())
				{
					System.out.println("Se detuvo la canci\u0073n");
					detener();
					//System.out.print(sequencer.getTickPosition()+"/"+sequencer.getTickLength());
					//System.out.print("\r");
				}
				else
				{
					System.out.println("posicion "+sequencer.getTickPosition());
					System.out.println("longitud "+sequencer.getTickLength());
				}
			}
		}
	}
}