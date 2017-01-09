
public class Element {
	
	private long id;
	private String photo;
	private String audio;
	private Nature nature;
	private long elementSuivant;
	
	
	public Element(long id, String photo, String audio, Nature nature, long elementSuivant) {
		this.id=id;
		this.photo = photo;
		this.audio = audio;
		this.nature = nature;
		this.elementSuivant = elementSuivant;
		
	}
		
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}



	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	

	public Nature getNature() {
		return nature;
	}
	public void setNature(Nature nature) {
		this.nature = nature;
	}



	public long getElementSuivant() {
		return elementSuivant;
	}
	public void setElementSuivant(long elementSuivant) {
		this.elementSuivant = elementSuivant;
	}



	@Override
	public String toString() {
		return "\n" + id + ", photo=" + photo + ", audio=" + audio + ", nature=" + nature
				+ ", elementSuivant=" + elementSuivant;
	}
	

	


	
}
