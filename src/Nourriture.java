import java.awt.Color;
import java.awt.Graphics;


public class Nourriture implements ObjetDessinable {

	public int calorie;
	//public Case c;
	public String typenourriture;

	
public Nourriture(int cal) {
	calorie=cal;
//	c.casehasard();
	}
	
	
/*public void nourriturehasard(){
	calorie = (int)Math.random()*(300);
//	c.casehasard();
	}*/

public void dessinerObjet(Graphics g){
	Color c = g.getColor();
	g.setColor(Color.RED);
	g.fillRect(10,10,80,80);
	g.setColor(Color.BLUE);
	g.fillOval(150,50,80,80);
	g.setColor(c);}
		
}

