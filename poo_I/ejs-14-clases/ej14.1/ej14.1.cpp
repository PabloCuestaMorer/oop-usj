// ej14.1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Circulo.h"

using namespace std;


int main()
{
	// Need to use the 'new' keyword to create instances of the class
	// In C++, objects created with the new keyword must be assigned to a pointer variable
	Circulo* c1 = new Circulo(5, 4, 4);
	Circulo* c2 = new Circulo();
	Circulo* c3 = new Circulo(5);

	// Need to use the '->' operator to access class members on pointers
	c1->visualizar();
	c2->visualizar();
	c3->visualizar();
	cout << c1->longitud() << endl;

	return 0;
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
