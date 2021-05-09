package Objects;

import java.awt.Graphics2D;

import DataStructures.SimplyLinkedList;

/***
 *
 *
 */
public class Basic extends InvaderLine implements Drawable {
	public Basic(int posX, int posY, int speed, int size, int lvl) {
		super(posX, posY, speed, size, lvl);
		int counter = 0;
		this.setEnemies(new SimplyLinkedList<Invader>());
		while(counter < size) {


			String sprite = "Invader_1";

			Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
			this.getEnemies().add(enemy);
			counter++;
		}
		this.setLineClass("Basic");
	}

	/***
	 *
	 *
	 * @param g
	 */
	@ Override
	public void draw(Graphics2D g) {
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).draw(g);
		}
	}

	/***
	 *
	 * @param delta
	 */
	@ Override
	public void update(double delta) {
		for(int c = 0; c < this.getEnemies().size(); c++) {
			this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY() + this.getSpeed());
			this.getEnemies().get(c).update(delta);
		}
		this.arrangeLine();



	}
}
