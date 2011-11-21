
public class Lapin extends Neuneu {

		
	public Lapin(int e, int ab, int or, Loft lo) {
		super(e, ab, or, lo);
		type = "lapin";
	}

	public void sedeplacer(){

		//ils cherchent surtout un partenaire pour se reproduire
		//le lapin se déplace à la position du partenaire le plus proche

		vientDeSeReproduire ++;
		this.l.energiepas--;


		if (vientDeSeReproduire < 5) { // s'il n'a pas envie de se reproduire, il erre au hasard mais sur des cases vides
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
		}
			
		

		else { // s'il a envie de se reproduire -> il cherche le partenaire le plus proche

			int plus_proche = l.hauteur+l.largeur+1;
			Neuneu lapin_plus_proche = null;

			for (Neuneu n : l.Neuneus) {
				if (n.type == "lapin") {
					int distancecourante = Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee); // on se déplace pas en diagonale
					if (distancecourante < plus_proche && distancecourante >0) {
						plus_proche = distancecourante;
						lapin_plus_proche = n;
					}
				}
			}

			if (lapin_plus_proche != null && plus_proche >1) {
				if (lapin_plus_proche.abscisse > abscisse && l.plateau_neuneus[abscisse+1][ordonnee]==0) {
					l.plateau_neuneus[abscisse][ordonnee]--;
					abscisse ++;	
					l.plateau_neuneus[abscisse][ordonnee]++;
				}
				else if (lapin_plus_proche.abscisse < abscisse  && l.plateau_neuneus[abscisse-1][ordonnee]==0) {
					l.plateau_neuneus[abscisse][ordonnee]--;
					abscisse --;
					l.plateau_neuneus[abscisse][ordonnee]++;
				}
				else if (lapin_plus_proche.ordonnee > ordonnee &&  l.plateau_neuneus[abscisse][ordonnee+1]==0) {
					l.plateau_neuneus[abscisse][ordonnee]--;
					ordonnee ++;
					l.plateau_neuneus[abscisse][ordonnee]++;
				}
				else if (lapin_plus_proche.ordonnee < ordonnee && l.plateau_neuneus[abscisse][ordonnee-1]==0) {
					l.plateau_neuneus[abscisse][ordonnee]--;
					ordonnee --;
					l.plateau_neuneus[abscisse][ordonnee]++;
				}
			}

			if (plus_proche==1) {
				l.plateau_neuneus[abscisse][ordonnee] --;
				abscisse = lapin_plus_proche.abscisse;
				ordonnee = lapin_plus_proche.ordonnee;
				l.plateau_neuneus[abscisse][ordonnee]++;
			}

			
		}
	



	}
	
		
	}



		


