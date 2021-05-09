package States;

import java.awt.Canvas;
import java.awt.Graphics2D;

import DataStructures.SimplyLinkedList;
import Display.Game;
import Display.Menu;
import Objects.Audio;

/**
 *Clase StateMachine: Se define variables canvas,select state, y el audio, se instancia la lista enlazada.
 */
public class StateMachine {
	private Canvas canvas;
	private SimplyLinkedList<States.SuperStateMachine> states = new SimplyLinkedList<SuperStateMachine>();
	private byte selectState;
	private Audio BackG,BackM;

	/**
	 *Metodo StateMachine: Se instancia pantalla de menu y game y se agregan estados. canvas.
	 * @param canvas
	 */
	public StateMachine(Canvas canvas) {
		this.canvas = canvas;
		SuperStateMachine menu = new Menu(this);
		SuperStateMachine game = new Game(this);

		states.add(menu);
		states.add(game);

	}

	/**
	 *Metodo draw: Selecciona el estado de juego que se va empezar a dibujar en el canvas.
	 * @param g
	 */
	public void draw(Graphics2D g) {
		states.get(selectState).draw(g);
	}

	/**
	 * Metodo que actualiza el juego utilizando el statemachine.
	 * @param delta
	 */
	public void update(double delta) {
		states.get(selectState).update(delta);
	}

	/**
	 *Metodo setState: Selecciona el estado(pantalla) que debe estar seleccionado mediante keylistener, escoge el audio adecuado segun la pantalla.
	 * @param i
	 */
	public void setState(byte i) {
		if(i == 0){
			if (BackM != null){
				BackM.Stop();
			}
			BackG = new Audio("Client/Tracks/Menu.wav");

		}
		if (i == 1){
			BackM = new Audio("Client/Tracks/Tank!.wav");
			if (BackG != null){
				BackG.Stop();
			}

		}
		for(int r = 0; r < canvas.getKeyListeners().length; r++)
			canvas.removeKeyListener(canvas.getKeyListeners()[r]);
		selectState = i;
		states.get(selectState).init(canvas);
	}

	/**
	 *
	 */
	public void StopM(){
		BackM.Stop();
	}
	/**
	 *
	 * @return
	 */
	public Canvas getCanva() {

		return canvas;
	}

	/**
	 *
	 * @return
	 */
	public byte getStates() {
		return selectState;
	}
}
