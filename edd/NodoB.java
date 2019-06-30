package edd;

import Info.Destino;

public class NodoB {
	

	private NodoB  sig , ant;

	private Rama izq , der;
	
	
	//contenido del arbol b
	//alias dato
	private Destino Dato;

	
	NodoB(Destino Dato){
		
		this.Dato = Dato;
		sig=ant=null;
		izq=der=null;
		
	}
	
	NodoB(Destino Dato , Rama izq, Rama der){
		
		this.Dato = Dato;
		this.izq =izq;
		this.der =der;
		
	}
	
	NodoB(){
		
		this.Dato = null;
		sig=ant=null;
		izq=der=null;
	}


	
	
	public NodoB getSig() {
		return sig;
	}


	public void setSig(NodoB sig) {
		this.sig = sig;
	}


	public NodoB getAnt() {
		return ant;
	}


	public void setAnt(NodoB ant) {
		this.ant = ant;
	}


	public Rama getIzq() {
		return izq;
	}


	public void setIzq(Rama izq) {
		this.izq = izq;
	}


	public Rama getDer() {
		return der;
	}


	public void setDer(Rama der) {
		this.der = der;
	}


	public Destino getDato() {
		return Dato;
	}


	public void setDato(Destino valor) {
		Dato = valor;
	}




}
