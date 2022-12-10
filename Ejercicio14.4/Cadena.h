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
	int getLongitud() const { return longitud;}
	void muestra(void);
	void agnadir(const char*);
};

