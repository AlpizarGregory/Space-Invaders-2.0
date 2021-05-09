package Objects;

import java.awt.Graphics2D;

/**
 * Clase del proyectíl del jugador
 */
public class Bullet extends Moveable implements Drawable {
	public Bullet(int posX, int posY, int width, int height, int speed, String spriteName) {
		super(posX, posY, width, height, speed, spriteName);
	}


	public void draw(Graphics2D g) {
		g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
	}


	public void update(double delta) {
		this.setPosY(this.getPosY()+this.getSpeed());
		this.setRect();
	}
}
