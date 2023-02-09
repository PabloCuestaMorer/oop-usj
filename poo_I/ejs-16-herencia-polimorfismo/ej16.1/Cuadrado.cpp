#include "Cuadrado.h"



Cuadrado::Cuadrado(float xC, float yC, float vertice_x, float vertice_y) : Geometrico(xC, yC)
{
	this->vertice_x = vertice_x;
	this->vertice_y = vertice_y;
}

void Cuadrado::calcularArea()
{
	double lado = sqrt(pow(this->vertice_x - this->xC, 2) + pow(this->vertice_y - this->yC, 2));
	double area = lado * lado;

	cout << "El area del cuadrado es: " << area << endl;
}
