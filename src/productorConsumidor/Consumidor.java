package productorConsumidor;

public class Consumidor implements Runnable{
	
	private Buffer buffer;
	
	public Consumidor(Buffer b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		char valor;
		for (int i = 0; i <10; i++) {
			valor = buffer.recoger();
			System.out.println(i +" consumidor: "+ valor);
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
