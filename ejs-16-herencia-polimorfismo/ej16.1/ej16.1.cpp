// ej16.1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "Circulo.h"
#include "Cuadrado.h"
#include "Geometrico.h"

int main()
{

	// Crear un circulo con un radio de 5 y un centro en las coordenadas (0,0)
	Circulo c(0, 0, 5);
	// Calcular y mostrar el área del círculo
	c.calcularArea();
	// Imprimir el centro del círculo
	c.imprimirCentro();

	// Crear un cuadrado con un vértice en (1,1) y un centro en las coordenadas (0,0)
	Cuadrado q(0, 0, 1, 1);
	// Calcular y mostrar el área del cuadrado
	q.calcularArea();
	// Imprimir el centro del cuadrado
	q.imprimirCentro();

	// Instaciar un puntero Geometrico con una referencia de Cuadrado
	// Imprimira el area del Circulo pese a ser un Geometrico --> Polimorfismo
	cout << "TEST: Polimorfismo circulo desde geometrico" << endl;
	Geometrico* g = &c;
	g->calcularArea();

	return 0;

}
