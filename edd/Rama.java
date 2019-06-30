package edd;

public class Rama {


	private NodoB primero;
	private int Cuenta;
	private boolean Hoja;



	//constructor
	public Rama(){

		this.Hoja= true;
		this.primero= null;
		this.Cuenta=0;
	}

	
	

	public void insertar(NodoB nuevo) {


		if(primero==null) {

			primero = nuevo;
			Cuenta++;
			primero.setSig(null);
			primero.setAnt(null);
		}else {

			ordenar(nuevo);			
		}




	}


	public void ordenar(NodoB nuevo) {

		NodoB aux=primero;

		while(aux!=null) {

			if(aux.getDato() == nuevo.getDato()) {
				break;
			}else if(nuevo.getDato().getCod() < aux.getDato().getCod()) {
				

				if(aux == primero) {
					
					nuevo.setSig(primero);

					primero.setAnt(nuevo);
					primero.setIzq(nuevo.getDer());
					
					primero = nuevo;
					Cuenta++;
					break;

				}else{

					nuevo.setAnt(aux.getAnt());
					nuevo.setSig(aux);
					aux.getAnt().setSig(nuevo);
					aux.setAnt(nuevo);
					
					
					aux.getAnt().setDer(nuevo.getIzq());
					aux.setIzq(nuevo.getDer());
					
					Cuenta++;
					
					break; 

				}

			}else if(aux.getSig()==null) {
				
				nuevo.setAnt(aux);
				nuevo.setSig(null);
				
				aux.setSig(nuevo);
				aux.setDer(nuevo.getIzq());
				
				
				Cuenta++;
				break;

			}


			aux=aux.getSig();
		}

	}


	public void delete() {


		while(primero!=null) {

			NodoB aux =primero;
			primero = primero.getSig();
			
			aux =null;

		}

	}



	public NodoB getPrimero() {
		return primero;
	}


	public void setPrimero(NodoB primero) {
		this.primero = primero;
	}

	public int getCuenta() {
		return Cuenta;
	}


	public void setCuenta(int cuenta) {
		Cuenta = cuenta;
	}


	public boolean isHoja() {
		return Hoja;
	}


	public void setHoja(boolean hoja) {
		Hoja = hoja;
	}














}
