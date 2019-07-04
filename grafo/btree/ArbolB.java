package grafo.btree;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Info.Destino;

public class ArbolB {


	public Rama raiz;
	private  String txtGrafica;





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

						rama.setHoja(false);
						rama.insertar((NodoB) obj);

						if (rama.getCuenta() == 5) {
							return dividir(rama);

						}

					}
					return rama;

				} else if (temp.getSig() == null) {

					Object obj = inserta(nodo, temp.getDer());

					if (obj instanceof NodoB) {

						rama.setHoja(false);
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


		//metdodo vacio verficar que ningun nodo tenga hijos 
		//vreificando que todos sus hijos sean null

		NodoB result = null;
		Rama izq =  new Rama();
		Rama der =  new Rama();

		izq.setHoja(c.isHoja());
		der.setHoja(c.isHoja());

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
				NodoB aux = new NodoB(actual.getDato(),izq,der);
				result = aux;
			}
			actual = actual.getSig();
			cont++;
		}
		//result.setIzq(izq);
		//result.setDer(der);
		return result;
	}


	public void imprimir() {
		imprimir(raiz);
	}

	private void imprimir(Rama raiz) {


		if(raiz!=null) {

			NodoB actual = raiz.getPrimero();

			while (actual!= null) {

				if(actual.getSig()!=null) {

					imprimir(actual.getIzq());
					System.out.println("Nodo-> "+actual.getDato().getNombre());

				}else {

					imprimir(actual.getIzq());
					System.out.println("Nodo-> "+actual.getDato().getNombre());
					imprimir(actual.getDer());

				}



				actual = actual.getSig();
			}


		}

	}

	public Destino getDestino(int cod) {

		return getDestino(raiz, cod);
	}


	private Destino getDestino(Rama raiz,int cod) {

		if(raiz==null) {

			return null;

		}else {

			NodoB actual = raiz.getPrimero();

			do {

				if(cod == actual.getDato().getCod()) {

					return actual.getDato();

				}else if(cod < actual.getDato().getCod()) {

					return getDestino(actual.getIzq(),cod);

				}else if(actual.getSig() ==null) {
					return getDestino(actual.getDer(),cod);
				}

				actual = actual.getSig();

			}while(actual!=null);


		}


		return null;

	}



	public boolean estaVacio(){

		if(raiz!=null) {

			return false;
		}else {
			return true;
		}

	}





	public void graficar(){

		String nombre="btree";
		String dirDot ="src/graficas/dot/";
		String dirImg ="src/graficas/";
		String imgExt ="svg";//para ver en que formato se va a generar la imagen
		String comp ="dot";// como va a ser compilado el archivo dots

		graficar(dirDot,nombre);


		try
		{
			ProcessBuilder pbuilder;
			pbuilder = new ProcessBuilder( comp, "-T"+imgExt, "-o", dirImg+nombre+"."+imgExt, dirDot+nombre+".dot" );
			pbuilder.redirectErrorStream( true );

			pbuilder.start();

		} catch (Exception e) { e.printStackTrace(); }



		try {
			File objetofile = new File ( dirImg + nombre + "."+imgExt);
			Desktop.getDesktop().open(objetofile);

		}catch (IOException ex) {
			System.out.println(ex);
		}




	}


	private void graficar(String dir,String nombre) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter(dir+nombre+".dot");
			pw = new PrintWriter(fichero);

			pw.println("digraph BTree{");
			pw.println("node[shape=record, height=.1, color=deepskyblue1, fillcolor=seashell3,style=filled ];");
			pw.println("edge[color=sienna];");
			
			


			txtDot();
			pw.println(txtGrafica);

			pw.print("}");




		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para 
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}


	private  void txtDot() {
		txtGrafica ="";
		if(raiz!=null) {

			txtDot(raiz);
		}else {
			txtGrafica="\n\t nd[label=\"Arbol Vacio\"]\n";

		}

	}

	private void txtDot(Rama raiz) {


		if(raiz!=null) {

			NodoB actual = raiz.getPrimero();

			while (actual!= null) {

				if(actual.getSig()!=null) {

					if(actual == raiz.getPrimero()) {
						txtNodo(raiz);
						txtDot(actual.getIzq());

					}else {
						//raiz
						txtDot(actual.getIzq());
					}

				}else {

					if(actual == raiz.getPrimero()) {
						
						txtNodo(raiz);
						txtDot(actual.getIzq());
						txtDot(actual.getDer());

					}else {
						//raiz
						txtDot(actual.getIzq());
						txtDot(actual.getDer());
					}
		



				}	
				actual = actual.getSig();
			}




		}


	}


	private void txtNodo(Rama raiz) {


		int r = raiz.hashCode();

		NodoB actual = raiz.getPrimero();
		String nodo= "\tR"+r+"[ label = \"";
		String enlace = "";

		txtGrafica+="//--------------------Rama ->R"+r+"------------------------------\n";

		int i =0;
		String name="";
		int cod =0;

		while (actual!= null) {

			if(actual.getSig()!=null) {

				cod = actual.getDato().getCod();
				name = actual.getDato().getNombre();
				nodo+="<f"+i+">|Cod: "+cod+"\\n";
				nodo+="Dest: "+name+"|";

				if(actual.getIzq()!=null) {
					enlace+="\n\tR"+r+":f"+i+" -> ";
					int e = actual.getIzq().hashCode();
					enlace+="R"+e+"\n";

				}

			}else {

				cod = actual.getDato().getCod();
				name = actual.getDato().getNombre();
				nodo+="<f"+i+">|Cod: "+cod+"\\n";
				nodo+="Dest: "+name+"|<f"+(i+1)+">\"];\n";

				if(actual.getIzq()!=null) {

					enlace+="\n\tR"+r+":f"+i+" -> ";
					int e = actual.getIzq().hashCode();
					enlace+="R"+e+"\n";

				}

				if(actual.getDer()!=null) {

					enlace+="\n\tR"+r+":f"+(i+1)+" -> ";
					int e = actual.getDer().hashCode();
					enlace+="R"+e+"\n";
				}


				txtGrafica+=nodo;
				txtGrafica+=enlace;

			}	


			i++;
			actual = actual.getSig();
		}


	}


	public void mostrarPreorden() {

		mostrarPreorden(raiz);
	}

	private void mostrarPreorden(Rama raiz) {

		if(raiz!=null) {

			NodoB actual = raiz.getPrimero();

			while (actual!= null) {

				if(actual.getSig()!=null) {

					System.out.println("Nodo-> "+actual.getDato().getNombre());
					imprimir(actual.getIzq());


				}else {

					System.out.println("Nodo-> "+actual.getDato().getNombre());
					imprimir(actual.getIzq());
					imprimir(actual.getDer());

				}



				actual = actual.getSig();
			}


		}


	}






































}
