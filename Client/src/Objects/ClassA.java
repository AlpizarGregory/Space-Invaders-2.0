package Objects;

import DataStructures.SimplyLinkedList;

import java.awt.*;


public class ClassA extends InvaderLine implements Drawable {
    public ClassA(int posX, int posY, int speed, int size, int lvl) {
        super(posX, posY, speed, size, lvl);
        int counter = 0;
        this.setEnemies(new SimplyLinkedList<Invader>());
        while(counter < size) {

            String sprite = "Invader_1";

            Invader enemy = new Invader(posX, posY, 50, 50, lvl, speed, sprite);
            this.getEnemies().add(enemy);
            counter++;
        }
        this.getEnemies().get(size/2).setBoss();
        this.setHaveBoss(true);
        this.setLineClass("ClassA");
    }

    @ Override
    public void draw(Graphics2D g) {
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).draw(g);
        }
    }

    @ Override
    public void update(double delta) {
        this.setHaveBoss(false);;
        for(int c = 0; c < this.getEnemies().size(); c++) {
            this.getEnemies().get(c).setPosY(this.getEnemies().get(c).getPosY()+this.getSpeed());
            this.getEnemies().get(c).update(delta);
            if(this.getEnemies().get(c).isBoss()) {
                this.setHaveBoss(true);
            }
        }
        this.arrangeLine();



    }
}
