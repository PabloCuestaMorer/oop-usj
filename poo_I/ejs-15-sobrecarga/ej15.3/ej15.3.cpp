// ****SOBRECARGA****
// ej15.3.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Cadena.h"

int main()
{
	Cadena c;
	Cadena c1("Hola");
	Cadena c2('a');

	c1[2] = 'P';
	cout << c1;
	cout << c1[2];
}