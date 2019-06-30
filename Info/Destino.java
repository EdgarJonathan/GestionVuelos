package Info;

public class Destino {
	
	
	private int cod;
	private String nombres;
	
	
	public Destino(int cod, String nombre)
	{
		this.cod =cod;
		this.nombres = nombre;
	}

	
	
	

	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	
	
}
