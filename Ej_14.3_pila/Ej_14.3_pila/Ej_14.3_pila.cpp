// Ej_14.3_pila.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Pila.h"

int main()
{
	char a = 'b';
	char b = 'a';
	Pila p;

	p.iniciarPila();
	//SI INTENTAMOS LA MOSTRAR LA PILA SIN CONTENIDO COMPROBARA QUE ESTA VACIA Y NOS AVISARA
	p.mostrarPila();
	p.push(a);
	p.push(b);
	p.pop();

	p.mostrarPila();

	p.push(b);
	p.push(b);
	p.push(b);
	//SI QUITAS EL COMENTARIO DE ESTA LINEA TE MOSTRARÁ LA PILA Y TE DIRA QUE ESTA LLENA
	//p.push(b);
	p.mostrarPila();
	//SI INTENTAMOS METER MAS ELEMENTOS A LA PILA CUANDO ESTA LLENA, TE DIRA QUE YA ESTA LLENA
	//p.push(a);
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
