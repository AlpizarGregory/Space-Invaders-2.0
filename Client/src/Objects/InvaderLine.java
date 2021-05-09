package Objects;

import DataStructures.List;
import display.Timer;

/**
 * Clase abstracta de una hilera cualquiera
 */
public abstract class InvaderLine implements Drawable {
	private List<Invader> enemies;
	private int posX, posY, speed;
	private Timer timer;
	private String lineClass;
	private boolean haveBoss;
	
	public InvaderLine(int posX, int posY, int speed, int size, int lvl) {
		this.posX = posX;
		this.posY = posY;
		this.speed = speed;
		this.lineClass = "EnemyLine";
		this.haveBoss = false;
		
		this.timer = new Timer();
	}
	
	public List<Invader> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Invader> enemies) {
		this.enemies = enemies;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public Timer getTimer() {
		return timer;
	}
	
	public String getLineClass() {
		return lineClass;
	}

	public void setLineClass(String lineClass) {
		this.lineClass = lineClass;
	}

	public boolean isHaveBoss() {
		return haveBoss;
	}

	public void setHaveBoss(boolean haveBoss) {
		this.haveBoss = haveBoss;
	}

	/**
	 *Ordena la hilera cuando un enemigo es estruido
	 */
	public void arrangeLine() {
		int dist = 0;
		for(int i = 0; i < this.getEnemies().size(); i++) {
			this.getEnemies().get(i).setPosX(dist);
			dist += 35 + this.getEnemies().get(i).getWidth();
		}
		dist = (840 - this.getEnemies().get(this.getEnemies().size()-1).getPosX() - this.getEnemies().get(this.getEnemies().size()-1).getWidth())/2;
		for(int i = 0; i < this.getEnemies().size(); i++) {
			this.getEnemies().get(i).setPosX(dist + this.getEnemies().get(i).getPosX());
		}
	}
}
