import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JPanel;

public class AffichagePhoto extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image=null;
	Graphics grahique;


	public AffichagePhoto(String photo, long id) {
	   
			image = Toolkit.getDefaultToolkit().createImage("photos/"+photo);
	   
			if(!new File("photos/"+photo).exists())
				System.err.println("l'image associée à l'élément "+id+" est introuvable");
		
	}
	
	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (image != null) {
	      g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), this);
	    }
	  }
	  
	  public Image getImage() {
		return image;
	}

	public void setImage(String photo) {
		image = Toolkit.getDefaultToolkit().createImage("photos/"+photo);
	}
}
