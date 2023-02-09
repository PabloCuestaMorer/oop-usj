#include "Circulo.h"
const double PI = 3.14159265358979323846;

Circulo::Circulo()
{
	c_x = 0; c_y = 0; radio = 0.0;
}

Circulo::Circulo(int x)
{
	c_x = x;
	c_y = 0;
	radio = 0.0;
}

Circulo::Circulo(int x, int y, float r)
{
	c_x = x;
	c_y = y;
	radio = r;
}

void Circulo::visualizar(void)
{
	cout << c_x << " " << c_y << " " << radio << endl;
}

float Circulo::longitud(void)
{
	return (float)(2 * PI * radio);
}
