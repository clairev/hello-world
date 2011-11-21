package com.objet.lofteurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.objet.lofteurs.ObjetDessinable;


public class Loft implements ObjetDessinable{
	
	public int hauteur;
	public int largeur;
	public int energiemin;
	public int energiemax;
	public int energiereproduction;
	public int energiepas;
	public int vieloft; //durée de vie du loft
	public int quantite;
	public int demographie;
	public Nourriture n;
	public ArrayList<Neuneu> Cimetiere = new ArrayList<Neuneu>();
	public ArrayList<Neuneu> Neuneus = new ArrayList<Neuneu>();
	public ZoneGraphique zone;
	
	public int [] [] plateau_neuneus = new int[largeur][hauteur]; // contient le nombre de neuneus dans une case
	
	public Nourriture [] [] plateau_nourriture = new Nourriture[largeur][hauteur]; // contient la nourriture dans les cases
	
	
	//constructeur du loft
	public Loft (){
		hauteur = 10;
		largeur = 10;
		energiemin = 10;
		energiemax = 10;
		energiereproduction =5;
		energiepas =1;
		vieloft = 100;
		quantite  =25;
		demographie = 0;
	}
	
	/*
	public void adderratique(){ 		//création d'un erratique "standard"
		Erratique e = new Erratique(10);
		e.type="Erratique";
		e.c.casehasard();
		Neuneus.add(e);
		this.demographie++;
	}
	*/
	
	
	
	
	public void exclureLoft(){
		for (int i=0; i<demographie; i++) {
		if (Neuneus.get(i).energie<energiemin){
		Cimetiere.add(Neuneus.get(i));
		Neuneus.remove(i);
		demographie--;}
		}
		}
	
	public void generernourriture(int quantite){ //nombre *moyen* de nourritures dans le jeu à l'initialisation
		double moy = ((double) quantite)/((double) largeur*hauteur);
		for (int i=0;i<largeur;i++){ //ajout de nourritures dans le jeu
			for (int j =0; j<hauteur; j++) {
				double rand = Math.random();
				if (rand < moy) {
					Nourriture n = new Nourriture (10);
					plateau_nourriture[i][j] = n;
				}
			}
		}
	}
	

	public void initialiser_erratique(int population_erratique){ //nombre *moyen* d'erratiques dans le jeu à l'initialisation
		double moy = ((double) population_erratique)/((double) largeur*hauteur);
		for (int i=0;i<largeur;i++){ //ajout des erratiques dans le jeu
			for (int j =0; j<hauteur; j++) {
				double rand = Math.random();
				if (rand < moy) {
					Erratique e = new Erratique (10,i,j,this);
					Neuneus.add(e);
					plateau_neuneus[i][j] ++;
					demographie++;
				}
			}
		}
	}
	
	public void initialiser_lapin(int population_lapin){ //nombre *moyen* d'erratiques dans le jeu à l'initialisation
		double moy = ((double) population_lapin)/((double) largeur*hauteur);
		for (int i=0;i<largeur;i++){ //ajout des erratiques dans le jeu
			for (int j =0; j<hauteur; j++) {
				double rand = Math.random();
				if (rand < moy && plateau_neuneus[i][j]==0) {
					Lapin la = new Lapin (10,i,j,this);//pb s'il y a déjà un erratique sur la case
					Neuneus.add(la);
					plateau_neuneus[i][j] ++; 
					demographie++;
				}
			}
		}
	}
	
	public void initialiser_vorace(int population_vorace){ //nombre *moyen* d'erratiques dans le jeu à l'initialisation
		double moy = ((double) population_vorace)/((double) largeur*hauteur);
		for (int i=0;i<largeur;i++){ //ajout des erratiques dans le jeu
			for (int j =0; j<hauteur; j++) {
				double rand = Math.random();
				if (rand < moy) {
					Vorace v = new Vorace (10,i,j,this);
					Neuneus.add(v);
					plateau_neuneus[i][j] ++;
					demographie++;
				}
			}
		}
	}
	
	
	public void initialiser_cannibale(int population_cannibale){ //nombre *moyen* d'erratiques dans le jeu à l'initialisation
		double moy = ((double) population_cannibale)/((double) largeur*hauteur);
		for (int i=0;i<largeur;i++){ //ajout des erratiques dans le jeu
			for (int j =0; j<hauteur; j++) {
				double rand = Math.random();
				if (rand < moy) {
					Cannibale ca = new Cannibale (10,i,j,this);
					Neuneus.add(ca);
					plateau_neuneus[i][j] ++;
					demographie++;
				}
			}
		}
	}
	
	
	public void dessinerObjet(Graphics g) {
		this.drawTable(g);

		}

		public void drawTable(Graphics g){
		g.setColor(Color.white);
		for (int i=1; i<600;i++){
		g.drawLine(i*(600/hauteur),0,i*(600/hauteur), 600*(600/hauteur));}

		for (int j=1; j<600;j++){
		g.drawLine(0, j*(600/largeur),600*(600/largeur), j*(600/largeur));
		}

		}
		}



	
