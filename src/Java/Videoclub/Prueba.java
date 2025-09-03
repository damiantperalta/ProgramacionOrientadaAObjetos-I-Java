import java.util.ArrayList;
import java.util.Collections;
public class Prueba {

	public static void main(String[] args) {
		ArrayList<Pelicula> alquileresPeliculas = new ArrayList<>();
		ArrayList<Serie> alquileresSeries = new ArrayList<>();
		ArrayList<Videojuego> alquileresVideojuegos = new ArrayList<>();

       
        alquileresPeliculas.add(new Pelicula("El Padrino", "Francis Ford"));
        alquileresPeliculas.add(new Pelicula("Mario Bros", 2023,"Aventura","Aaron Horvath"));
        alquileresPeliculas.add(new Pelicula("Silent Hill", 2006,"Terror","Christophe Gans"));


        alquileresSeries.add(new Serie("Breaking Bad", "Vince Gilligan"));
        alquileresSeries.add(new Serie("South Park", 26, "Comedia", "Try Parker"));
        alquileresSeries.add(new Serie("Rick and Morty", 8, "Comedia", "Justin Roiland"));

        alquileresVideojuegos.add(new Videojuego("Sonic", 20));
        alquileresVideojuegos.add(new Videojuego("Resident Evil 4", 19, "Survival Horror" , "Capcom"));
        alquileresVideojuegos.add(new Videojuego("Elden Ring", 99, "Rol de accion" , "FromSoftware"));
        // Entregar 
        alquileresPeliculas.get(0).entregar();
        alquileresSeries.get(0).entregar();
        alquileresVideojuegos.get(2).entregar();

        // Contar cuántas Series, películas y Videojuegos hay entregados, listarlos por pantalla
        int contadorSeriesEntregadas = 0;
        int contadorPeliculasEntregadas = 0;
        int contadorVideojuegosEntregados = 0;

        for (Serie serie : alquileresSeries) {
            if (serie.isEntregado()) {
                contadorSeriesEntregadas++;
            }
        }

        for (Pelicula pelicula : alquileresPeliculas) {
            if (pelicula.isEntregado()) {
                contadorPeliculasEntregadas++;
            }
        }

        for (Videojuego videojuego : alquileresVideojuegos) {
            if (videojuego.isEntregado()) {
                contadorVideojuegosEntregados++;
            }
        }

        System.out.println("Series entregadas: " + contadorSeriesEntregadas);
        System.out.println("Peliculas entregadas: " + contadorPeliculasEntregadas);
        System.out.println("Videojuegos entregados: " + contadorVideojuegosEntregados);
 
        Videojuego videojuegoConMasHoras = Collections.max(alquileresVideojuegos);
        Pelicula peliculaMasAntigua = Collections.min(alquileresPeliculas);
        Serie serieConMasTemporadas = Collections.max(alquileresSeries);
        
        System.out.println("\n\nEl videojuego con mas horas estimadas: \n"+videojuegoConMasHoras.toString());
        System.out.println("\n\nLa serie con mas temporadas: \n"+serieConMasTemporadas.toString());
        System.out.println("\n\nLa pelicula mas antigua: \n"+peliculaMasAntigua.toString());
        
	}

}
