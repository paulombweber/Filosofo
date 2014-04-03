package pgk;

public class Filosofo extends Thread {

	private int pos;
	private Mesa mesa;
	private static int SLEEP = 100;
	
	public Filosofo(Mesa mesa, int pos) {
		this.mesa = mesa;
		this.pos = pos;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				pegarGarfos();
				comer();
				pensar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void comer() {
		System.out.println("Filosofo: " + pos + "começou a comer");
		mesa.pousarGarfo(pos);
		mesa.pousarGarfo((pos + 1) % 5);
	}

	private void pensar() throws InterruptedException {
		System.out.println("Filosofo: " + pos + "começou a pensar");
		sleep(SLEEP);
	}

	private void pegarGarfos() throws InterruptedException {
		int aux = (pos + 1) % 5;
		while (!mesa.pegarGarfo(pos, aux)){
			sleep(SLEEP);
		}
		while (!mesa.pegarGarfo(aux)){
			sleep(SLEEP);
		}
	}
	
}
