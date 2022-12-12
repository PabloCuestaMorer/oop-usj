#include "Cadena.h"
#pragma warning(disable : 4996)

Cadena::Cadena()
{
	longitud = 1;
	cadena = new char[longitud + 1];
	cadena[longitud] = '\0';

}

Cadena::Cadena(const char* cadena)
{
	longitud = (int)strlen(cadena);
	this->cadena = new char[longitud + 1];
	strcpy(this->cadena, cadena);
}

Cadena::Cadena(char a)
{
	longitud = 1;
	cadena = new char[longitud + 1];
	cadena[longitud] = '\0';
	cadena[0] = a;
}

void Cadena::cambiaCaracter(int i, char a)
{
	cadena[i] = a;
}

void Cadena::muestraCaracter(int i) const
{
	cout << " [ " << i << " ] : " << cadena[i] << endl;
}

int Cadena::getLongitud() const
{
	return longitud;
}

void Cadena::muestra(void) const
{
	if (longitud > 0)
	{
		for (size_t i = 0; i < longitud; i++)
		{
			cout << "[ " << i << " ]: " << cadena[i] << endl;
		}
		cout << endl;
	}
}

void Cadena::addChar(const char a)
{
	// Reserve an aux array with +1 space than the previous one
	longitud++;
	char* auxChars = new char[longitud + 1];
	auxChars[longitud] = '\0';

	// copy origin array to aux
	strcpy(auxChars, cadena);
	// add the char to aux
	auxChars[longitud - 1] = a;

	// Free the memory of the original string
	delete[] cadena;

	// restore origin with the new char
	cadena = new char[longitud + 1];
	strcpy(cadena, auxChars);

}

void Cadena::invertirCadena()
{
	// Create reserve aux arr
	char* reverse = new char[longitud + 1];
	reverse[longitud] = '\0';
	// Reverse loop
	for (int i = longitud - 1, j = 0; i >= 0; i--, j++)
	{
		reverse[j] = cadena[i];
	}
	// Copy reverse to cadena
	strcpy(cadena, reverse);
}

void Cadena::toUpper()
{
	for (int i = 0; i < longitud - 1; i++)
	{
		cadena[i] = toupper(cadena[i]);
	}
}


bool Cadena::isPalindrome()
{
	// A palindrome is a word, phrase, number, or other sequence of characters which 
	// reads the same forwards and backwards.For example, the word "racecar" is a 
	// palindrome because it is spelled the same forwards and backwards.
	bool is_palindrome = true;
	for (int i = 0; i < longitud / 2; i++)
	{
		if (cadena[i] != cadena[longitud - i - 1])
		{
			is_palindrome = false;
			break;
		}
	}
	return is_palindrome;
}

