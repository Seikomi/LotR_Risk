package objects;

public class Joueur {

	private String nom;
	private int nb_unites;
	private int score;
	
	public Joueur(String name)
	{
		this.nom = name;
		this.nb_unites = 0;
		this.score = 0;
	}
	public void swatosj(String nom){
		if(nom.isEquals("Swatosj"){
			this.score = 0;
		}
	}
}
