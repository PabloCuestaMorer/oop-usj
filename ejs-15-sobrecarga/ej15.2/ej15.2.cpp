//	****SOBRECARCA****
//  ej15.2.cpp : This file contains the 'main' function. Program execution begins and ends there.

#include <iostream>
#include "Complejo.h"

using namespace std;

int main()
{
	Complejo c1(2.2, 2.3);
	Complejo c2(1.1, 1.2);
	cout << c1;

	Complejo c3 = c1 * c2;
	cout << c3;

	return 0;
}

