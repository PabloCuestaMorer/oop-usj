// PARCIAL II - PABLO CUESTA 
// parcial-2-pablo-cuesta.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include "Asignatura.h"
#include "Profesor.h"
#include "Asociado.h"
#include "PDI.h"

using namespace std;
int main()
{

	Asignatura poo(30053, 4, 2);
	Asignatura pfg(30092, 0, 0);

	pfg++;
	cout << pfg << endl;

	poo = (poo - 1);

	cout << " El resultado de la resta es: " << poo << endl;

	if (poo == pfg)
	{
		cout << "La asignatura es la misma." << endl;
	}

	Profesor* profesores[2];
	//profesor[0] = new Asociado("John Doe", "Matematicas", 15.0);
	//profesor[1] = new PDI("Fulano Detal", "Software", "Titular");

	for (int i = 0; i < 2; i++)
	{
		//profesor[i]->mostrarHoras();
	}

	return 0;
}


