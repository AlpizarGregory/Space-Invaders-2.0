package Objects;
import java.awt.Canvas;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.SwingUtilities;

/**
<<<<<<< HEAD
 *Clase Mouse: Esta clase se encarga de recibir los datos de la poscicion del mous en la pantalla de
=======
 *Clase Mouse: Esta clase se encarga de recibir los datos de la poscicion del mouse en la pantalla de
>>>>>>> master
 * la computadora para luego utilizarlos respecto a al canvas donde se desarrolla el juego, dicho canvas
 * es un parámetro para la composicion de la clase Mouse
 */
public class Mouse {
    private Canvas cursor;
    private Point pos;
    public Mouse(Canvas game){
        cursor = game;
    }
    public void updatePosition(){
        pos = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(pos, cursor);
    }
    public int getMouseX(){
        return pos.x;
    }

    public boolean mouseClicked() {
        return true;
    }
}
