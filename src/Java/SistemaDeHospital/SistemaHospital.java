import java.util.*;

// Excepción personalizada
class SaludInvalidaException extends Exception {
    public SaludInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// Clase abstracta Persona
abstract class Persona {
    protected String nombre;
    protected String apellido;
    protected String identificacion;

    public Persona(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (ID: " + identificacion + ")";
    }
}

// Clase Paciente
class Paciente extends Persona implements Tratamiento {
    private List<String> enfermedades;
    private int estadoSalud;

    public Paciente(String nombre, String apellido, String identificacion) {
        super(nombre, apellido, identificacion);
        enfermedades = new ArrayList<>();
        estadoSalud = 0;
    }

    public void agregarEnfermedad(String enfermedad) {
        enfermedades.add(enfermedad);
    }
    
    public int getEstadoSalud() {
        return estadoSalud;
    }

    public void asignarEstadoSalud(int estadoSalud) throws SaludInvalidaException {
        if (estadoSalud >= 0 && estadoSalud <= 100) {
            this.estadoSalud = estadoSalud;
        } else {
            throw new SaludInvalidaException("Estado de salud inválido");
        }
    }

    public boolean estaDadoDeAlta() {
        return estadoSalud >= 80;
    }

    @Override
    public void realizarTratamiento() {
        System.out.println("Realizando tratamiento para el paciente " + getNombre());
    }

    @Override
    public String toString() {
        return super.toString() + " - Estado de salud: " + estadoSalud;
    }
}

// Interfaz Tratamiento
interface Tratamiento {
    void realizarTratamiento();
}

// Clase Cirugía que implementa Tratamiento
class Cirugia implements Tratamiento {
    @Override
    public void realizarTratamiento() {
        System.out.println("Realizando cirugía");
    }
}

// Clase Doctor
class Doctor extends Persona {
    private List<String> especialidades;
    private int pacientesAsignados;

    public Doctor(String nombre, String apellido, String identificacion) {
        super(nombre, apellido, identificacion);
        especialidades = new ArrayList<>();
        pacientesAsignados = 0;
    }

    public void agregarEspecialidad(String especialidad) {
        especialidades.add(especialidad);
    }

    public void asignarPaciente() {
        pacientesAsignados++;
    }

    @Override
    public String toString() {
        return super.toString() + " - Pacientes asignados: " + pacientesAsignados;
    }
}

public class SistemaHospital {
	
    private Map<String, Paciente> pacientes;
    private List<Paciente> pacientesOrdenados;

    public SistemaHospital() {
        pacientes = new HashMap<>();
        pacientesOrdenados = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.put(paciente.getIdentificacion(), paciente);
        pacientesOrdenados.add(paciente);
    }

    public Paciente buscarPaciente(String identificacion) {
        return pacientes.get(identificacion);
    }

    public void eliminarPaciente(String identificacion) {
        Paciente paciente = pacientes.remove(identificacion);
        if (paciente != null) {
            pacientesOrdenados.remove(paciente);
        }
    }

    public void ordenarPacientesPorSalud() {
        Collections.sort(pacientesOrdenados, Comparator.comparingInt(Paciente::getEstadoSalud));
    }

    public void mostrarPacientes() {
        for (Paciente paciente : pacientesOrdenados) {
            System.out.println(paciente);
        }
    }

    public void realizarTratamiento(Tratamiento tratamiento) {
        tratamiento.realizarTratamiento();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();

        while (true) {
            System.out.println("\n--- Menú del Sistema de Gestión del Hospital ---");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Buscar paciente");
            System.out.println("3. Eliminar paciente");
            System.out.println("4. Ordenar pacientes por estado de salud");
            System.out.println("5. Mostrar lista de pacientes");
            System.out.println("6. Realizar tratamiento");
            System.out.println("0. Salir");

            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del paciente: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese el número de identificación del paciente: ");
                    String identificacion = scanner.nextLine();

                    Paciente paciente = new Paciente(nombre, apellido, identificacion);

                    System.out.print("Ingrese una enfermedad del paciente (o 'fin' para terminar): ");
                    String enfermedad = scanner.nextLine();
                    while (!enfermedad.equals("fin")) {
                        paciente.agregarEnfermedad(enfermedad);
                        System.out.print("Ingrese otra enfermedad del paciente (o 'fin' para terminar): ");
                        enfermedad = scanner.nextLine();
                    }

                    System.out.print("Ingrese el estado de salud del paciente (0-100): ");
                    int estadoSalud = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después de leer el número

                    try {
                        paciente.asignarEstadoSalud(estadoSalud);
                        sistema.agregarPaciente(paciente);
                        System.out.println("Paciente agregado exitosamente.");
                    } catch (SaludInvalidaException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número de identificación del paciente a buscar: ");
                    String idBuscar = scanner.nextLine();
                    Paciente pacienteEncontrado = sistema.buscarPaciente(idBuscar);
                    if (pacienteEncontrado != null) {
                        System.out.println("Paciente encontrado:\n" + pacienteEncontrado);
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número de identificación del paciente a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    sistema.eliminarPaciente(idEliminar);
                    System.out.println("Paciente eliminado exitosamente.");
                    break;

                case 4:
                    sistema.ordenarPacientesPorSalud();
                    System.out.println("Lista de pacientes ordenada por estado de salud:");
                    sistema.mostrarPacientes();
                    break;

                case 5:
                    System.out.println("Lista de pacientes:");
                    sistema.mostrarPacientes();
                    break;

                case 6:
                    System.out.println("Seleccione el tipo de tratamiento a realizar:");
                    System.out.println("1. Tratamiento para paciente");
                    System.out.println("2. Cirugía");

                    System.out.print("Ingrese la opción deseada: ");
                    int opcionTratamiento = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea después de leer el número

                    switch (opcionTratamiento) {
                        case 1:
                            System.out.print("Ingrese el número de identificación del paciente: ");
                            String idPaciente = scanner.nextLine();
                            Paciente pacienteTratamiento = sistema.buscarPaciente(idPaciente);
                            if (pacienteTratamiento != null) {
                                sistema.realizarTratamiento(pacienteTratamiento);
                            } else {
                                System.out.println("Paciente no encontrado.");
                            }
                            break;

                        case 2:
                            sistema.realizarTratamiento(new Cirugia());
                            break;

                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}