package Objects;

import java.awt.Graphics2D;
import java.util.Random;

import DataStructures.CircleList;


public class ClassD extends InvaderLine implements Drawable {
	public ClassD(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new CircleList<>());
		while(counter < size) {
			Random rand = new Random();
			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, 1+rand.nextInt(3), speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.setHaveBoss(true);
		this.setLineClass("ClassD");
	}

	/**
	 * Ordena de forma descendente los enemigos de la hilera por medio del bubble sort
	 */
	private void BubbleSort() {
		boolean changed = false;
		int index = 0;
		while(index < this.getEnemies().size()-1) {
			if(this.getEnemies().get(index).getResistance() < this.getEnemies().get(index+1).getResistance()) {
				this.getEnemies().swap(index, index+1);
				changed = true;
			}
			++index;
		}
		if(changed) {
			this.BubbleSort();
		}
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
		Random rand = new Random();
		if(!this.isHaveBoss() && this.getEnemies().size() != 1) {
			int newBoss = rand.nextInt(this.getEnemies().size()-1);
			this.getEnemies().get(newBoss).setBoss();
		} else if(!this.isHaveBoss() && this.getEnemies().size() == 1) {
			this.getEnemies().get(0).setBoss();
		}
		if(this.getEnemies().size() > 1) {
			this.BubbleSort();
		}
		this.arrangeLine();

	}

}
