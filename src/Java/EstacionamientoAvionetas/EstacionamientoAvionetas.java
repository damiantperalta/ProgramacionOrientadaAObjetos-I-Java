import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EstacionamientoAvionetas {
    private static Queue<String> estacionamiento = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Estacionamiento de Avionetas");
        System.out.println("Acciones disponibles: Llegada (E), Salida (S)");
        System.out.println("Ingrese 'E' o 'S' seguido de la matrícula de la avioneta.");
        System.out.println("Ingrese 'X' para salir del programa.");

        boolean salir = false;

        while (!salir) {
            mostrarEstadoEstacionamiento();

            System.out.print("Ingrese la acción: ");
            String entradaUsuario = scanner.nextLine();

            if (entradaUsuario.length() >= 1) {
                char accion = Character.toUpperCase(entradaUsuario.charAt(0));

                switch (accion) {
                    case 'E':
                        if (entradaUsuario.length() > 2) {
                            String matricula = entradaUsuario.substring(2);
                            procesarLlegada(matricula);
                        } else {
                            System.out.println("La matrícula de la avioneta es inválida.");
                        }
                        break;

                    case 'S':
                        if (entradaUsuario.length() > 2) {
                            String matricula = entradaUsuario.substring(2);
                            procesarSalida(matricula);
                        } else {
                            System.out.println("La matrícula de la avioneta es inválida.");
                        }
                        break;

                    case 'X':
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Acción no válida. Intente nuevamente.");
                        break;
                }
            } else {
                System.out.println("Acción no válida. Intente nuevamente.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void procesarLlegada(String matricula) {
        if (estacionamiento.size() < 12) {
            estacionamiento.add(matricula);
            System.out.println("Avioneta con matrícula " + matricula + " ha llegado al estacionamiento.");
        } else {
            System.out.println("Estacionamiento lleno. Avioneta con matrícula " + matricula + " debe esperar.");
        }
    }

    private static void procesarSalida(String matricula) {
        if (estacionamiento.isEmpty()) {
            System.out.println("No hay avionetas en el estacionamiento.");
        } else if (estacionamiento.peek().equals(matricula)) {
            estacionamiento.remove();
            System.out.println("Avioneta con matrícula " + matricula + " ha salido del estacionamiento.");
        } else {
            System.out.println("Avioneta con matrícula " + matricula + " no está en el extremo de salida.");
            System.out.println("Retirando las avionetas a su derecha...");

            Queue<String> avionetasMovidas = new LinkedList<>();

            while (!estacionamiento.isEmpty()) {
                String avioneta = estacionamiento.remove();
                avionetasMovidas.add(avioneta);

                if (avioneta.equals(matricula)) {
                    break;
                }
            }

            if (avionetasMovidas.peek().equals(matricula)) {
                avionetasMovidas.remove();
                System.out.println("Avioneta con matrícula " + matricula + " ha salido del estacionamiento.");
            } else {
                System.out.println("Avioneta con matrícula " + matricula + " no se encontró en el estacionamiento.");
            }

            while (!avionetasMovidas.isEmpty()) {
                estacionamiento.add(avionetasMovidas.remove());
            }
        }
    }

    private static void mostrarEstadoEstacionamiento() {
        System.out.println("Estado del estacionamiento: " + estacionamiento);
    }
}
