
public class Teste extends Element{
	
	private int[] reponseCorrecte;
	private int[][] reponsesIncorrectes;
	
	
		public Teste(long id, String photo, String audio, long elementSuivant, int[] reponseCorrecte, int[][]reponsesIncorrectes) {
		super(id, photo, audio, Nature.Teste, elementSuivant);
		this.reponseCorrecte=reponseCorrecte;
		this.reponsesIncorrectes=reponsesIncorrectes;
	}


		public int[] getReponseCorrecte() {
			return reponseCorrecte;
		}


		public void setReponseCorrecte(int[] reponseCorrecte) {
			this.reponseCorrecte = reponseCorrecte;
		}


		public int[][] getReponsesIncorrectes() {
			return reponsesIncorrectes;
		}


		public void setReponsesIncorrectes(int[][] reponsesIncorrectes) {
			this.reponsesIncorrectes = reponsesIncorrectes;
		}

		public String toString() {
			String s= super.toString()+", reponseCorrecte=[ ";
			

			for(int i=0;i<reponseCorrecte.length;i++){
				s+=reponseCorrecte[i];
				if(i<reponseCorrecte.length-1)
					s+=" ";
			}
			s+=" ]";

			s+=", reponsesIncorrectes=[ ";
				
				for(int i=0;i<reponsesIncorrectes.length;i++){
					s+=" (";
					for(int j=0;j<4;j++){
						
						s+=reponsesIncorrectes[i][j];
						if(j<3)
							s+=" ";
					}
					s+=") ";
					if(i<reponsesIncorrectes.length-1)
						s+=" - ";
				}
				s+=" ]";
			return s;
		}

}
