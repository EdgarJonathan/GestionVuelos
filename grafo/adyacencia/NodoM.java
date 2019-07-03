
package grafo.adyacencia;

import Info.Ruta;

public class NodoM {
	
	
	private Ruta data;
	
	private NodoM arriba;
	private NodoM abajo;
	private NodoM sig;
	private NodoM ant;
	
	
	
	
	
	public NodoM(Ruta data) {
		this.data = data;
		arriba=abajo=sig=ant=null;
	}
	
	
	public Ruta getData() {
		return data;
	}
	public void setData(Ruta data) {
		this.data = data;
	}
	public NodoM getArriba() {
		return arriba;
	}
	public void setArriba(NodoM arriba) {
		this.arriba = arriba;
	}
	public NodoM getAbajo() {
		return abajo;
	}
	public void setAbajo(NodoM abajo) {
		this.abajo = abajo;
	}
	public NodoM getSig() {
		return sig;
	}
	public void setSig(NodoM sig) {
		this.sig = sig;
	}
	public NodoM getAnt() {
		return ant;
	}
	public void setAnt(NodoM ant) {
		this.ant = ant;
	}
	

}
