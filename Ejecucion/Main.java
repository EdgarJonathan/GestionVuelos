package Ejecucion;

import edd.*;
import Info.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArbolB  tree = new ArbolB();
		
		
		for (int i = 0; i < 60	; i++) {
			
			tree.insertar(new Destino(i,"Nombre"+i));
			
		}
		
		
		
		tree.imprimir();

	}

}
