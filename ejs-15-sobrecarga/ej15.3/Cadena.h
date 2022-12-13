#pragma once
#include <iostream>


using namespace std;

class Cadena
{
	char* cadena;
	int longitud;

public:
	Cadena();
	Cadena(const char* string);
	Cadena(char a);
	// Copy constructor
	Cadena(const Cadena& cadena);

	void cambiaCaracter(int, char);
	void muestraCaracter(int) const;
	int getLongitud() const { return longitud; }
	void muestra(void);
	void addChar(const char a);
	void addString(const char*);
	void invertirCadena();
	void toUpper();
	bool isPalindrome();

	// Operators overloading
	Cadena operator+(const Cadena&);
	Cadena operator+(const char&);
	Cadena operator-(const Cadena&);
	Cadena& operator=(const Cadena&);
	Cadena& operator=(const char&);
	friend ostream& operator<<(ostream&, Cadena&);
	char& operator[](int index);
};

