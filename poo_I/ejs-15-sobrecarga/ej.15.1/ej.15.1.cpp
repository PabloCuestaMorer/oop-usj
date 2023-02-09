// ****SOBRECARGA****
//ej.15.1.cpp : This file contains the 'main' function. Program execution begins and ends there.

#include "Fraccion.h"
using namespace std;
int main()
{
	Fraccion fraccion;
	Fraccion f1(2, 4);
	Fraccion f2(1, 4);

	cout << "fraccion = ";
	fraccion.mostrar();
	cout << "fraccion1 = ";
	f1.mostrar();
	cout << "fraccion2 = ";
	f2.mostrar();

	// Add the two fractions
	Fraccion f3 = f1 + f2;
	cout << "Fraction 3 (f1 + f2): " << f3 << endl;

	// Convert the fraction to a float and print using operator<<
	float f = (float)f3;
	cout << "Fraction 3 as a float: " << f << endl;

	return 0;
}