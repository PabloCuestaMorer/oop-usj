#include "Fraccion.h"

Fraccion::Fraccion()
{
	numerador = 0;
	denominador = 0;
}

Fraccion::Fraccion(long numerador, long denominador)
{
	this->numerador = numerador;
	this->denominador = denominador;
}

void Fraccion::mostrar() const
{
    cout << numerador << "/" << denominador << endl;
}

Fraccion Fraccion::operator+ (const Fraccion& other) const
{
    // Calculate the numerator and denominator of the result
    long newNumerator = numerador * other.denominador + denominador * other.numerador;
    long newDenominator = denominador * other.denominador;

    // Return a new Fraccion object with the calculated values
    return Fraccion(newNumerator, newDenominator);
}

Fraccion::operator float() const
{
    return (float)this->numerador / this->denominador;
}

ostream& operator<<(ostream& out, Fraccion& f)
{
    out << f.numerador << "/" << f.denominador << endl;
    return out;
}
