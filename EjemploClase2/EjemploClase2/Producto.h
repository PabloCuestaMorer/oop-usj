#pragma once
#include <iostream>
using namespace std;
class Producto
{
public:
	Producto();
	Producto(int, float = 0.0);
	Producto(const Producto&);
private:
	int identificador;
	float precio;

public:
	void modificarPrecio(float);
	void mostrar() const;
};

