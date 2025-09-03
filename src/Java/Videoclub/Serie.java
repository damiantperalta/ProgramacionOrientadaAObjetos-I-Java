public class Serie implements Entregable{
	private String titulo;
	@SuppressWarnings("unused")
	private Boolean entregado;
	private String genero;
	private int numTemp;
	private String creador;
	
	public Serie() {
		this.titulo="";
		this.genero="";
		this.numTemp=3;
		this.entregado=false;
		this.creador="";
		
	}
	
	public Serie(String titulo,String creador) {
		this.titulo=titulo;
		this.creador=creador;
		this.numTemp=3;
		this.entregado=false;
	}
	
	public Serie(String titulo, int numTemp,String genero,String creador) {
		this.titulo=titulo;
		this.numTemp=numTemp;
		this.genero=genero;
		this.creador=creador;
		this.entregado=false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumTemp() {
		return numTemp;
	}

	public void setNumTemp(int numTemp) {
		this.numTemp = numTemp;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public void entregar() {
		this.entregado=true;
		
	}

	@Override
	public void devolver() {
		this.entregado=false;
		
	}

	@Override
	public Boolean isEntregado() {
		
		return this.entregado;
	}
	
	 @Override
	    public String toString() {
	        return "Titulo: " + titulo + "\nNumero de temporadas: " + numTemp + "\nGenero: " + genero + "\nCreador: " + creador + "\nEntregado: " + entregado;
	    }

	@Override
	public int compareTo(Object otraSerie) {
		if(this.getNumTemp() > ((Serie)otraSerie).getNumTemp()) 
			return 1;
		if(this.getNumTemp() < ((Serie)otraSerie).getNumTemp())
			return -1;
		return 0;
	}

	
}