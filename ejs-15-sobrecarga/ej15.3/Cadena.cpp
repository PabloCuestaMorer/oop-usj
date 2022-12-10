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
	longitud = strlen(c);
	cadena = new char[longitud + 1];	// + \0
	strcpy(cadena, c);
}

Cadena::Cadena(char c)
{
	longitud = 1;
	cadena = new char[longitud + 1];
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
	} else {
		cout << "Error, el entero es muy pequeño o muy grande" << endl;
	}
}

void Cadena::muestraCaracter(int i) const
{
	if (0 <= i < longitud) {
		cout << cadena[i] << endl;
	} else {
		cout << "Error, el entero es muy pequeño o muy grande" << endl;
	}
}

void Cadena::muestra(void)
{
	cout << "La cadena es :" << cadena << endl;

}

void Cadena::agnadir(const char* cad)
{
	Cadena aux(*this);
	longitud = longitud + strlen(cad);
	cadena = new char[longitud + 1];
	strcpy(cadena, aux.cadena);
	strcat(cadena, cad);
}

Cadena Cadena::operator+(const Cadena& c)
{
	Cadena outCadena;
	outCadena.agnadir(this->cadena);
	outCadena.agnadir(c.cadena);

	return Cadena(outCadena);
}

Cadena& Cadena::operator=(const Cadena& c)
{
	longitud = c.longitud;
	cadena = new char[longitud + 1];
	strcpy(cadena, c.cadena);
	return *this;
}

ostream& operator<<(ostream& os, Cadena& c)
{
	os << "cadena: " << c.cadena << "; longitud: " << c.longitud << endl;
	return os;
}

//char Cadena::operator[](int index)
//{
//	if (index > -1 && index < longitud)
//	{
//		return cadena[index];
//	} 
//	else
//	{
//		return '\0';
//	}
//}

char& Cadena::operator[](int index)
{
	char aux = '\0';
	if (index > -1 && index < longitud)
	{
		aux = cadena[index];
	} else
	{
		return aux;
	}
}