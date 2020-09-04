import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Principal extends JFrame{
	JLabel messages;
	AffichagePhoto afficheur;
	ArrayList<Element> elements;
	private static final long serialVersionUID = 1L;


	public Principal() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Cursor Curseur;
		Curseur = tk.createCustomCursor(Toolkit.getDefaultToolkit().createImage("photos/souris.png") , new Point( 1, 1 ), "Pointeur" );
		setCursor( Curseur );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		////////////////////////////////////////
		elements=lireFichier("structure");
		/*
		for(int i=0;i<elements.size();i++){
			Element el= elements.get(i);
			System.out.println("\n"+el.getId());
			if(el.getNature()==Nature.Nombre){
				Nombre n=(Nombre) el;
				int[] c=n.getCoordonnesClick();
				for(int i=0;i<c.length;i++)
					System.out.println
			}
			
			
		}*/
		/*
		System.out.println(elements.get(0).toString());

		System.out.println(elements.get(1).toString());
		System.out.println(elements.get(3).toString());*/
		
		Menu premierElement=(Menu)elements.get(0);
		System.out.println("test2");
		afficheur=new AffichagePhoto(premierElement.getPhoto(),0);
		this.add(afficheur, BorderLayout.CENTER);
		messages=new JLabel("default");
		this.add(messages, BorderLayout.SOUTH);
		new lectureAudio(0,"bonjour.mp3",false).start();	
		lectureAudio acceuil=new lectureAudio(0,premierElement.getAudio(),true);
		acceuil.start();
		EcouteurEvenements ecouteur=new EcouteurEvenements(premierElement, acceuil);
		afficheur.addMouseListener(ecouteur);

		this.setBounds(80, 20, 1100, 600);
		this.setVisible(true);
		
		//long[] clq=e.getElementsClicks();
		//System.out.println(clq[0]);
		
		//System.out.println(e.getReponsesIncorrectes()[1][2]);
	/*	
		AffichagePhoto home=new AffichagePhoto("accueil.gif",0);
		
		this.add(home, BorderLayout.CENTER);
		JLabel messages=new JLabel("default");
		this.add(messages, BorderLayout.SOUTH);
		new lectureAudio(0,"bonjour.mp3",false).start();
		lectureAudio acceuil=new lectureAudio(0,"acceuil.mp3",true);
		acceuil.start();
		
		int cordonnees[]={494,584,402,498};
		EcouteurEvenements ecouteur=new EcouteurEvenements(cordonnees,messages,home,acceuil, new lectureAudio(0,"etape1-1.mp3",false) ,"etape1-1.gif");
		home.addMouseListener(ecouteur);
		home.addMouseMotionListener(ecouteur);

		
		
		
		
		*/
	}
	
	public static void main(String[] args) {
		java.net.URL url = ClassLoader.getSystemResource("photos/icon.ico");
		new Principal();
	}
	

private class EcouteurEvenements implements MouseListener,MouseMotionListener{
	
	Nombre nombre = null;
	Teste teste = null;
	Menu menu = null;
	lectureAudio lectureAudio;
	
	
/*	
	EcouteurEvenements(int[] coordonnes, JLabel j, AffichagePhoto jp, lectureAudio lecture,lectureAudio audioSuivant, String imageSuivante){
		this.j=j;
		this.jp=(AffichagePhoto)jp;
		this.lecture=lecture;
		this.audioSuivant=audioSuivant;
		this.imageSuivante=imageSuivante;
		this.coordonnes=coordonnes;
		
	}*/
	
	///********************************
	public EcouteurEvenements(Element element, lectureAudio lectureAudio) {
		// TODO Auto-generated constructor stub
		
		if(element.getNature()==Nature.Menu)
			menu=(Menu)element;
		else{
			if(element.getNature()==Nature.Teste)
				teste=(Teste)element;
			else
				nombre=(Nombre)element;
			
		}
		this.lectureAudio=lectureAudio;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	///+++++++++++++++++++++++++++++++++++++++
	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {/*
		
		if(e.getX()>coordonnes[0] && e.getX()<coordonnes[1] && e.getY()>coordonnes[2] && e.getY()<coordonnes[3] ){

			((AffichagePhoto) jp).setImage(imageSuivante);

			if(lecture!=null)
				lecture.stop();
			jp.repaint();
			
			jp.removeMouseListener(this);
			audioSuivant.start();
			int crd[]={0,200,0,400};//coordonnées
			
			MouseListener ecouteur=new EcouteurEvenements(crd,j, (AffichagePhoto) jp, null, new lectureAudio(0,"etape1-2.mp3", false), "etape1-2.gif");
			jp.addMouseListener(ecouteur);
		
			
		}
		// TODO Auto-generated method stub*/
		messages.setText("cliqué sur "+e.getX()+","+e.getY());
		
		
		if(menu!=null){
			int[][] cliques=menu.getCoordonneesClicks();
			long[] distinataires=menu.getElementsClicks();
			for(int i=0;i<cliques.length;i++){
				Element el=elements.get((int)distinataires[i]);
				
				String photo=el.getPhoto();
				String audio=el.getAudio();
				long id=el.getId();
				boolean siAudioBoucle=false;
				
				if(e.getX()>cliques[i][0] && e.getX()<cliques[i][1] && e.getY()>cliques[i][2] && e.getY()<cliques[i][3] ){
					afficheur.removeMouseListener(this);
					
					if(lectureAudio != null && lectureAudio.isAlive())
						lectureAudio.stop();
					
					lectureAudio=new lectureAudio(id, audio, siAudioBoucle);
					lectureAudio.start();
					afficheur.setImage(photo);
					afficheur.repaint();
					MouseListener ecouteur=new EcouteurEvenements(el, lectureAudio);
					afficheur.addMouseListener(ecouteur);
					System.out.println(el.toString());
				}
			}
		}
		else{
			if(nombre!=null){
				int[] cliques=nombre.getCoordonnesClick();
				long distinataire=nombre.getElementSuivant();
				if(distinataire!=-1){
					Element el=elements.get((int)distinataire);
					
					String photo=el.getPhoto();
					String audio=el.getAudio();
					long id=el.getId();
					//System.out.println(nombre.getCoordonnesClick()[0]);
					boolean siAudioBoucle=false;
					//System.out.println("x:"+e.getX()+"("+cliques[0]+" , "+cliques[1]+") y:"+e.getY()+"("+cliques[2]+" , "+cliques[3]+")");
					if(e.getX()>cliques[0] && e.getX()<cliques[1] && e.getY()>cliques[2] && e.getY()<cliques[3] ){
						afficheur.removeMouseListener(this);
						
						if(lectureAudio != null && lectureAudio.isAlive())
							lectureAudio.stop();
						lectureAudio=new lectureAudio(id, audio, siAudioBoucle);
						lectureAudio.start();
						afficheur.setImage(photo);
						afficheur.repaint();
						MouseListener ecouteur=new EcouteurEvenements(el, lectureAudio);
						afficheur.addMouseListener(ecouteur);
						System.out.println(el.toString());
					}
				}
			}
			else
				if(teste!=null){
					int[][] reponsesIncorrectes=teste.getReponsesIncorrectes();
					int[] reponseCorrecte=teste.getReponseCorrecte();

					long distinataire=teste.getElementSuivant();
					if(distinataire!=-1){
						Element el=elements.get((int)distinataire);
						
						String photo=el.getPhoto();
						String audio=el.getAudio();
						long id=el.getId();
						
						//System.out.println(nombre.getCoordonnesClick()[0]);
						boolean siAudioBoucle=false;
						
						
						if(e.getX()>reponseCorrecte[0] && e.getX()<reponseCorrecte[1] && e.getY()>reponseCorrecte[2] && e.getY()<reponseCorrecte[3] ){
							new lectureAudio(-1, "bravo.mp3", false).start();
							
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							afficheur.removeMouseListener(this);
							
							if(lectureAudio != null && lectureAudio.isAlive())
								lectureAudio.stop();
							lectureAudio=new lectureAudio(id, audio, siAudioBoucle);
							lectureAudio.start();
							afficheur.setImage(photo);
							afficheur.repaint();
							MouseListener ecouteur=new EcouteurEvenements(el, lectureAudio);
							afficheur.addMouseListener(ecouteur);
							System.out.println(el.toString());
						}
						
						for(int i=0;i<reponsesIncorrectes.length;i++){
								if(e.getX()>reponsesIncorrectes[i][0] && e.getX()<reponsesIncorrectes[i][1] && e.getY()>reponsesIncorrectes[i][2] && e.getY()<reponsesIncorrectes[i][3] )
									new lectureAudio(-1, "reponse incorrecte.mp3", false).start();
						}
						
					}
				}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	private ArrayList<Element> lireFichier(String nomFichier){
		/*
		 * 
		 Nombre id photo  idElementSuivant(ou -1)  audio(ou null)  valeur    coordonneésClick(1-2-3-4)
		 Teste  id photo  idElementSuivant(ou -1)  audio(ou null)  réponseCorrecte(1-2-3-4)  réponsesIncorrectes(1[1*2*3*4] - 2[1*2*3*4] --- 
		 Menu id photo audio(ou null) coordonneesclicks(1[1*2*3*4]-2[1*2*3*4])--- elementsClicks(1-2-3-4)
		 *
		 */
		
		ArrayList<Element> resultat=new ArrayList<Element>();
		BufferedReader buffer=null;
		String ligne = null;
		String courant[];		
		Element elementRetenu;
		int tailleTableauGenere;//pour sauvegarder les tailles des tableau générés à partir des lignes de fichies
		
		//pour les nombres
		int[] coordonneesClickNombre = new int[4] ; //pour les nombres
		
		//pour les menus
		int[][] coordonneesClickMenu;
		long[] elementsClickMenu;
		String[] temp2;
		
		//pour les testes
		int[] reponsesCorrectes;
		int[][] reponsesIncorrectes;
		
		/*int[] tst={16,2};
		a.add(tst);
		int taille=a.size();
		int[][] s=new int[taille][];
		for(int i=0;i<a.size();i++)
			s[i]=a.get(i);
		
		System.out.println(s[0][0]);*/
		
		//pour les testes
		int[] reponseCorrecte; //pour les testes
		int[][] reponseIncorrectes; //pour les testes
		String[] temp; //tableau temporaire
		try {
			buffer=new BufferedReader(new FileReader(nomFichier));
			//pour commencer à partir de la 3eme ligne
			ligne=buffer.readLine();
			ligne=buffer.readLine();
			ligne=buffer.readLine();
			ligne=buffer.readLine();
			
			int numLigne=5;
			while ((ligne=buffer.readLine())!=null){
				elementRetenu=null;
				
				courant=ligne.split(" ");
				
				if(courant[0].equals("Nombre")){
					
					coordonneesClickNombre=new int[4];
					temp=courant[6].split("-");
					for (int i=0; i<temp.length;i++) 
						coordonneesClickNombre[i]=Integer.parseInt(temp[i]);
					//System.out.println(coordonneesClickNombre[0]);
					elementRetenu=new Nombre(
							Long.parseLong(courant[1]),//id
							courant[2],//photo
							courant[3],//audio
							Long.parseLong(courant[4]),//element suivant
							(int)Long.parseLong(courant[5]),//valeur
							coordonneesClickNombre //coordonnées de clique actif
							);
					
					
					
				}
				else{
					if(courant[0].equals("Menu")){

						
						// la génération du tableau des coordonnées des clicks
						temp=courant[4].split("-");
						tailleTableauGenere=temp.length;
						coordonneesClickMenu=new int[tailleTableauGenere][];
						for(int i=0; i<coordonneesClickMenu.length;i++){
							temp2=temp[i].split(":");
							coordonneesClickMenu[i]=new int[4];
							for(int j=0;j<temp2.length;j++){
								coordonneesClickMenu[i][j]=Integer.parseInt(temp2[j]);
							}
								
						}
						
						//la listes des elements suivants après les clicks
						temp=courant[5].split("-");
						tailleTableauGenere=temp.length;
						elementsClickMenu=new long[tailleTableauGenere];
						for(int i=0;i<tailleTableauGenere;i++)
							elementsClickMenu[i]=Long.parseLong(temp[i]);
						
						elementRetenu= new Menu(
								Long.parseLong(courant[1]),//id
								courant[2],//photo
								courant[3],//audio
								coordonneesClickMenu,//emplacement cliquables
								elementsClickMenu //destionations des clicks
								);			
						
						
					
					}
					else{
					  if(courant[0].equals("Teste")){
					  
											
						//la listes des réponses  correctes
						temp=courant[5].split("-");
						tailleTableauGenere=temp.length;
						reponseCorrecte=new int[tailleTableauGenere];
						for(int i=0;i<tailleTableauGenere;i++)
							reponseCorrecte[i]=Integer.parseInt(temp[i]);
						
						//la liste des réponses incorrectes
						
						temp=courant[6].split("-");
						tailleTableauGenere=temp.length;
						reponseIncorrectes=new int[tailleTableauGenere][];
						for(int i=0; i<tailleTableauGenere;i++){
							temp2=temp[i].split(":");
							reponseIncorrectes[i]=new int[4];
							for(int j=0;j<temp2.length;j++){
								reponseIncorrectes[i][j]=Integer.parseInt(temp2[j]);
							}
								
						}
						
						elementRetenu= new Teste(
								Long.parseLong(courant[1]),//id
								courant[2],//photo
								courant[3],//audio
								Long.parseLong(courant[4]),//element suivant
								reponseCorrecte,//emplacement cliquables
								reponseIncorrectes //destionations des clicks
								);
					  }
					  else
						  System.err.println("erreur à la ligne "+numLigne);
						
					}
					
				}
				
				if(elementRetenu!=null)
					resultat.add((int)elementRetenu.getId(), elementRetenu);
				/*if(elementRetenu.getNature()==Nature.Nombre){
					System.out.println(elementRetenu.getId()+"  "+((Nombre)elementRetenu).getCoordonnesClick()[1]+" "+((Nombre)elementRetenu).getPhoto());
					System.out.println(resultat.get((int)elementRetenu.getId()).getId()+"  "+((Nombre)resultat.get((int)elementRetenu.getId())).getCoordonnesClick()[1]+" "+((Nombre)resultat.get((int)elementRetenu.getId())).getPhoto());
					if(elementRetenu.getId()==2)
						System.out.println(resultat.get((int)elementRetenu.getId()-1).getId()+"  "+((Nombre)resultat.get((int)elementRetenu.getId()-1)).getCoordonnesClick()[1]+" "+((Nombre)resultat.get((int)elementRetenu.getId()-1)).getPhoto());
					
				}*/
			numLigne++;		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return resultat;
		
	}

}
