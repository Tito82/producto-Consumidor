package productorConsumidor;

public class Buffer {
	private char contenido;
	private boolean disponible = false;
	
	public synchronized char recoger() {
		
//		if(disponible) {
//			disponible = false;
//			return contenido;
//		}
//		return ('\t');
		while(disponible==false) {
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		disponible=false;
		notify();
		return contenido;
	}
		
	public synchronized void poner(char c) {
//		this.contenido = c;
//		disponible = true;
		while(disponible) {
			try {
				wait();
			}catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		contenido = c;
		disponible = true;
		notify();
	}

}
