package Objects;

import java.awt.Graphics2D;

/**
 * Clase del invasor enemigo, características básicas, es jefe...
 */
public class Invader extends Moveable implements Drawable {
	private int resistance;
	private boolean boss;


	public Invader(int posX, int posY, int width, int height, int resistance, int speed, String spriteName) {
		super(posX, posY, width, height, speed, spriteName);
		this.resistance = resistance;


		this.boss = false;
	}
	

	
	public boolean destroy() {
		--resistance;
		return (resistance <= 0);
	}
	
	public void setBoss() {
		this.boss = true;

		this.resistance = 5;
		this.setImage("Boss_1");
		this.setWidth(100);
		this.setHeight(75);
	}



	public int getResistance() {
		return resistance;
	}

	public boolean isBoss() {
		return boss;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);


	}

	@Override
	public void update(double delta) {

		this.setRect();
	}
}
