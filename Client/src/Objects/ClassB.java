package Objects;

import java.awt.Graphics2D;
import java.util.Random;

import DataStructures.DoubleLinkedList;


public class ClassB extends InvaderLine implements Drawable {
	private boolean change;
	private int bossIndex;
	
	public ClassB(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new DoubleLinkedList<>());
		while(counter < size) {

			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.change = false;
		Random rand = new Random();
		int randBoss = rand.nextInt(this.getEnemies().size()-1);
		this.getEnemies().get(randBoss).setBoss();
		this.setHaveBoss(true);
		this.bossIndex = randBoss;
		this.setLineClass("ClassB");
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
		for(int i = 0; i < this.getEnemies().size(); i++) {
			this.getEnemies().get(i).setPosY(this.getEnemies().get(i).getPosY()+this.getSpeed());
			this.getEnemies().get(i).update(delta);
			if(this.getEnemies().get(i).isBoss()) {
				this.setHaveBoss(true);
			}
		}

		if(this.getTimer().timerEvent(350)) {
			if (change && this.getEnemies().size() > 1) {
				Random rand = new Random();
				int newPos = rand.nextInt(this.getEnemies().size() - 1);
				this.getEnemies().swap(bossIndex, newPos);
				bossIndex = newPos;
				change = false;
			} else {
				change = true;
			}
		}
	}
}
