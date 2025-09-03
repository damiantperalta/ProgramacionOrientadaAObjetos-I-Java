
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Nombre {
	String nombre;
	int apariciones;

	Nombre(String nombre, int apariciones) {
		this.nombre = nombre;
		this.apariciones = apariciones;
	}
}

public class Nombres {
	public static void main(String[] args) {
		try {
			String inputFilePath = "nombres.txt"; // Ruta del archivo de entrada
			String outputFilePath = "salida.txt"; // Ruta del archivo de salida

			File inputFile = new File(inputFilePath); // Crear objeto File para el archivo de entrada
			try (Scanner scanner = new Scanner(inputFile)) { // Usar try-with-resources para cerrar el Scanner automáticamente
				int C = scanner.nextInt(); // Leer el número de chicos en el contingente
				int n = scanner.nextInt(); // Leer el número de nombres más frecuentes que se desean descubrir

				if (C < 2 || C > 1000 || n < 1 || n > 100) { // Verificar que C y n estén dentro del rango permitido
					throw new IllegalArgumentException("Los valores de C y n están fuera del rango permitido");
				}

				Map<String, Integer> contadorNombres = new HashMap<>(); // Mapa para contar las apariciones de los nombres
				List<Nombre> nombresRepetidos = new ArrayList<>(); // Lista de objetos Nombre para almacenar los nombres y sus apariciones

				for (int i = 0; i < C; i++) { // Iterar C veces para leer los nombres
					String nombre = scanner.next(); // Leer un nombre
					if (nombre.length() > 20) { // Verificar que el nombre no exceda los 20 caracteres
						throw new IllegalArgumentException(
								"El nombre " + nombre + " excede el límite de 20 caracteres");
					}
					contadorNombres.put(nombre, contadorNombres.getOrDefault(nombre, 0) + 1); // Actualizar el contador de apariciones del nombre
				}

				for (Map.Entry<String, Integer> entry : contadorNombres.entrySet()) { // Iterar a través de las entradas del Mapa
					nombresRepetidos.add(new Nombre(entry.getKey(), entry.getValue())); // Agregar objetos Nombre a la lista nombresRepetidos
				}

				Collections.sort(nombresRepetidos, (a, b) -> b.apariciones - a.apariciones); // Ordenar la lista en orden descendente según las apariciones

				File outputFile = new File(outputFilePath); // Crear objeto File para el archivo de salida
				FileWriter writer = new FileWriter(outputFile); // Crear objeto FileWriter para escribir en el archivo de salida

				for (int i = 0; i < n && i < nombresRepetidos.size(); i++) { // Iterar hasta un máximo de n veces o hasta el tamaño de la lista nombresRepetidos
					writer.write(nombresRepetidos.get(i).nombre + " " + nombresRepetidos.get(i).apariciones + "\n"); // Escribir el nombre y las apariciones en el archivo de salida
				}

				writer.close(); // Cerrar el FileWriter
				scanner.close(); // Cerrar el Scanner
			}

			System.out.println("Nombres Repetidos ya calculados"); // Imprimir mensaje de éxito en la consola
		} catch (IOException e) { // Capturar la excepción de E/S
			System.out.println("Ocurrió un error al procesar los archivos");
		} catch (InputMismatchException e) { // Capturar la excepción de formato incorrecto de datos de entrada
			System.out.println("El formato de los datos de entrada es incorrecto");
		} catch (NoSuchElementException e) { // Capturar la excepción de falta de elementos en el archivo de entrada
			System.out.println("No se encontraron suficientes elementos en el archivo de entrada");
		} catch (IllegalArgumentException e) { // Capturar la excepción de valores de C y n fuera del rango permitido
			System.out.println(e.getMessage());
		} catch (Exception e) { // Capturar cualquier otra excepción inesperada
			System.out.println("Ocurrió un error inesperado");
		}
	}
}

