// Ej_16_1.cpp : This file contains the 'main' function. Program execution begins and ends there.

#include "Circulo.h"
#include "Cuadrado.h"
#include "Geometrico.h"
int main()
{
	Circulo c(2, 7, 25);
	c.calcularArea();

	Cuadrado cuadrado(2, 4);
	cuadrado.calcularArea();

	// Instaciar un puntero Geometrico con una referencia de Cuadrado
	Geometrico* g = &c;
	g->calcularArea();

}