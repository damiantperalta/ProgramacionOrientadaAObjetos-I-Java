
public class Robot {
	private int energia;
	private int resistencia;
	private int fuerza;
	private int cont;
	
	
	public Robot() {
		this.energia=0;
		this.resistencia=0;
		this.fuerza=0;
		this.cont=5;
		
	}
	
	public Robot(int energia,int resistencia,int fuerza) {
		this.energia=energia;
		this.resistencia=resistencia;
		this.fuerza=fuerza;
		this.cont=5;
	}
	
	
	

	@Override
	public String toString() {
		return "Robot [energia=" + energia + ", resistencia=" + resistencia + ", fuerza=" + fuerza + ", cont=" + cont
				+ "]";
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void luchar(Robot r1,Robot r2) {
		if(r1.getCont()>0) {
			
			System.out.println("Robot 1 ataca a Robot 2");
			System.out.println("Paff");
			System.out.println("Robot 2 recibe el ataque");
			System.out.println("Auchh (En idioma robótico)");
			int Resisty=0;
			Resisty=r2.getResistencia()-20;
			r2.setResistencia(Resisty);
			
			if(r1.getFuerza()>r2.getResistencia()) {
				int energy2=0;
				energy2=r1.getFuerza()-r2.getResistencia();
				r2.setEnergia(energy2);	
				}
			int contador;
			contador=r1.getCont()-1;
			r1.setCont(contador);
		}else {
			System.out.println("El robot que quiere atacar no tiene más ataques disponibles");
		}
	}
public double promedio(Robot r1, Robot r2, Robot r3) {
	double total;
	
	total=r1.getEnergia()+r2.getEnergia()+r3.getEnergia();
	
	double promedio=total/3.0;
	
	
		return promedio;
	}

public String ganador(Robot r1, Robot r2, Robot r3) {
	
	if(r1.getEnergia()>r2.getEnergia() && r1.getEnergia()>r3.getEnergia()) {
		return "El ganador es: " + r1.toString();
	}
		if(r2.getEnergia()>r1.getEnergia() && r2.getEnergia()>r3.getEnergia()) {
			return "El ganador es: " + r2.toString();
	}
		else {
			return "El ganador es: " + r3.toString();
		}
	

}
}
