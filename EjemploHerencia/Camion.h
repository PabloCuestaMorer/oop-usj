#pragma once
#include "Vehiculo.h"

class Camion : public Vehiculo {
private:
	float peso;
public:
	Camion();
	Camion(float, int, string);

	void mostrar();

	float getPeso() { return peso; }
};

