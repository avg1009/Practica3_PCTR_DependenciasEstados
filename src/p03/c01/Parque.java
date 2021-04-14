package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

public class Parque implements IParque{

	// TODO 
	private int Capacidad_De_Personal ; // Numero de personas que pueden estar en el parque
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	
	
	public Parque(int Capacidad_De_Personal) {	// TODO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		this.Capacidad_De_Personal = Capacidad_De_Personal; 
	}


	@Override
	public synchronized void entrarAlParque(String puerta){		// TODO
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
		comprobarAntesDeEntrar();	
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO
		sumarContadoresPuerta();
		checkInvariante();
		
		
		// TODO
		notifyAll();
	}
	
	// 
	// TODO Metodo salirDelParque
	//
	
	public synchronized void salirDelParque(String puerta){
		
		//Si no hay salidas por esa puerta, inicializamos	
		if(contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta,0);
		}
		
		comprobarAntesDeSalir();
		
		//Aumentamos el contador total y el individual
		contadorPersonasTotales--;
		contadoresPersonasPuerta.put(puerta , contadoresPersonasPuerta.get(puerta)-1);
		
		//Imprimimos el estado del parque
		imprimirInfo(puerta,"Salida");
		
		sumarContadoresPuerta();
		checkInvariante();
		
		notifyAll();			
	}
	
	
	
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parte";
		// TODO 
		assert contadorPersonasTotales <= Capacidad_De_Personal : "INV Se ha llegado al aforo maximo"; 
		assert contadorPersonasTotales <= 0 : "INV: Muchas personas negativas en el parque";
	}

	protected void comprobarAntesDeEntrar(){	// TODO
		//
		// TODO
		//
	}

	protected void comprobarAntesDeSalir(){		// TODO
		//
		// TODO
		//
	}


}
