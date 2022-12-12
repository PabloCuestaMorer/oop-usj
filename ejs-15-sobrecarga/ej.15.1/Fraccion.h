#pragma once

#include <iostream>
using namespace std;

class Fraccion
{
private:
	long numerador, denominador;
public:
	Fraccion();
	Fraccion(long numerador, long denominador);

	void mostrar() const;

	// Function to add two fractions
	Fraccion operator+ (const Fraccion&) const;
	// Type conversion operator to convert fraction to float
	operator float() const;
	// Friend function to overload the insertion operator for output
	friend ostream& operator<< (ostream&, Fraccion&);
};

