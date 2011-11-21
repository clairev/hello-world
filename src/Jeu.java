public class Jeu {

	public static void main(String args[]){

		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");

		Loft terrain = new Loft ();

		int population = 100;

		terrain.initialiser(population);

		while (terrain.vieloft != 0){
			for (int i=0;i<terrain.Neuneus.size();i++){ //on parcourt la liste de neuneus
				terrain.Neuneus.get(i).sedeplacer(); //le neuneu se dŽplace et renvoie s'il est ou pas dans la case d'un partenaire
				if (reproduction==true) terrain.Neuneus.get(i).sereproduire();
				terrain.Neuneus.get(i).manger();
				terrain.exclureLoft();
			}
			terrain.vieloft-=1;
		}

		System.out.println("la partie est terminŽe");

	}



}
