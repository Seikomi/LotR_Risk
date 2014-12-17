package swingGUI;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import objects.Joueur;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import utils.LOTR_Data;

public class InfoJoueur extends Box {
	private static final long serialVersionUID = 6412467141232271552L;
	private ArrayList<Joueur> joueurData;
	private LOTR_Data data;
	private ChartPanel chartPanel;
 	
	public InfoJoueur() {
		this(null);
	}
	
	public InfoJoueur(ArrayList<Joueur> joueurData) {

		
		super(BoxLayout.PAGE_AXIS);
		
		this.setSize(20, 20);
		
		this.joueurData = joueurData;
		this.data = new LOTR_Data();
		
		DefaultPieDataset pieDataset = new DefaultPieDataset();		
		for (Joueur joueur : this.joueurData) {
			JLabel nomJoueurJLabel = new JLabel(joueur.getNom());
			nomJoueurJLabel.setForeground(Color.decode(joueur.getCouleurRGB()));
			this.add(nomJoueurJLabel);
			
			JLabel nombreTotalUnitesJLabel = new JLabel("    Nombre total d'unités : " + String.valueOf(joueur.getNb_unites()));
			nombreTotalUnitesJLabel.setForeground(Color.decode(joueur.getCouleurRGB()));
			this.add(nombreTotalUnitesJLabel);
			
			JLabel nombreUnitesParTourJLabel = new JLabel("    Renforts/Tour : " + String.valueOf(data.calculer_Renforts(joueur)));
			nombreUnitesParTourJLabel.setForeground(Color.decode(joueur.getCouleurRGB()));
			this.add(nombreUnitesParTourJLabel);
			
			int territoryPercentage = joueur.getNb_Territoire() / this.data.NOMBRE_TERRITOIRES;
			
			pieDataset.setValue(joueur.getNom(), new Integer(75));
		}
		
		pieDataset.setValue("Neutre", new Integer(75));
		JFreeChart chart = ChartFactory.createPieChart
						("",    				// Title
						pieDataset, 			// Dataset
						false,					// Show legend
						false,					// Use tooltips
						false					// Configure chart to generate URLs?
						);
		
		this.chartPanel = new ChartPanel(chart);
		
		this.chartPanel.setVisible(true);
		
		this.add(this.chartPanel);

	}
	
	

}
