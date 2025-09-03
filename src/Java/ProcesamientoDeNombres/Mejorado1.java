import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Mejorado1 {
	 private static final String INPUT_FILE = "E:\\lote de prueba\\nombres 1.1.txt";
	    private static final String OUTPUT_FILE = "E:\\lote de prueba\\nombres_resultado.txt";
	    private static final int MIN_CANTIDAD_CHICOS = 2;
	    private static final int MAX_CANTIDAD_CHICOS = 1000;
	    private static final int MIN_CANTIDAD_NOMBRES = 1;
	    private static final int MAX_CANTIDAD_NOMBRES = 100;

	    public static void main(String[] args) {
	        try {
	            // Lectura del archivo de entrada y validación de datos
	            Map<String, Integer> nombresConteo = leerFileEntrada(INPUT_FILE);

	            // Ordenamiento de los nombres por cantidad de apariciones (de mayor a menor)
	            Map<String, Integer> nombresOrdenados = contarOrdenarNombres(nombresConteo);

	            // Escritura en el archivo de salida
	            escribirFileSalida(OUTPUT_FILE, nombresOrdenados);

	            System.out.println("Archivo 'nombres_resultado.txt' generado correctamente.");

	        } catch (IOException e) {
	            System.err.println("Error al leer o procesar el archivo de entrada.");
	            e.printStackTrace();
	        } catch (NumberFormatException e) {
	            System.err.println("Error en el formato de los datos de entrada.");
	            e.printStackTrace();
	        }
	    }

	    private static Map<String, Integer> leerFileEntrada(String inputFile) throws IOException {
	        Map<String, Integer> nombresConteo = new HashMap<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
	            String primeraLinea = br.readLine();
	            validarFileEntrada(primeraLinea);

	            String[] partesPrimeraLinea = primeraLinea.split(" ");
	            int cantidadChicos = Integer.parseInt(partesPrimeraLinea[0]);
	            int cantidadNombres = Integer.parseInt(partesPrimeraLinea[1]);
	            validarCantidadChicos(cantidadChicos);
	            validarCantidadNombres(cantidadNombres);

	            String nombre;
	            while ((nombre = br.readLine()) != null) {
	                nombresConteo.put(nombre.toLowerCase(), nombresConteo.getOrDefault(nombre.toLowerCase(), 0) + 1);
	            }
	        }

	        return nombresConteo;
	    }

	    private static void validarFileEntrada(String primeraLinea) throws IOException {
	        if (primeraLinea == null || primeraLinea.isEmpty()) {
	            throw new IOException("El archivo de entrada está vacío.");
	        }

	        String[] partesPrimeralinea = primeraLinea.split(" ");
	        if (partesPrimeralinea.length != 2) {
	            throw new IOException("El formato del archivo de entrada es incorrecto.");
	        }
	    }

	    private static void validarCantidadChicos(int cantidadChicos) throws IOException {
	        if (cantidadChicos < MIN_CANTIDAD_CHICOS || cantidadChicos > MAX_CANTIDAD_CHICOS) {
	            throw new IOException("La cantidad de chicos está fuera del rango permitido.");
	        }
	    }

	    private static void validarCantidadNombres(int cantidadNombres) throws IOException {
	        if (cantidadNombres < MIN_CANTIDAD_NOMBRES || cantidadNombres > MAX_CANTIDAD_NOMBRES) {
	            throw new IOException("La cantidad de nombres a descubrir está fuera del rango permitido.");
	        }
	    }

	    private static Map<String, Integer> contarOrdenarNombres(Map<String, Integer> nombresConteo) {
	        return nombresConteo.entrySet()
	                .stream()
	                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
	                .limit(MAX_CANTIDAD_NOMBRES)
	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	    }

	    private static void escribirFileSalida(String outputFile, Map<String, Integer> nombresOrdenados) throws IOException {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
	            for (Map.Entry<String, Integer> entry : nombresOrdenados.entrySet()) {
	                bw.write(entry.getKey() + " " + entry.getValue());
	                bw.newLine();
	            }
	        }
	    }
	}