// ej14.4.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Cadena.h"

using namespace std;
int main()
{
	Cadena c;
	Cadena c1('a');
	c1.muestra();

	Cadena c2("Pablo");
	c2.muestra();
	cout << "Longitud cadena c2: " << c2.getLongitud() << endl;

	c2.muestraCaracter(2);
	c2.cambiaCaracter(c2.getLongitud() - 1, 'a');
	cout << "Prueba cambiaCaracter(): " << endl;
	c2.muestra();

	cout << "Prueba addChar(): " << endl;
	c2.addChar('C');
	c2.muestra();

	cout << "Prueba invertirCadena(): " << endl;
	c2.invertirCadena();
	c2.muestra();
	c2.invertirCadena();

	cout << "Prueba toUpper(): " << endl;
	c2.toUpper();
	c2.muestra();

	cout << "Prueba isPalindrome(): " << endl;
	Cadena palindromeArr("radar");
	palindromeArr.muestra();
	cout << "is_Palindrome = " << boolalpha << palindromeArr.isPalindrome() << endl;

	Cadena no_palindromeArr("Pablo");
	no_palindromeArr.muestra();
	cout << "is_Palindrome = " << boolalpha << no_palindromeArr.isPalindrome() << endl;

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
