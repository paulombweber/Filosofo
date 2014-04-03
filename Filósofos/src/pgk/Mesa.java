package pgk;

import java.util.concurrent.Semaphore;

public class Mesa extends Thread {

	public boolean[] garfos = new boolean[]{true, true, true, true, true};
	private Semaphore semaforo = new Semaphore(5);
	
	public boolean pegarGarfo(int garfoPos) throws InterruptedException {
		if(garfos[garfoPos]){
			garfos[garfoPos] = false;
			semaforo.acquire();
		}else{
			return false;
		}
		return true;
	}
	
	public boolean pegarGarfo(int garfoPos, int nextGarfoPos) throws InterruptedException {
		if(garfos[garfoPos] && garfos[nextGarfoPos]){
			garfos[garfoPos] = false;
			semaforo.acquire();
		}else{
			return false;
		}
		return true;
	}

	public void pousarGarfo(int garfoPos) {
		garfos[garfoPos] = true;
		semaforo.release();
	} 
	
	
	
}
