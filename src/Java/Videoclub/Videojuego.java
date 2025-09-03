public class Videojuego implements Entregable{
	//atributos
private String titulo;
private int horasEstimadas;
private Boolean entregado;
private String genero;
private String compania;

//constructores
public Videojuego(){
	this.setHorasEstimadas(10);
	this.entregado=false;
}
public Videojuego(String Titu, int horasEst){
	this.setTitulo(Titu);
	this.setHorasEstimadas(horasEst);
	this.entregado=false;
}

public Videojuego(String Titu, int horasEst, String gene, String compania){
	this.setTitulo(Titu);
	this.setHorasEstimadas(horasEst);
	this.setGenero(gene);
	this.setCompania(compania);
	this.entregado=false;
}
	
	//metodos
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getHorasEstimadas() {
		return horasEstimadas;
	}
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	
    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nHoras estimadas: " + horasEstimadas + "\nGenero: " + genero + "\nCompania: " + compania + "\nEntregado: " + entregado;
    }

    @Override
    public void entregar(){
    	this.entregado=true;
    }
    
    @Override
   public void devolver() {
    	this.entregado=false;
    }
    
    @Override
   public Boolean isEntregado(){
	   return this.entregado;
   }
    
    @Override
    public int compareTo(Object otroVideojuego){
    	if (this.getHorasEstimadas() < ((Videojuego)otroVideojuego).getHorasEstimadas()) {
            return -1;
        } else if (this.getHorasEstimadas() == ((Videojuego)otroVideojuego).getHorasEstimadas()) {
            return 0;
        } else {
            return 1;
        }
    }
    
}