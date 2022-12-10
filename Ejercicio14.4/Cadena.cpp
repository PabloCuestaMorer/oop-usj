#include "Cadena.h"

#pragma warning (disable : 4996)


Cadena::Cadena()
{
	cadena = new char[1];
	cadena[0] = '\0';
	longitud = 0;
}

Cadena::Cadena(const char* c)
{
	longitud = strlen(c) ;
	cadena = new char[longitud +1];	// + \0
	strcpy(cadena, c);
}

Cadena::Cadena(char c) 
{
	longitud = 1;
	cadena = new char[longitud+1];
	cadena[0] = c;
	cadena[1] = '\0';
	
}

Cadena::Cadena(const Cadena& original)
{
	longitud = original.longitud;
	cadena = new char[longitud + 1];
	strcpy(cadena, original.cadena);
}

void Cadena::cambiaCaracter(int i, char c)
{
	if (0 <= i && i < longitud) {
		cadena[i] = c;
	}
	else {
		cout << "Error, el entero es muy pequeño o muy grande" << endl;
	}
}

void Cadena::muestraCaracter(int i) const
{
	if (0 <= i < longitud) {
		cout << cadena[i] << endl;
	}
	else {
		cout << "Error, el entero es muy pequeño o muy grande" << endl;
	}
}

void Cadena::muestra(void)
{
	cout <<"La cadena es :" <<cadena << endl;

}

void Cadena::agnadir(const char* cad)
{
	Cadena aux(*this);
	longitud = longitud + strlen(cad);
	cadena = new char[longitud + 1];
	strcpy(cadena, aux.cadena);
	strcat(cadena, cad);
}
	

