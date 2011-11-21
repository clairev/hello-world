package com.objet.lofteurs;

public class Jeu {

	public static void main(String args[]){

		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");

		Loft terrain = new Loft ();

		int population_erratique = 100;
		int quantite = 10;

		terrain.initialiser_erratique(population_erratique);
		
		terrain.generernourriture(quantite);

		while (terrain.vieloft != 0){
			
			for (int i=0;i<terrain.Neuneus.size();i++){//on parcourt la liste de neuneus
				terrain.Neuneus.get(i).sedeplacer(); //le neuneu se dŽplace et renvoie s'il est ou pas dans la case d'un partenaire
				terrain.Neuneus.get(i).sereproduire(); // reproduction que s'il y a deux neuneus sur la case (de mme espce)
				terrain.Neuneus.get(i).manger();
				terrain.exclureLoft();
			}
			
			terrain.vieloft-=1;
		}

		System.out.println("la partie est terminŽe");

	}



}
