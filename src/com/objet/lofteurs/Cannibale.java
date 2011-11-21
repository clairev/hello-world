package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;


public class Cannibale extends Vorace {
	
	public Cannibale(int e, int ab, int or, Loft lo) {
		super(e,ab,or,lo);
		type = "cannibale";
	}

	public void sedeplacer(){
		
		vientDeSeReproduire ++;
		this.l.energiepas--;


		if (energie < l.energiemax/4.) { //mange un autre cannibale si son Žnergie est faible
		for (Neuneu n : l.Neuneus) {
		if ( Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee)==1) {
		l.demographie--;
		l.Cimetiere.add(n);
		l.Neuneus.remove(n);
		l.plateau_neuneus[abscisse][ordonnee]--;
		return;
		
		// on sort de la boucle for
		// energie (il va manger l'autre)...
		}

		}

		super.sedeplacer();
		}
		}
	
	public void dessinerObjet(Graphics g){
		g.setColor(Color.yellow);
		//g.drawOval(this.getC().getAbscisse()*(600/this.getL().nbCasesLargeur), this.getC().getOrdonnee()*(600/this.getL().nbCasesHauteur), 10, 10);
		//g.drawString("X", 25, 25);
		g.fillOval(this.abscisse*(600/this.l.largeur), this.ordonnee*(600/this.l.hauteur), 600/this.l.largeur, 600/this.l.hauteur);
		}
}

