package src.p03.c01;

public class SistemaLanzador {
	public static void main(String[] args) {
		
		final int Puertas= 5; //numero de puertas en el parque
		final int Capacidad_De_Personal = 50;   //Capacidad maxima del parque
		IParque parque = new Parque(Capacidad_De_Personal); // TODO
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		
		for (int i = 0; i < Puertas; i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creacion de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// TODO
			// Creacion de hilos de salida
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();
			
		}
	}	
}