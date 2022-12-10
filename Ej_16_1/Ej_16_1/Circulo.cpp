#include "Circulo.h"

Circulo::Circulo(float xC, float yC, float radio) : Geometrico(xC, yC)
{
	this->radio = radio;
}

void Circulo::calcularArea()
{
	cout << "El area del circulo es: " << 3.14*radio*radio << endl
}
