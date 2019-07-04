package grafo.adyacencia;

import Info.Ruta;

public class CuerpoVertical {

	NodoM first;
	NodoM last;

	public CuerpoVertical(){

		first=last=null;
	}


	public void add(NodoM nuevo) {


		if(first!=null) {

			if(!search(nuevo)) {
				sort(nuevo);
			}
		}else {

			first=last=nuevo;
		}
	}



	private  Boolean search(NodoM nuevo) {

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

			actual = actual.getAbajo();
		}

		return false;
	}



	private  void sort(NodoM nuevo) 
	{

		//si el nuevo es menor a primero
		if(nuevo.getData().getOrigenF() < first.getData().getOrigenF()) {
		
			nuevo.setAbajo(first);
			first.setArriba(nuevo);
			first =nuevo;
			

		}
		//si el nuevo es mayor a ultimo
		else if(nuevo.getData().getOrigenF() >last.getData().getOrigenF()) {

			nuevo.setArriba(last);
			last.setAbajo(nuevo);
			last=nuevo;


		}else {

			NodoM actual = first;

			while(actual!=last) {


				if((nuevo.getData().getOrigenF() > actual.getData().getOrigenF())&&
						(nuevo.getData().getDestinoC() < actual.getAbajo().getData().getOrigenF())) {
					
					nuevo.setArriba(actual);
					nuevo.setAbajo(actual.getAbajo());
					actual.getAbajo().setArriba(nuevo);
					actual.setAbajo(nuevo);

					break;
				}



				actual = actual.getAbajo();
			}


		}


	}
	
	

}








