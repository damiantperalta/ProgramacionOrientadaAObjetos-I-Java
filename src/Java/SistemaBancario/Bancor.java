import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Excepción personalizada para saldo insuficiente
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException() {
        super("Saldo insuficiente");
    }
}

// Interfaz para ordenar las cuentas
interface Ordenable {
    int compareTo(Cuenta otraCuenta);
}

// Clase abstracta Cuenta
abstract class Cuenta implements Ordenable, Comparable<Cuenta> {
    protected String numeroCuenta;
    protected String titular;
    protected double saldo;

    public Cuenta(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    public abstract void retirar(double cantidad) throws SaldoInsuficienteException;

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo + "]";
    }

    @Override
    public int compareTo(Cuenta otraCuenta) {
        return Double.compare(this.saldo, otraCuenta.saldo);
    }
}

// Clase CuentaAhorros que hereda de Cuenta
class CuentaAhorros extends Cuenta {
    private double tasaInteres;

    public CuentaAhorros(String numeroCuenta, String titular, double saldo, double tasaInteres) {
        super(numeroCuenta, titular, saldo);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public String toString() {
        return "CuentaAhorros [numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo +
                ", tasaInteres=" + tasaInteres + "]";
    }
}

// Clase CuentaCorriente que hereda de Cuenta
class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    public CuentaCorriente(String numeroCuenta, String titular, double saldo, double limiteDescubierto) {
        super(numeroCuenta, titular, saldo);
        this.limiteDescubierto = limiteDescubierto;
    }

    public double getLimiteDescubierto() {
        return limiteDescubierto;
    }

    public void setLimiteDescubierto(double limiteDescubierto) {
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public void retirar(double cantidad) throws SaldoInsuficienteException {
        if (cantidad <= saldo + limiteDescubierto) {
            saldo -= cantidad;
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    @Override
    public String toString() {
        return "CuentaCorriente (numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", saldo=" + saldo +
                ", limiteDescubierto=" + limiteDescubierto + ")";
    }
}

// Clase Banco
class Banco {
    private List<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null; // Si no se encuentra la cuenta
    }

    public double calcularPromedioSaldos() {
        double sumaSaldos = 0;
        for (Cuenta cuenta : cuentas) {
            sumaSaldos += cuenta.getSaldo();
        }
        return sumaSaldos / cuentas.size();
    }

    public void ordenarCuentas() {
    	  Collections.sort(cuentas, Collections.reverseOrder());
    }

    public void mostrarCuentas() {
        ordenarCuentas();
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }
}

// Ejemplo de uso en el método principal
public class Bancor {
    public static void main(String[] args) throws SaldoInsuficienteException {
        Banco banco = new Banco();

        CuentaAhorros cuentaAhorros1 = new CuentaAhorros("003", "Don", 9000, 0.05);
        CuentaAhorros cuentaAhorros = new CuentaAhorros("001", "Juan", 5000, 0.05);
        CuentaCorriente cuentaCorriente = new CuentaCorriente("002", "Maria", 10000, 2000);

        banco.agregarCuenta(cuentaAhorros);
        banco.agregarCuenta(cuentaAhorros1);
        banco.agregarCuenta(cuentaCorriente);

        // Depósito y retiro de dinero
        cuentaAhorros.depositar(1000);
        cuentaCorriente.retirar(500);

        // Cálculo del promedio de los saldos
        double promedioSaldos = banco.calcularPromedioSaldos();
        System.out.println("El promedio de los saldos de todas las cuentas es: " + promedioSaldos);

        // Búsqueda de una cuenta específica por número de cuenta
        String numeroCuentaBuscado = "002";
        Cuenta cuentaBuscada = banco.buscarCuenta(numeroCuentaBuscado);
        if (cuentaBuscada != null) {
            System.out.println("La cuenta con número " + numeroCuentaBuscado + " ha sido encontrada: " + cuentaBuscada);
        } else {
            System.out.println("La cuenta con número " + numeroCuentaBuscado + " no ha sido encontrada.");
        }

        // Ordenamiento de las cuentas por saldo
        banco.ordenarCuentas();
        System.out.println("Lista de cuentas ordenadas por saldo:");
        banco.mostrarCuentas();
    }
}
