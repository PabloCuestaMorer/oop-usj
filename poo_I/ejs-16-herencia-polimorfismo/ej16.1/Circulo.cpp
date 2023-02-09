#include "Circulo.h"
#define _USE_MATH_DEFINES
#include <math.h>


Circulo::Circulo(float xC, float yC, float radio) : Geometrico(xC, yC)
{
	this->radio = radio;
}

void Circulo::calcularArea()
{
	double area = M_PI * pow(this->radio, 2);
	cout << "El area del circulo es: " << area << endl;
}


