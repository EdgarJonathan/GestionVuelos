package grafo;

import grafo.btree.ArbolB;
import Info.Destino;

public class Grafo {
	
	
	public ArbolB fila;
	public  ArbolB columna;
	
	public Grafo() {
		fila = new ArbolB();
		columna = new ArbolB();
	}
	
	public void addDestino(int cod, String nombre) {
	
		Destino destino = new Destino(cod, nombre); 
		fila.insertar(destino);
		columna.insertar(destino);
		
	}
	public void addRuta() {
		
		
	}
	

}
