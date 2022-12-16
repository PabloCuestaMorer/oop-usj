#include "Cadena.h"
#pragma warning (disable : 4996)


Cadena::Cadena()
{
	longitud = 0;
	cadena = new char[longitud + 1];
	cadena[longitud] = '\0';
}


Cadena::~Cadena()
{
	delete[] cadena;
}

Cadena::Cadena(const char* string)
{
	longitud = (int)(strlen(string));
	// longitud + 1 --> '\0'
	cadena = new char[longitud + 1];
	strcpy(cadena, string);
}

Cadena::Cadena(char c)
{
	longitud = 1;
	cadena = new char[longitud + 1];
	cadena[0] = c;
	cadena[longitud] = '\0';

}

Cadena::Cadena(const Cadena& original)
{
	longitud = original.longitud;
	cadena = new char[longitud + 1];
	cadena[longitud] = '\0';
	strcpy(cadena, original.cadena);
}

void Cadena::cambiaCaracter(int i, char c)
{
	if (0 <= i && i < longitud)
	{
		cadena[i] = c;
	} else
	{
		cerr << "ERROR: index out bound exception" << endl;
	}
}

void Cadena::muestraCaracter(int i) const
{
	if (0 <= i && i < longitud)
	{
		cout << " [ " << i << " ] : " << cadena[i] << endl;
	} else
	{
		cerr << "ERROR: index out bound exception" << endl;
	}
}

void Cadena::muestra(void)
{
	cout << cadena << endl;

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

void Cadena::addString(const char* string)
{
	// Save the current string
	Cadena aux(*this);
	// New longitud
	longitud = longitud + (int)(strlen(string));
	// save the new length
	cadena = new char[longitud + 1];
	cadena[longitud] = '\0';
	// Copy the old string
	strcpy(cadena, aux.cadena);
	// Copy the new string (after old)
	strcat(cadena, string);
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

Cadena Cadena::operator+(const Cadena& c)
{
	Cadena outCadena;
	outCadena.addString(this->cadena);
	outCadena.addString(c.cadena);

	return Cadena(outCadena);
}

Cadena Cadena::operator+(const char& op_dcha)
{
	Cadena aux(*this), myCad;
	myCad.longitud = aux.longitud + 1;
	myCad.cadena = new char[myCad.longitud + 1];
	strcpy(myCad.cadena, aux.cadena);
	myCad.cadena[myCad.longitud - 1] = op_dcha;
	myCad.cadena[myCad.longitud] = '\0';
	return myCad;
}

Cadena Cadena::operator-(const Cadena& op_dcha)
{
	Cadena myCad, aux(*this);
	int cont;
	char auxi;
	for (int i = 0; i < aux.longitud; i++)
	{
		cont = 0;
		for (int j = i; j < i + op_dcha.longitud; j++)
		{
			//COMPARA CADENAS MISMA LENGTH
			if (j < aux.longitud)
			{
				if (aux.cadena[j] == op_dcha.cadena[cont])
				{
					cont++;
				} else
				{
					break;
				}
			} else
			{
				//Se sale
				break;
			}
			//Modif cadena en última iteracion
			if (cont == op_dcha.longitud)
			{
				for (j = i; j < aux.longitud; j++)
				{
					if (j + op_dcha.longitud < aux.longitud)
					{
						auxi = aux.cadena[j + op_dcha.longitud];
						aux.cadena[j + op_dcha.longitud] = aux.cadena[j];
						aux.cadena[j] = auxi;
					} else
					{
						//Se sale
						aux.longitud -= op_dcha.longitud;
						aux.cadena[j] = '\0';
						break;
					}
				}
			}
		}
	}
	//Transcribir a myCad
	myCad.longitud = aux.longitud;
	myCad.cadena = new char[myCad.longitud + 1];
	strcpy(myCad.cadena, aux.cadena);
	return myCad;
}

Cadena& Cadena::operator=(const Cadena& c)
{
	longitud = c.longitud;
	cadena = new char[longitud + 1];
	strcpy(cadena, c.cadena);
	return *this;
}

Cadena& Cadena::operator=(const char& op_dcha)
{
	longitud = 1;
	cadena = new char[longitud + 1];
	cadena[0] = op_dcha;
	cadena[1] = '\0';
	return (*this);
}

ostream& operator<<(ostream& os, Cadena& c)
{
	os << "cadena: " << c.cadena << "; longitud: " << c.longitud << endl;
	return os;
}

char& Cadena::operator[](int i)
{
	if (i < 0 || i > longitud)
	{
		cerr << "ERROR: index out bound exception" << endl;
	}

	return cadena[i];
}


