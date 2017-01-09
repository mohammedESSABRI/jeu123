import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Contenu extends JPanel {

	JButton bouton=new JButton("kkk");
	CardLayout couche= new CardLayout();
	public Contenu() {

		this.setLayout(new CardLayout());
		JLabel photo = new JLabel("photos");
	
	}
	
}
