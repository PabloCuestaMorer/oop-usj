#include "Complejo.h"

Complejo::Complejo()
{
	real = 0.0;
	img = 0.0;
}

Complejo::Complejo(double real, double img)
{
	this->real = real;
	this->img = img;
}

Complejo::Complejo(const Complejo& complejo)
{
	real = complejo.real;
	img = complejo.img;
}

void Complejo::setData()
{
	cout << "Real: " << endl;
	cin >> this->real;
	cout << "Img: " << endl;
	cin >> this->img;
}

void Complejo::setReal(double real)
{
	this->real = real;
}

void Complejo::setImg(double img)
{
	this->img = img;
}

Complejo Complejo::operator+(const Complejo& complejo)
{

	return Complejo(real + complejo.real, img + complejo.img);
}

Complejo Complejo::operator-(const Complejo& complejo)
{
	return Complejo(real - complejo.real, img - complejo.img);
}

Complejo& Complejo::operator=(const Complejo& complejo)
{
	real = complejo.real;
	img = complejo.img;
	return *this;
}

int operator==(const Complejo& complejo1, const Complejo& complejo2)
{

	return 	complejo1.real == complejo2.real && complejo1.img == complejo2.img;
}

int operator!=(const Complejo& complejo1, const Complejo& complejo2)
{

	return complejo1.real != complejo2.real || complejo1.img != complejo2.img;
}

ostream& operator<<(ostream& os, Complejo& complejo)
{
	return os << "real: " << complejo.real << ", img: " << complejo.img << endl;
}
