package Objects;

import java.awt.Graphics2D;
import java.util.Random;

import DataStructures.CircleList;

public class ClassC extends InvaderLine implements Drawable {
	public ClassC(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new CircleList<Invader>());
		while(counter < size) {
		;
			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.getEnemies().get(size/2).setBoss();
		this.setHaveBoss(true);
		this.setLineClass("ClassC");
	}
	
	@ Override
	public void draw(Graphics2D g) {
		for(int i = 0; i < this.getEnemies().size(); i++) {
			this.getEnemies().get(i).draw(g);
		}
	}
	
	@ Override
	public void update(double delta) {
		this.setHaveBoss(false);
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY()+this.getSpeed());
			this.getEnemies().get(c).update(delta);
			if(this.getEnemies().get(c).isBoss()) {
				this.setHaveBoss(true);;
			}
		}
		Random rand = new Random();
		if(!this.isHaveBoss() && this.getEnemies().size() != 1) {
			int newBoss = rand.nextInt(this.getEnemies().size()-1);
			this.getEnemies().get(newBoss).setBoss();
		} else if(!this.isHaveBoss() && this.getEnemies().size() == 1) {
			this.getEnemies().get(0).setBoss();
		}
		this.arrangeLine();


	}
}
