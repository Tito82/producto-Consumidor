package productorConsumidor;

public class Productor implements Runnable {
	private Buffer buffer;
	private final String letras="abcdefgghijklmnopqrstuvwxyz";
	
	public Productor(Buffer b) {
		this.buffer = b;
	}

	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			char c = letras.charAt((int)(Math.random()*letras.length()));
			System.out.println(i + " productor "+ c);
			buffer.poner(c);
			try {
				Thread.sleep(100);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
