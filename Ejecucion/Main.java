package Ejecucion;

import java.util.InputMismatchException;
import java.util.Scanner;

import Info.Destino;
import grafo.*;
import grafo.btree.ArbolB;

public class Main {

	public static void main(String[] args) {
		
		
		ArbolB  tree = new ArbolB();
		for (int i = 1; i <= 200	; i++) {

			tree.insertar(new Destino(i,""+i));

		}
		
		//tree.imprimir();
		tree.graficar();
		


		/*	
		 Scanner sn = new Scanner(System.in);
	        boolean salir = false;
	        int opcion; //Guardaremos la opcion del usuario

	        while (!salir) {

	            System.out.println("1. elige el numero de nodos a ingresar");
	            System.out.println("2. Salir");

	            try {

	                System.out.println("Escribe una de las opciones");
	                opcion = sn.nextInt();

	                if(opcion!=2) {

	            		ArbolB  tree = new ArbolB();

	            		for (int i = 1; i <= opcion	; i++) {

	            			tree.insertar(new Destino(i,"Nombre"+i));

	            		}
	            		tree.imprimir();


	                }else {

	                	salir= true;
	                }

	            } catch (InputMismatchException e) {
	                System.out.println("Debes insertar un número");
	                sn.next();
	            }
	        }*/









	/*	ArbolB  tree = new ArbolB();

		for (int i = 1; i <= 9	; i++) {

			tree.insertar(new Destino(i,"Nombre"+i));

		}

		tree.mostrarPreorden();*/

	/*	for (int i = 0; i < 70	; i++) {
			
			Destino aux = tree.getDestino(i);

			if(aux!=null) {

				System.out.println("***** el nodo es *********");
				System.out.println("cod -> "+aux.getCod());

			}else {

				System.out.println("Nodo no encontrado");
			}

		}*/

		

		//tree.imprimir();


		
		
		

	}

}
