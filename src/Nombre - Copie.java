
public class Nombre extends Element{
	private int valeur;
	private String audio;
	private int[] coordonnesClick;
	
	
	public Nombre(long id, String photo, long elementSuivant, int valeur,  String audio, int[] coordonnesClick) {
		super(id, photo, Nature.Nombre, elementSuivant);
		this.valeur = valeur;
		this.audio = audio;
		this.coordonnesClick = coordonnesClick;

	}


	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public int[] getCoordonnesClick() {
		return coordonnesClick;
	}

	public void setCoordonnesClick(int[] coordonnesClick) {
		this.coordonnesClick = coordonnesClick;
	}



	

}
