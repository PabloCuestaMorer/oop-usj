#pragma once
#include <iostream>

using namespace std;

class Complejo
{
private:
	double real;
	double img;
public:
	// Constructores
	Complejo();
	Complejo(double real, double img = 0.0);
	Complejo(const Complejo& complejo);
	// Pedir datos por consola
	void setData();
	void setReal(double real);
	void setImg(double img);
	double getReal() { return real; }
	double getImg() { return img; }

	// Sobrecarga de operadores aritm�ticos
	Complejo operator+ (const Complejo&);
	Complejo operator- (const Complejo&);
	// Opcional
	Complejo operator* (const Complejo&);
	// Opcional
	Complejo operator/ (const Complejo&);
	// Sobrecarga del operador de asignaci�n
	Complejo& operator= (const Complejo&);
	// Sobrecarga de operadores de comparaci�n
	friend int operator== (const Complejo&, const Complejo&);
	friend int operator!= (const Complejo&, const Complejo&);
	// Sobrecarga del operador de inserci�n en el flujo de salida
	friend ostream& operator<< (ostream&, Complejo&);
};

