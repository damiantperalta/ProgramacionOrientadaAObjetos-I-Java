public class Pelicula implements Entregable{

    private String titulo;
    private int anio;
    private Boolean entregado;
    private String genero;
    private String director;
    
    public Pelicula() {
        this.genero = "no definido";
        this.entregado = false;
    }
    
    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
        this.genero = "no definido";
        this.entregado = false;
    }
    
    public Pelicula(String titulo, int anio, String genero, String director) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
        this.director = director;
        this.entregado = false;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }
    
    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAnio: " + anio + "\nGenero: " + genero + "\nDirector: " + director + "\nEntregado: " + entregado;
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
    public int compareTo(Object otraPeli){
    	   if (this.getAnio() == 0 && ((Pelicula)otraPeli).getAnio() == 0) {
    	        return 0;
    	    } else if (this.getAnio() == 0) {
    	        return 1;
    	    } else if (((Pelicula)otraPeli).getAnio() == 0) {
    	        return -1;
    	    } else if (this.getAnio() < ((Pelicula)otraPeli).getAnio()) {
    	        return -1;
    	    } else if (this.getAnio() > ((Pelicula) otraPeli).getAnio()) {
    	        return 1;
    	    } else {
    	        return 0;
    	    }
    	
	
}}
