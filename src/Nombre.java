
public class Nombre extends Element{
	private int valeur;
	private int[] coordonnesClick;
	
	
	public Nombre(long id, String photo, String audio, long elementSuivant, int valeur, int[] coordonnesClick) {
		super(id, photo, audio, Nature.Nombre, elementSuivant);
		this.valeur = valeur;
		this.coordonnesClick = coordonnesClick;

	}


	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}



	public int[] getCoordonnesClick() {
		return coordonnesClick;
	}

	public void setCoordonnesClick(int[] coordonnesClick) {
		this.coordonnesClick = coordonnesClick;
	}


	public String toString() {
		String s= super.toString()+", valeur= "+valeur;
			s+=", coordonneesClick=[ ";
			for(int i=0;i<coordonnesClick.length;i++){
				s+=coordonnesClick[i];
				if(i<coordonnesClick.length-1)
					s+=" ";
			}
			s+=" ]";
				
		return s;
	}
	

}
