#include "Pila.h"
#include <iostream>

using namespace std;

Pila::Pila() {
	cima = 0;
	mat = new char[MAXPILA];
}



void Pila::iniciarPila()
{
	cima = -1;
	mat = new char[MAXPILA];
}



void Pila::push(char c)
{
	if (isFull()) {
		cout << "La pila ya esta llena, no se pueden meter mas elementos" << endl;
	}
	else {
		cima++;
		mat[cima] = c;
	}
}



void Pila::pop()
{
	if (isEmpty()) {
		cout << "La pila ya esta vacia. " << endl;
	}
	else {
		cima--;
	}
}



void Pila::mostrarPila() const
{
	if (isEmpty()) {
		cout << "La pila esta vacia" << endl;
	}
	else {
		cout << "La pila contiene: ";
		for (int i = 0; i <= cima; i++) {
			cout << mat[i] << " ";
		}cout << endl;
		if (isFull())cout << "La pila esta llena" << endl;
	}
}



bool Pila::isEmpty() const
{
	if (cima == -1) {
		return true;
	}
	else {
		return false;
	}
}

bool Pila::isFull() const
{
	if (cima == MAXPILA - 1) {
		return true;
	}
	else {
		return false;
	}
}
