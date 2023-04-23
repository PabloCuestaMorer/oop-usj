package main;

import Antonio.plantas2.Persona;
import Antonio.plantas2.Poblacion;

public class Simulacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Poblacion poblacion = new Poblacion(1000);
		int dia = 1;
		
		while(!poblacion.finDelMundo()) {
			
			System.out.println("Dia "+ dia+":");
			
			for(Persona persona : poblacion.getPersonas()) {
				persona.unDiaMas(poblacion);
			}
			
			poblacion.mostrarPoblacion(); //pregunta 6
			
			System.out.println();
			dia++;
		}
	}

}
//APARTADO 7 
//APARTADO 9 
//APARTADO 8 

