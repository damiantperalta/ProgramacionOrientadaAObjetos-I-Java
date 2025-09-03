import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Menu 
{	
	  void menu(ArrayList<Empleado> a)
	        {
		        Scanner Teclado = new Scanner(System.in);
	            int opc, x;
	            do
	            {
	                do
	               {

	                    System.out.println("MENU DE OPERACIONES");
	                    System.out.println("1 - Ingresar empleado") ; // bien
	                    System.out.println("2 - Modificar empleado") ; // bien
	                    System.out.println("3 - Dar de baja empleado") ; //bien
	                    System.out.println("4 - Aumentar 5% a todos") ; //bien
	                    System.out.println("5 - Ver lista de empleados")   ; // bien
	                    System.out.println("6 - Salir")   ; // bien
	                    System.out.println("Ingrese una opcion: ");
	                    opc=Teclado.nextInt();
	                    
	                } while(opc < 1 && opc > 6);

	                switch (opc)
	                {
	                    case 1:
	                      ingresar(a);
	                        //system("Pause");
                              //  for(int i=1;i<50;i++)System.out.println();
	                        break;
	                    case 2:
	                        modificar(a);
	                        //system("Pause");
                                System.out.print("Si quiere continuar apriete cualquier numero");
                                x=Teclado.nextInt();
	                        break;
	                    case 3:
	                        bajar(a);
	                        //system("Pause");
                                System.out.print("Si quiere continuar apriete cualquier numero");
                                x=Teclado.nextInt();
	                        break;
	                    case 4:
	                        aumentar(a);
	                        //system("Pause");
                                System.out.print("Si quiere continuar apriete cualquier numero");
                                x=Teclado.nextInt();
	                        break;
	                    case 5:
	                    	mostrar(a);
	                    	System.out.print("Si quiere continuar apriete cualquier numero");
                            x=Teclado.nextInt();
	                    	break;
	               }

	            }
	            while (opc != 6);
	            System.out.print("Fin del Programa");
	            Teclado.close(); 
	            
	            }

	  void ingresar(ArrayList<Empleado> a)
	 {
	     Scanner teclado = new Scanner(System.in);
	     int anio,mes,dia;
	     double sala;
	     String Nom;
	     System.out.println("Estoy en Ingresar Empleado");
	     System.out.println("Ingrese el nombre: ");
	     Nom=teclado.next();
	     System.out.println("Ingrese el salario: ");
	     sala=teclado.nextInt();
	     System.out.println("Ingrese el anio: ");
	     anio=teclado.nextInt();
	     System.out.println("Ingrese el mes: ");
	     mes=teclado.nextInt();
	     System.out.println("Ingrese el dia: ");
	     dia=teclado.nextInt();
		 a.add(new Empleado(Nom, sala, anio, mes, dia));
	 }
	  
	  public void modificar(ArrayList<Empleado> a) {

	     Scanner teclado = new Scanner(System.in);
	     System.out.println("Estoy en modificar empleado");
	     System.out.println("Ingrese el indice del empleado de la lista ");
	     int indice = teclado.nextInt();

	     if (indice < 0 || indice >= a.size()) {
	         System.out.println("Indice invalido.");
	         return;
	     }

	     Empleado empleado = a.get(indice);
	     System.out.println("Ingrese el nuevo nombre: ");
	     String nombre = teclado.next();
	     empleado.setNombre(nombre);
	     System.out.println("Ingrese el nuevo salario: ");
	     double salario = teclado.nextDouble();
	     empleado.setSalario(salario);
	     System.out.println("Ingrese la nueva fecha de alta (en formato yyyy-mm-dd): ");
	     String fechaAltaStr = teclado.next();
	     LocalDate fechaAlta = LocalDate.parse(fechaAltaStr);
	     empleado.setFechaAlta(fechaAlta);
	     System.out.println("Empleado modificado exitosamente.");
		}
	  
	  void bajar(ArrayList<Empleado> a)
	 {
		 String nom;
	     Scanner teclado = new Scanner(System.in);
	     System.out.println("Estoy en dar de baja");
	     System.out.println("Ingrese nombre de empleado que quiere dar de baja");
	     nom=teclado.next();
	     Iterator<Empleado> iterador = a.iterator();
	     while(iterador.hasNext()) {
	         Empleado empleado = iterador.next();
	         if(empleado.getNombre().equals(nom)) {
	             iterador.remove(); // Elimina el empleado del ArrayList
	             break; // Sal del bucle después de eliminar el elemento
	         }
	     }
	 }
	 
	  void aumentar(ArrayList<Empleado> a)
	 {
	     System.out.println("Estoy en Aumentar un 5%");
	     System.out.println("Aumento 5%");	
	     for (Empleado e : a)          
	        e.raiseSalario(5); 
	     
	 }
	  
	  void mostrar(ArrayList<Empleado> a){
		  System.out.println("Ingresando en mostrar la lista");
		  int i=0;
		  for (Empleado elemento : a) {
			  i++;
			  System.out.println("Empleado: "+ i);
	            System.out.println(elemento);
	        }
	  }

	public static void main(String[] args) 
	{
		ArrayList<Empleado> staff = new ArrayList<Empleado>();	
		Scanner Leer = new Scanner(System.in);
		Menu menu= new Menu();	
		menu.menu(staff);	
	}
}
