
public class Menu extends Element{
	
	private int[][] coordonneesClicks;
	private long[] elementsClicks;
	public Menu(long id, String photo, String audio, int[][] coordonneesClicks, long[] elementsClicks) {
		super(id, photo, audio, Nature.Menu, -1);
		this.coordonneesClicks=coordonneesClicks;
		this.elementsClicks=elementsClicks;
	}

	
	public int[][] getCoordonneesClicks() {
		return coordonneesClicks;
	}
	public void setCoordonneesClicks(int[][] coordonneesClicks) {
		this.coordonneesClicks = coordonneesClicks;
	}
	public long[] getElementsClicks() {
		return elementsClicks;
	}
	public void setElementsClicks(long[] elementsClicks) {
		this.elementsClicks = elementsClicks;
	}


	@Override
	public String toString() {
		String s= super.toString()+", coordonnéesClicks=[ ";
			for(int i=0;i<coordonneesClicks.length;i++){
				s+=" (";
				for(int j=0;j<4;j++){
					
					s+=coordonneesClicks[i][j];
					if(j<3)
						s+=" ";
				}
				s+=") ";
				if(i<coordonneesClicks.length-1)
					s+=" - ";
			}
			s+=" ]";
			s+=", elementsClicks=[ ";
			for(int i=0;i<elementsClicks.length;i++){
				s+=elementsClicks[i];
				if(i<elementsClicks.length-1)
					s+=" ";
			}
			s+=" ]";
				
		return s;
	}

}
