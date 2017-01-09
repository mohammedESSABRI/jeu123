import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class lectureAudio extends Thread {
	long id;
	String audio;
	boolean boucle;
	
	public lectureAudio(long id, String audio, boolean boucle){
		this.id=id;
		this.audio=audio;
		this.boucle=boucle;
		
	}
	public void run(){
		boolean fichierExiste=new File("audio/"+audio).exists();
		lecture("audio/"+audio);
		while(boucle && fichierExiste)
			lecture("audio/"+audio);
		
	}
	
    public void lecture(String chemin){
    	File fichier = new File(chemin);
    	try {
			InputStream iFichier = new FileInputStream(fichier);
			BufferedInputStream BFichier= new BufferedInputStream(iFichier);
			Player lecteur=new Player(BFichier);
			lecteur.play();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("l\'audio associé à l'élément "+id+" est introuvable");
			
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
