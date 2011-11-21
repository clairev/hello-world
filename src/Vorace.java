
	public class Vorace extends Erratique {

		public Vorace(int e, int ab,int or,Loft lo) {
		super(e,ab,or,lo);
		type="vorace";
		}


		public void sedeplacer(){

		//ils cherchent surtout un partenaire pour se reproduire
		//le lapin se déplace à la position du partenaire le plus proche

			vientDeSeReproduire ++;
			this.l.energiepas--;


		// cherche la case voisine innocuppée avec le plus de nourriture
		int cal_max = l.plateau_nourriture[abscisse][ordonnee].calorie;
		int i_max=0, j_max=0;
		for (int i =-1; i<=1; i=i+2) {
		if (abscisse+i >=0 && abscisse+i < l.largeur && l.plateau_neuneus[abscisse+i][ordonnee]==0) {
		int cal_courant = l.plateau_nourriture[abscisse+i][ordonnee].calorie;
		if (cal_courant > cal_max) {
		cal_max = cal_courant;
		i_max = abscisse+i;
		j_max = ordonnee;
		}
		}
		}

		for (int j =-1; j<=1; j=j+2) {
		if (ordonnee+j >=0 && ordonnee+j < l.largeur && l.plateau_neuneus[abscisse][ordonnee+j]==0) {
		int cal_courant = l.plateau_nourriture[abscisse][ordonnee+j].calorie;
		if (cal_courant > cal_max) {
		cal_max = cal_courant;
		i_max = abscisse;
		j_max = ordonnee+j;
		}
		}
		}

		boolean parmi_voisins = false;


		for (Neuneu n : l.Neuneus) { // si il a un voisin de la même espèce que lui
		if (Math.abs(n.abscisse-abscisse)+Math.abs(n.ordonnee-ordonnee)==1 && n.type=="vorace") {
		int cal_courant = l.plateau_nourriture[n.abscisse][n.ordonnee].calorie;
		if (cal_courant > cal_max || cal_max==0) {
		cal_max = cal_courant;
		i_max = n.abscisse;
		j_max = n.ordonnee;
		parmi_voisins = true;
		}
		}
		}

		if (cal_max >0 || parmi_voisins==true) { // s'il y a une case avec de la nourriture près de lui ou au pire qqn de la même espèce
		l.plateau_neuneus[abscisse][ordonnee]--;
		abscisse = i_max;
		ordonnee = j_max;
		l.plateau_neuneus[abscisse][ordonnee]++;
		}

		else { // déplacement aléatoire
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

	



		}






		}

