#pragma once
#include "Geometrico.h"

class Cuadrado :
	public Geometrico
{
private:
	float vertice_x, vertice_y;
public:
	Cuadrado(float xC = 0, float yC = 0, float vertice_x = 0, float vertice_y = 0);
	void calcularArea();
};

