#pragma once
#include <iostream>
using namespace std;

class Punto2D {
private:
	float coor_x, coor_y;
	string nombre;
public:
	Punto2D();
	Punto2D(float, float y=0.0);

	friend ostream& operator<<(ostream&, Punto2D&);
	
	//Sobrecarga + como m�todo
	Punto2D operator+(Punto2D);

	//Sobrecarga - como friend
	friend Punto2D operator-(Punto2D, Punto2D);

	//Sobrecarga operador asignaci�n (=) 
	//(en este caso la hace bien el compilador por si solo, 
	//pero la hacemos para tener un ejemplo)
	Punto2D& operator=(const Punto2D&);

	//Cambio a float
	operator float();

	//Operador de indexaci�n []
	float operator[](int);
};

