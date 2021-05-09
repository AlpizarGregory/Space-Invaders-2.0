package Objects;

import java.awt.Graphics2D;
import java.util.Random;

import DataStructures.DoubleLinkedList;

public class ClassE extends InvaderLine implements Drawable {
	private double angle;

	public ClassE(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new DoubleLinkedList<Invader>());
		while(counter < size) {
			Random rand = new Random();

			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.setPosY(-70);
		Random rand = new Random();
		int newBoss = rand.nextInt(size-1);
		this.getEnemies().get(newBoss).setBoss();
		this.setHaveBoss(true);
		this.setLineClass("ClassE");
	}

	@Override
	public void draw(Graphics2D g) {
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).draw(g);
		}
	}

	@Override
	public void update(double delta) {
		this.setHaveBoss(false);
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY()+this.getSpeed());
			this.getEnemies().get(c).update(delta);
			if(this.getEnemies().get(c).isBoss()) {
				this.setHaveBoss(true);
			}
		}
		this.arrangeLine();
		this.angle += 0.035;
		this.setPosY(this.getPosY()+2);
		for(int c = 0; c < this.getEnemies().size(); c++) {
			int dist = this.getEnemies().get(c).getPosX() - this.getPosX();
			int newPosX = (int) (dist * Math.cos(this.angle % 90));
			int newPosY = (int) (dist * Math.sin(this.angle % 90));
			this.getEnemies().get(c).setPosX(this.getPosX() + newPosX);
			this.getEnemies().get(c).setPosY(this.getPosY() + newPosY);
			this.getEnemies().get(c).update(delta);
		}

	}
}
