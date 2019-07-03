package grafo.adyacencia;

import Info.Ruta;

public class CuerpoHorizontal {



	NodoM first;
	NodoM last;





	public CuerpoHorizontal() {
		first=last=null;
	}



	public void add(NodoM nuevo) {


		if(first!=null) {

			if(!search(nuevo)) {

			}
		}else {

			first=last=nuevo;
		}
	}



	public  Boolean search(NodoM nuevo) {

		NodoM actual =first;

		while(actual!=null) {

			if((   actual.getData().getOrigenF()== 
					nuevo.getData().getOrigenF())
					&&(actual.getData().getDestinoC()==
					nuevo.getData().getDestinoC())) {

				Ruta aux = actual.getData();
				aux.setCosto(nuevo.getData().getCosto());
				aux.setPiloto(nuevo.getData().getPiloto());
				aux.setTiempo(nuevo.getData().getTiempo());

				return true;

			}

			actual = actual.getSig();
		}

		return false;
	}



	public  void sort(NodoM nuevo) 
	{

		//si el nuevo es menor a primero
		if(nuevo.getData().getDestinoC() < first.getData().getDestinoC()) {
			nuevo.setSig(first);
			first.setAnt(nuevo);
			first = nuevo;
		}
		//si el nuevo es mayor a ultimo
		else if(nuevo.getData().getDestinoC() >last.getData().getDestinoC()) {

			nuevo.setAnt(last);
			nuevo.setSig(nuevo);
			last=nuevo;
			
		}else {
			
			NodoM actual = first;
			
			while(actual!=last) {
				
				
				if((nuevo.getData().getDestinoC() > actual.getData().getDestinoC())&&
				   (nuevo.getData().getDestinoC() < actual.getSig().getData().getDestinoC())) {
					
					
					nuevo.setAnt(actual);
					nuevo.setSig(actual.getSig());
					actual.getSig().setAnt(nuevo);
					actual.setSig(nuevo);
					break;
				}
				
				
				
				actual = actual.getSig();
			}


		}


	}

}
















