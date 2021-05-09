package Display;

import packets.AddConnectionPacket;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


/**
 *Clase display: Clase que crea el jframe y crea una ventana de ciertas dimensiones
 */
public class Display extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 280, HEIGHT = 200, SCALE = 3;

	private boolean running = false;
	private Thread thread;

	private int FPS;
	private static States.StateMachine state;
	private JFrame frame;

	/**
	 *Display: Implementa el statemachine y empieza el juego.
	 */
	public Display() {
		this.setSize(WIDTH*SCALE, HEIGHT*SCALE);
		this.setFocusable(true);

		state = new States.StateMachine(this);
		state.setState((byte) 0);
	}

	/**
	 *Metodo JFrame: es un metodo get de JFrame
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 *Metodo JFrame: es un metodo set de JFrame
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



	/**
	 *Main del proyecto, Aqui se establece el Javaframe
	 * @param args
	 */
	public static void main(String args[]) {

		Display display = new Display();
		JFrame frame = new JFrame();
		frame.add(display);
		frame.pack();

		frame.setTitle("Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

		display.setFrame(frame);
		display.start();
	}

	/**
	 *Metodo draw: mediante el state y utilizando graphics2D llama a otros metodos para empezar a crear objetos.
	 * @param bs
	 */
	public void draw(BufferStrategy bs) {
		do {
			do {
				Graphics2D g = (Graphics2D) bs.getDrawGraphics();

				state.draw(g);

				g.dispose();
			} while(bs.contentsRestored());
			bs.show();
		} while(bs.contentsLost());
	}

	/**
	 *Metodo Update: Actualiza la ventana mediante states.
	 * @param delta
	 */
	public void update(double delta) {
		state.update(delta);
	}

	/**
	 *Metodo que clasifica el juego para que comience
	 */
	public synchronized void start() {
		if(running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 *Metodo que para el juego
	 */
	public synchronized void stop() {

		if(!running)
			return;

		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {e.printStackTrace();}
	}

	/**
	 *Metodo Run: Hace que el juego corre detras del programa.
	 */
	@Override
	public void run() {
		long timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		int frames = 0;

		this.createBufferStrategy(3);
		BufferStrategy bs = this.getBufferStrategy();

		while(running) {
			long now = System.nanoTime();
			long updates = now - lastTime;
			lastTime = now;
			double delta = updates / (double) OPTIMAL_TIME;

			frames++;

			if(System.currentTimeMillis()-timer > 1000) {
				timer += 1000;
				FPS = frames;
				frames = 0;
			}
			draw(bs);
			update(delta);

			try {
				Thread.sleep((lastTime-System.nanoTime()+OPTIMAL_TIME)/1000000);
			} catch(Exception e) {}
		}
	}
}
