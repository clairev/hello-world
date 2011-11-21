package com.objet.lofteurs;




public abstract class Neuneu implements ObjetDessinable {

	public int abscisse;
	public int ordonnee;
	public int energie;
	public String type;
	public Loft l;
	public int vientDeSeReproduire;


	
	public Neuneu (int e, int ab, int or, Loft lo) {
		abscisse =ab;
		ordonnee=or;
		energie=e;
		l = lo;
		vientDeSeReproduire=100;
		this.l.zone.ajouterObjet(this);
	}
	
	public Neuneu (int e, int ab, int or, Loft lo, int vdsr) {
		abscisse =ab;
		ordonnee=or;
		energie=e;
		l = lo;
		vientDeSeReproduire= vdsr;
	}
	
	
	
	
	public void sedeplacer(){}
	
	public void manger(){
		if (l.plateau_nourriture[abscisse][ordonnee]!=null) {

			Nourriture n = l.plateau_nourriture[abscisse][ordonnee];
			if (n.calorie >0 && this.energie<l.energiemax) {
				n.calorie--;
				this.energie++;
			}
		}
	}

			/*
			 * code pour manger toutes les calories
			 * 
			if (this.energie<l.energiemax) {
				int a_manger = n.calorie;
				if (energie+a_manger>l.energiemax) a_manger = l.energiemax-energie;
				this.energie+= a_manger;
				n.calorie -= a_manger;
			}
		}
			 */ 
		

	public void sereproduire(){
		// choisir l'énergie du bébé

		if (l.plateau_neuneus[abscisse][ordonnee] > 1 && vientDeSeReproduire > 5) { // alors il y en a au moins 2

		if (type == "lapin") {
		Lapin nouveau_lapin = new Lapin (energie, abscisse, ordonnee,l,0);
		nouveau_lapin.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_lapin);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "erratique") {
		Erratique nouveau_erratique = new Erratique (energie, abscisse, ordonnee,l);
		nouveau_erratique.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_erratique);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "vorace") {
		Vorace nouveau_vorace = new Vorace (energie, abscisse, ordonnee,l);
		nouveau_vorace.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_vorace);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}
		else if (type == "cannibale") {
		Cannibale nouveau_cannibale = new Cannibale (energie, abscisse, ordonnee,l);
		nouveau_cannibale.vientDeSeReproduire=0;
		l.Neuneus.add(nouveau_cannibale);
		l.demographie++;
		l.plateau_neuneus[abscisse][ordonnee]++;
		this.vientDeSeReproduire=0;
		}

		for (Neuneu n : l.Neuneus) {
		if (n.abscisse == abscisse && n.ordonnee == ordonnee) {
		n.vientDeSeReproduire=0; // je mets tous ceux qui sont sur la même case comme venant de se reproduire
		}
		}
		}


		}
}
	

