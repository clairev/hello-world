package com.objet.lofteurs;


import java.awt.Color;
import java.awt.Graphics;



public class Erratique extends Neuneu  {

	public Erratique(int e, int ab, int or, Loft lo){	
		super(e,ab,or,lo);
		type ="erratique";
	}


	public void sedeplacer(){
		vientDeSeReproduire ++;
		this.l.energiepas--;
		for (Neuneu n : l.Neuneus) { // si il a un voisin de la même espèce que lui
			if (Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee)==1 && n.type=="Erratique") {
			l.plateau_neuneus[abscisse][ordonnee]--;
			abscisse = n.abscisse;
			ordonnee = n.ordonnee;
			return;
			}
			}

		int compt = 0; // nombre de cases voisines accessibles, vaut entre 0 et 4
		for (int i = -1; i <=1; i=i+2) {
			if (abscisse+i >=0 && abscisse+i < l.largeur && l.plateau_neuneus[abscisse+i][ordonnee]==0)
				compt++;
		}
		for (int j=-1; j<=1; j=j+2) {
			if ( ordonnee+j >=0 && ordonnee +j < l.hauteur && l.plateau_neuneus[abscisse][ordonnee+j]==0)
				compt++;
		}
		if (compt==0) {
			// je ne peux pas me déplacer
		}
		else {
			int random_direction = (int) Math.random()*(compt-1)+1; // nombre au hasard entre 1 et compt
			compt=0;
			for (int i = -1; i <=1; i=i+2) {
				if (abscisse+i >=0 && abscisse+i < l.largeur && l.plateau_neuneus[abscisse+i][ordonnee]==0) {
					compt++;
					if (compt==random_direction) {
						l.plateau_neuneus[abscisse][ordonnee]--;
						abscisse = abscisse+i;
						l.plateau_neuneus[abscisse][ordonnee]++;
					}

				}
			}
			for (int j=-1; j<=1; j=j+2) {
				if ( ordonnee+j >=0 && ordonnee +j < l.hauteur && l.plateau_neuneus[abscisse][ordonnee+j]==0) {
					compt++;
					if (compt==random_direction) {
						l.plateau_neuneus[abscisse][ordonnee]--;
						ordonnee = ordonnee+j;
						l.plateau_neuneus[abscisse][ordonnee]++;
					}

				}
			}

		}
		
		public void dessinerObjet(Graphics g){
			g.setColor(Color.red);
			//g.drawOval(this.getC().getAbscisse()*(600/this.getL().nbCasesLargeur), this.getC().getOrdonnee()*(600/this.getL().nbCasesHauteur), 10, 10);
			//g.drawString("X", 25, 25);
			g.fillOval(this.abscisse*(600/this.l.largeur), this.ordonnee*(600/this.l.hauteur), 600/this.l.largeur, 600/this.l.hauteur);
			}


	
	}
}


