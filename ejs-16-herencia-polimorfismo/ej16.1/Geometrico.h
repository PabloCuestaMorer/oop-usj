#pragma once
#include <iostream>

using namespace std;

class Geometrico
{
protected:
	float xC;
	float yC;
public:
	Geometrico(float x = 0, float y = 0) : xC(x), yC(y) {};
	void imprimirCentro() const;

	/**
	 * A pure virtual function; is a virtual function that does not have an implementation..
	 * It is indicated by placing the = 0 syntax after the function declaration.
	 * Now the class Geometrico would be an abstract base class and could not be instantiated 
	 * the childs have to implement the function.
	 * 
	 * If you do not use the = 0 syntax after a virtual function, 
	 * it becomes a regular virtual function rather than a pure virtual function. 
	 * This means that the virtual function has a default implementation in the base class, 
	 * which can be overridden by derived classes if they choose to do so.
	 */
	virtual void calcularArea() = 0;
};

