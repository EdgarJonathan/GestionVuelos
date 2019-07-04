package Info;

import grafo.adyacencia.*;

public class Destino {


	private int cod;
	private String nombre;

	//para saber contiene una lista o una columna
	private CuerpoVertical Col;
	private CuerpoHorizontal Fila;


	public Destino(int cod, String nombre)
	{
		this.cod =cod;
		this.nombre = nombre;
		Col=null;
		Fila=null;
	}


	public void addFila(NodoM nuevo) {
		if(Fila!=null) {
			Fila.add(nuevo);
		}else {
			Fila = new CuerpoHorizontal();
			Fila.add(nuevo);
		}


	}


	public void addCol(NodoM nuevo) {

		if(Col!=null) {
			Col.add(nuevo);
		}else {
			Col = new CuerpoVertical();
			Col.add(nuevo);
		}
	}

	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





}
