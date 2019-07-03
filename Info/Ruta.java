package Info;

public class Ruta {

	private int Origen;
	private int Destino;
	private int Costo;
	private int Tiempo;
	private String  Piloto;
	
	
	
	public Ruta(int origen, int destino, int costo, int tiempo, String piloto) {
	
		Origen = origen;
		Destino = destino;
		Costo = costo;
		Tiempo = tiempo;
		Piloto = piloto;
	}
	
	
	public int getOrigenF() {
		return Origen;
	}
	public void setOrigenF(int origen) {
		Origen = origen;
	}
	public int getDestinoC() {
		return Destino;
	}
	public void setDestinoC(int destino) {
		Destino = destino;
	}
	public int getCosto() {
		return Costo;
	}
	public void setCosto(int costo) {
		Costo = costo;
	}
	public int getTiempo() {
		return Tiempo;
	}
	public void setTiempo(int tiempo) {
		Tiempo = tiempo;
	}
	public String getPiloto() {
		return Piloto;
	}
	public void setPiloto(String piloto) {
		Piloto = piloto;
	}
	
	
	
	
	
}
