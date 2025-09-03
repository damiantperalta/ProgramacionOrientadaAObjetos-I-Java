import java.util.*;
import java.io.*;
//import java.util.ArrayList;

public class TestTorneo {
	
	
	public static void main(String []args) {
		
		//revisar las estadisticas
		TestTorneo test1 = new TestTorneo();
		Robot robot= new Robot();
	 Luchador luchador = new Luchador(100,50,86);
	 Tirador tirador = new Tirador(90,30,86);
	 Volador volador = new Volador(80,50,36);
	 
	System.out.println("La energía promedio de los participantes es: "+ robot.promedio(luchador, tirador, volador));
	
	String ganador= robot.ganador(luchador, tirador, volador);
	System.out.println( ganador);
	 
	 
	 
	}
	
	
	
	
	
	
	

}