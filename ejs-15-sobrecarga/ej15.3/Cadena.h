#pragma once
#include <iostream>


using namespace std;

class Cadena
{
	char* cadena;
	int longitud;

public:
	Cadena();
	Cadena(const char*);
	Cadena(char);
	Cadena(const Cadena&);	//paso por referencia con el const

	void cambiaCaracter(int, char);
	void muestraCaracter(int) const;
	int getLongitud() const { return longitud; }
	void muestra(void);
	void agnadir(const char*);

	// Operators overloading
	Cadena operator+(const Cadena&);
	Cadena& operator=(const Cadena&);
	friend ostream& operator<<(ostream&, Cadena&);
	/*char operator[](int);*/

	/*
	* Pregunta examen.
	* Sobrecargar[] pero que me modifique lo de esa posicion.
	* Paso por referencia para poder modificar el char en ese index
	*/
	char& operator[](int);
};

