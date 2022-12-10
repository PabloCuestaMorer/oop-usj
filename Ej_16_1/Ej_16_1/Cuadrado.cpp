#include "Cuadrado.h"

Cuadrado::Cuadrado(float xC, float yC, float x, float y) : Geometrico(xC, yC)
{
	this->x = x;
	this->y = y;
}

void Cuadrado::calcularArea()
{
	cout << "El area del cuadrado es: " << (x * y) << endl;
}
