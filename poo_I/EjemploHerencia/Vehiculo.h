#pragma once
#include <iostream>

using namespace std;

class Vehiculo {
protected:
	int potencia;
	string marca;
public:
	Vehiculo();
	Vehiculo(int, string);

	virtual void mostrar();
};

