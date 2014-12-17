package swingGUI;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import objects.Joueur;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 2563377374330561999L;
	private ArrayList<Joueur> listeJoueur;
	
	public MainWindow(ArrayList<Joueur> listeJoueur) {
		super();
		this.listeJoueur = listeJoueur;
		
		this.setSize(400,400);                                                     
		this.setTitle("LotR_Risk");                           
		this.setLayout(new BorderLayout());                                                                        
		                                                      
		
		InfoJoueur infoJoueurBox = new InfoJoueur(this.listeJoueur);
		
		
		Box log = Box.createHorizontalBox();
		
		
		JLabel str = new JLabel("Attente connexion...");
		log.add(str);
		
		ImageIcon img = new ImageIcon("map.jpg");
		
		Map mapPannel = new Map(img);
		
		
		this.add(infoJoueurBox, BorderLayout.WEST);
		this.add(mapPannel, BorderLayout.CENTER);
		this.add(log, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void repaint() {
		
		super.repaint();
	}
	
	
	
}


