package Objects;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import DataStructures.SimplyLinkedList;
import display.Timer;


public class Player extends Moveable implements MouseListener, Drawable {
	private static Player instance = null;
	private boolean shoot, alive;
	private int cooldown, lifes;
	private Timer timer;
	public int NetworkPosX = 0;
	private SimplyLinkedList<Bullet> bullets ;

	public Player(int posX, int posY, int width, int height, String spriteName) {
		super(posX, posY, width, height, 7, spriteName);

		this.shoot = false;
		this.alive = true;
		this.cooldown = 500;
		this.lifes = 5;
		
		this.bullets = new SimplyLinkedList<Bullet>();
		
		this.timer = new Timer();
	}

	
	public void shoot() {
		if(timer.timerEvent(cooldown)) {
			Bullet bullet = new Bullet(this.getPosX()+9, this.getPosY()-50, 45, 45, -20, "MissileSprite");
			bullets.add(bullet);
			Audio audio = new Audio("Client/Tracks/laser.wav");
		}
	}
	
	public SimplyLinkedList<Bullet> getBullets() {
		return bullets;
	}
	
	public int getLifes() {
		return lifes;
	}

	
	public void loseLife() {
		Audio hit = new Audio("SpaceInvaders/Tracks/damage.wav");
		if (lifes==1){
			Audio hurt = new Audio("SpaceInvaders/Tracks/heartbeats.wav");
		}
		if(lifes >= 1) {
			--lifes;
		} else if(lifes == 0) {
			this.alive = false;
		}
	}

	public boolean isAlive() {
		return alive;
	}

	@ Override
	public void draw(Graphics2D g) {
		g.drawImage(this.getSprite(), this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight(), null);
		for(int r = 0; r < bullets.size(); r++) {
			bullets.get(r).draw(g);
		}
	}
	
	@ Override
	public void update(double delta) {
		for(int r = 0; r < bullets.size(); r++) {
			bullets.get(r).update(delta);
		}
		
		if( this.getPosX() < 280*3-this.getWidth()+10) {
			this.setPosX(this.getPosX()+this.getSpeed());
		} else if(this.getPosX() > 0) {
			this.setPosX(this.getPosX()-this.getSpeed());
		}
		if(shoot) {
			this.shoot();
		}
		this.setRect();
	}

	public void SetPosX(int X) {
		if(X < 280*3-this.getWidth()+10) {
			this.setPosX(X);}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		shoot = true;
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		shoot = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
