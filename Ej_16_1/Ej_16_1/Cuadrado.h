#pragma once
#include "Geometrico.h"

class Cuadrado : public Geometrico
{
private:
	float x, y;
public:
	Cuadrado(float xC = 0, float yC = 0, float x = 0, float y = 0);
	void calcularArea();
};

