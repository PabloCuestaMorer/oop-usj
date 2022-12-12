#pragma once
#include <string>
#include <iostream>

using namespace std;
class Cadena
{
private:
	int longitud;
	char* cadena;
public:
	Cadena();
	Cadena(const char* array);
	Cadena(char a);
	void cambiaCaracter(int index, char letra);
	void muestraCaracter(int index) const;
	int getLongitud() const;
	void muestra(void) const;
	void addChar(const char newChar);
	void invertirCadena();
	void toUpper();
	bool isPalindrome();
	//~Cadena();
};

