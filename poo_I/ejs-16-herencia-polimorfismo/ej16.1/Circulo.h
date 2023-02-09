#pragma once
#include "Geometrico.h"

class Circulo : public Geometrico
{
private:
	float radio;
public:
	Circulo(float xC = 0, float yC = 0, float radio = 0);
	void calcularArea();

};

