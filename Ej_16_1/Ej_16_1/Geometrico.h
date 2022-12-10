#pragma once
#include <iostream>

using namespace std;

class Geometrico
{
protected:
	float xC;
	float yC;
public:
	Geometrico(float x = 0, float y = 0) {};
	void imprimirCentro() const;

	virtual void calcularArea() = 0;
};

