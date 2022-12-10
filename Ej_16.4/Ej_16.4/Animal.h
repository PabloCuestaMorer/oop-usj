#pragma once
#include <iostream>
#include <string.h>

using namespace std;

class Animal
{
protected:
	string nombre;
	int patas;
public:
	Animal(string nombre = "animal", int patas = 0);

	virtual void alimentarse() = 0;
	virtual void dormir() = 0;
	virtual void trabajar() = 0;

};

