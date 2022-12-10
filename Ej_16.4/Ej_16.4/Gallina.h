#pragma once
#include "Animal.h"
class Gallina : public Animal
{
public:
	Gallina(string nombre, int patas);

	void alimentarse();
	void dormir();
	void trabajar();
};

