package display;

/**
 *Clase Timer: define tiempo previo
 */
public class Timer {
	private long prevTime;

	/**
	 *Metodo timer: Tiempo previo
	 */
	public Timer() {
		prevTime = System.currentTimeMillis();
	}

	/**
	 *Metodo para resetear el timer del juego
	 */
	public void resetTimer() {
		prevTime = System.currentTimeMillis();
	}

	/**
	 *Metodo timer event: inicia el timer
	 * @param timer
	 * @return
	 */
	public boolean timerEvent(int timer) {
		if(System.currentTimeMillis()-getPrevTime() > timer) {
			resetTimer();
			return true;
		}
		
		return false;
	}

	/**
	 *Getprevtime
	 * @return
	 */
	public long getPrevTime() {
		return prevTime;
	}

	/**
	 *SetPrevtime
	 * @param prevTime
	 */
	public void setPrevTime(long prevTime) {
		this.prevTime = prevTime;
	}


		

}
