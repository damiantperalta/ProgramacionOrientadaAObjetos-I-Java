import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Archivo  {
	
	public void generarArchivo(List<Persona> personas) {
		
		        try (FileOutputStream fos = new FileOutputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
		             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

		            // Escribir los objetos en el archivo binario
		            for (Persona persona : personas) {
		                oos.writeObject(persona);
		            }

		            System.out.println("Archivo binario generado correctamente.");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
    }
	
	public void leerArchivo() {
        try (FileInputStream fis = new FileInputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            System.out.println("Contenido del archivo binario:");

            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    System.out.println(persona.toString());
                    System.out.println("\n-------------\n");
                } catch (EOFException e) {
                    // Fin del archivo alcanzado, salir del bucle
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void eliminarObjetosArchivo() {
		
		//String nombreArchivo = "C:\\Users\\lucas\\OneDrive\\Escritorio\\persona.bin";
        List<Persona> personasActualizadas = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    personasActualizadas.add(persona);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Eliminar el primer y quinto objeto del archivo
        if (personasActualizadas.size() >= 5) {
            personasActualizadas.remove(4);
            personasActualizadas.remove(0);

            // Eliminar el archivo original
            File archivoOriginal = new File("E:\\Escritorio\\Final Objetos 1\\persona.bin");
            archivoOriginal.delete();

            // Escribir los objetos actualizados en el archivo original
            try (FileOutputStream fos = new FileOutputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                for (Persona persona : personasActualizadas) {
                    oos.writeObject(persona);
                }

                System.out.println("Objetos eliminados del archivo correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pueden eliminar los objetos del archivo. No hay suficientes objetos.");
        }
    }
		
	public void crearArchivoCSV() {
        List<Persona> personasBinarias = new ArrayList<>();

        // Leer objetos del archivo binario
        try (FileInputStream fis = new FileInputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

        	while (true) {
                try {
                    Persona persona = (Persona) ois.readObject();
                    personasBinarias.add(persona);
                } catch (EOFException e) {
                    // Se alcanzó el final del archivo, salir del bucle
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear archivo CSV y escribir los objetos en él
        try (FileWriter writer = new FileWriter("E:\\Escritorio\\Final Objetos 1\\persona.csv")) {
            // Escribir encabezados en el archivo
            writer.write("Nombre;Edad;DNI\n");

            // Escribir cada objeto en una línea del archivo
            for (Persona persona : personasBinarias) {
                writer.write(persona.getNombre() + ";" + persona.getEdad() + ";" + persona.getDni() + "\n");
            }

            System.out.println("Archivo CSV creado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public ArrayList<Persona> leerArchivoCSV() {
        ArrayList<Persona> personas = new ArrayList<>();

        try (FileReader fr = new FileReader("E:\\Escritorio\\Final Objetos 1\\persona.csv");
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            boolean primeraLinea = true; // Para ignorar la primera línea (encabezados)

            while ((linea = br.readLine()) != null) {
            	
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] campos = linea.split(";"); // Separar los campos por el carácter separador del CSV

                if (campos.length == 3) {
                    String nombre = campos[0].trim();
                    int edad = Integer.parseInt(campos[1].trim());
                    int dni = Integer.parseInt(campos[2].trim());
                    
                    

                    Persona persona = new Persona(nombre, dni, edad);
                    personas.add(persona);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("ArrayList creada correctamente.");
        return personas;
    }
	
	public void buscarDNI(int d) {
	    boolean encontrado = false; // Variable para indicar si se encontró el DNI o no

	    try (FileInputStream fis = new FileInputStream("E:\\Escritorio\\Final Objetos 1\\persona.bin");
	         ObjectInputStream ois = new ObjectInputStream(fis)) {

	        while (true) {
	            try {
	                Persona persona = (Persona) ois.readObject();

	                if (persona.getDni() == d) {
	                    String nombre = persona.getNombre();
	                    int edad = persona.getEdad();
	                    int dni = persona.getDni();

	                    System.out.println("Nombre: " + nombre);
	                    System.out.println("Edad: " + edad);
	                    System.out.println("DNI: " + dni);

	                    encontrado = true; // Se encontró el DNI
	                    break; // Terminar el bucle si se encuentra el objeto
	                }
	            } catch (EOFException e) {
	                break; // Se alcanzó el final del archivo
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            }
	        }

	        if (!encontrado) {
	            System.out.println("No se encontró el DNI especificado.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
		