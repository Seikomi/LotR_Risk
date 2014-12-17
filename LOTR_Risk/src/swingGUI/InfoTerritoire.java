package swingGUI;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import objects.Territoire;

public class InfoTerritoire extends Box{
	private static final long serialVersionUID = -4964455710886964644L;
	private ArrayList<Territoire> listeTerritoire;

	public InfoTerritoire(ArrayList<Territoire> listeTerritoire) {
		super(BoxLayout.PAGE_AXIS);
		this.listeTerritoire = listeTerritoire;
		
		for (Territoire territoire : this.listeTerritoire) {
			JLabel nomJoueurJLabel = new JLabel("  " + territoire.getNom());
			this.add(nomJoueurJLabel);
		}
		
		
	}
	
	
}
