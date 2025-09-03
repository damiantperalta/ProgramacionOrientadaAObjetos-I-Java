import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class TestMenu {
	
	private Scanner teclado = new Scanner(System.in);
	
	private List<Persona> personas;
	private ArrayList<Persona> personas2;
	
	/*TestMenu(){
		personas = new ArrayList<>();
	}*/
		
		public static void main(String []args)throws DniParException{
			
			Archivo a1 = new Archivo();
			TestMenu menu = new TestMenu();
			//GestorEstudiantes ge = new GestorEstudiantes();
			
			menu.menu(a1);
			
		}


	private void menu(Archivo a1){
		int opc=0;
		do {
			do {
				
			
			System.out.println("\t\tBienvenido al Menu");
			System.out.println("1 - Generar una lista con 5 Objetos Persona\n2 - Recorrer la lista y generar un archivo con Objetos Persona\n"
					+ "3 - Eliminar el segundo y cuarto Objeto de la Lista\n4 - Eliminar el primero y quinto  Objeto del Archivo\n"
					+ "5 - Modificar la edad del tercer Objeto\n6- Mostrar los contenidos de la lista\n7 - Mostrar los contenidos del archivo\n"
					+ "8 - Recorrer el archivo con Objetos y generar otro archivo de texto CSV\n9 - Leer el archivo CSV y generar un ArrayList de Objetos\n"
					+ "10 - Recorra el ArrayList y para los DNI pares genere una Excepción Propia\n"
					+ "11- Buscar Objeto Persona en archivo inicial por DNI y mostrar todos sus datos en pantalla\n12 - Salir\n"
					+ "Ingrese una opcion: ");
			opc=teclado.nextInt();
			teclado.nextLine();
			
			
			}while(opc<1 || opc>12);
			
			switch(opc) {
			case 1:
				personas = new ArrayList<>();
				crearLista(personas);
				System.out.println("Lista creada Exitosamente");
				paraSeguir(teclado);
				break;
			case 2:
				a1.generarArchivo(personas);
				paraSeguir(teclado);
				break;
			case 3:
				eliminarObjetos(personas);
				System.out.println("Objetos en la posicion 2 y 4 de la lista, eliminados correctamente");
				paraSeguir(teclado);
				break;
			case 4:
				a1.eliminarObjetosArchivo();
				paraSeguir(teclado);
				break;
			case 5:
				modificarEdadTercerObjeto();
				break;
			case 6:
				mostrarLista();
				paraSeguir(teclado);
				break;
			case 7:
				a1.leerArchivo();
				paraSeguir(teclado);
				break;
			case 8:
				a1.crearArchivoCSV();
				paraSeguir(teclado);
				break;
			case 9:
				personas2 = new ArrayList<>();
				
				personas2 = a1.leerArchivoCSV();
				
				paraSeguir(teclado);
				break;
				
			case 10:
				
				Pares(personas2);
				paraSeguir(teclado);
				
				break;
				
			case 11:
				System.out.println("Ingrese el DNI que se va a buscar: ");
				int d=teclado.nextInt();
				teclado.nextLine();
				
				a1.buscarDNI(d);
				paraSeguir(teclado);
				
				
				break;
				
			}
			
			
		}while(opc!=12);
		System.out.println("Fin del Programa");
		teclado.close();
	}
	

	


	public void crearLista(List<Persona> personas) {
		
		personas.clear();
		Persona persona1=new Persona("Luis",41027148,25);
		personas.add(persona1);			
        Persona persona2= new Persona("Ana",45889374,22);
		personas.add(persona2);
		Persona persona3=new Persona("Lucas",11314857,68);
		personas.add(persona3);
		Persona persona4=new Persona("Maria",35755831,46);
		personas.add(persona4);
		Persona persona5=new Persona("Gerardo",12895236,62);
		personas.add(persona5);
		
		/*personas.clear();
        personas.add(new Persona("Juan", 41027148, 25));
        personas.add(new Persona("María", 45889374, 22));
        personas.add(new Persona("Carlos", 11314857,68));
        personas.add(new Persona("Laura", 35755831, 46));
        personas.add(new Persona("Pedro", 12895236, 62));

        System.out.println("Lista de personas generada correctamente.");*/
	}
	
	public void eliminarObjetos(List<Persona> personas2) {
		
		personas.remove(3);
        personas.remove(1);
        
		
	}
	
	public void modificarEdadTercerObjeto() {
		
		if (personas.size() >= 3) {
	        Persona tercerObjeto = personas.get(2);
	        int edadAnterior = tercerObjeto.getEdad();

	        System.out.println("Edad del tercer objeto antes del cambio: " + edadAnterior);

	        tercerObjeto.setEdad(40); // Cambiar la edad al valor deseado

	        int edadNueva = tercerObjeto.getEdad();
	        System.out.println("Edad del tercer objeto después del cambio: " + edadNueva);

	        System.out.println("Edad del tercer objeto cambiada correctamente.");
	    } else {
	        System.out.println("No hay suficientes objetos en la lista para mostrar o cambiar la edad del tercer objeto.");
	    }

	}
	
	public void mostrarLista() {
		 System.out.println("Lista de personas:");
		    for (Persona persona : personas) {
		        System.out.println("Nombre: " + persona.getNombre());
		        System.out.println("Edad: " + persona.getEdad());
		        System.out.println("DNI: " + persona.getDni());
		        System.out.println("------------------------");
		    }
		
	}
	
	public void Pares(ArrayList<Persona> personas2) {
		int cont = 0;
		
		for (Persona persona : personas2) {
            try {
                if (persona.getDni() % 2 == 0) {
                    throw new DniParException("El DNI en la posicion " +cont+ " es par: " + persona.getDni());
                }
                //System.out.println(persona);
            } catch (DniParException e) {
                System.out.println("Excepción: " + e.getMessage());
            }
            cont++;
        }
		
	}
	
	
	
	public static void paraSeguir(Scanner x) {
		System.out.print("Para seguir teclee un número");			    
		x.nextInt();	   
		System.out.print("\n\n");
	}
	
	

}
