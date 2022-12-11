#pragma once
#include <iostream>
using namespace std;
class Circulo
{
private:
	int c_x, c_y;
	float radio;
public:
	Circulo();
	Circulo(int x);
	Circulo(int x, int y, float r);

	void visualizar(void);
	float longitud(void);
};

