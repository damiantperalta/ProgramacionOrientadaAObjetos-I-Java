/* ejemplo de como declaramos una referencia a ArrayList
 * metodo add(), class contenedora, recorrido secuencial de una coleccion
 */
/**
 * This program demonstrates the ArrayList class.
 * @version 1.11 2012-01-26 - Editado gad 
 * @author Cay Horstmann  // capitulo 5
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.time.*;
import java.util.Scanner;

public class Empleado
{

   private String nombre;
   private double salario;
   private LocalDate fecha_alta;

   public Empleado(String nombre, double salario, int year, int month, int day)
   {
      this.nombre  = nombre;
      this.salario = salario;
      this.fecha_alta   = LocalDate.of(year, month, day);
   }
   
   public void setNombre(String nom)
   {
       nombre=nom;
   }   
   
   public void setSalario(double sala)
   {
       salario=sala;
   }   
   
   public void setFechaAlta(LocalDate fecha_alta) {
       this.fecha_alta = fecha_alta;
   }

   public String getNombre()
   {
      return nombre;
   }

   public double getSalario()
   {
      return salario;
   }

   public LocalDate getFecha_alta()
   {
      return fecha_alta;
   } 

   public void raiseSalario(double byPercent)
   {
      double raise = salario * byPercent / 100;
      salario += raise;
   }   
   @Override
   public String toString() {
       return "Empleado [nombre=" + nombre + ", fecha de alta=" + fecha_alta + ", salario=" + salario + "]";
   }
}

