package grafo.btree;

import Info.Destino;

public class ArbolB {


	public Rama raiz;



	public void insertar(Destino valor) {

		NodoB nodo = new NodoB(valor);
		if (estaVacio()) {

			raiz = new Rama();
			raiz.insertar(nodo);

		} else {

			Object obj = inserta(nodo, raiz);
			
			
			if (obj instanceof NodoB) {
				raiz = new Rama();
				raiz.insertar((NodoB) obj);
				raiz.setHoja(false);

			}
			
		}
	}



	private Object inserta(NodoB nodo, Rama rama) {
		
		if (rama.isHoja()) {
			
			rama.insertar(nodo);
			
			if (rama.getCuenta() == 5) {
          			
				return dividir(rama);
				
			} else {
				
				return rama;
			
			}
		} else {
			
			
			NodoB temp = rama.getPrimero();
			
			do {
				
				if (nodo.getDato() == temp.getDato()) {
					
					return rama;
					
					
				} else if (nodo.getDato().getCod() < temp.getDato().getCod()) {
					
					Object obj = inserta(nodo, temp.getIzq());
					
					if (obj instanceof NodoB) {
						
						rama.insertar((NodoB) obj);
						if (rama.getCuenta() == 5) {
							return dividir(rama);
						}
						
					}
					return rama;
					
				} else if (temp.getSig() == null) {
					
					Object obj = inserta(nodo, temp.getDer());
					
					if (obj instanceof NodoB) {
						
						rama.insertar((NodoB) obj);
						
						if (rama.getCuenta() == 5) {
							
							return dividir(rama);
						}
					}
					
					return rama;
				}
				temp = temp.getSig();
				
			} while (temp != null);
			
			
			
		}
		
		
		return rama;  
	}


	

	private Object dividir(Rama c) {
		
		NodoB result = null;
		Rama izq =  new Rama();
		Rama der =  new Rama();
			
		int cont =0;
		
		NodoB actual = c.getPrimero();
		
		while(actual!= null) {
			if(cont <2) {
				NodoB aux = new NodoB(actual.getDato(),actual.getIzq(),actual.getDer());
				izq.insertar(aux);
			}else if(cont>2) {
				NodoB aux = new NodoB(actual.getDato(),actual.getIzq(),actual.getDer());
				der.insertar(aux);
			}else {
				NodoB aux = new NodoB(actual.getDato(),actual.getIzq(),actual.getDer());
				result = aux;
			}
			actual = actual.getSig();
			cont++;
		}
		result.setIzq(izq);
		result.setDer(der);
		return result;
	}

	
	
	
	public void imprimir() {
		imprimir(raiz);
	}
	
	private void imprimir(Rama raiz) {
	
		
		if(raiz!=null) {
			
			NodoB actual = raiz.getPrimero();
			
			while (actual!= null) {
				
				imprimir(actual.getIzq());
				
				System.out.println("Nodo-> "+actual.getDato().getNombre());
				
				imprimir(actual.getDer());
				
				actual = actual.getSig();
			}
			
			 
		}
		
	}


	public boolean estaVacio(){

		if(raiz!=null) {
			
			return false;
		}else {
			return true;
		}

	}


	
	public void graficar(){
		
	}
	
	




}
