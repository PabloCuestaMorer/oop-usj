#include "Gallina.h"
Gallina::Gallina(string nombre, int patas)
{
	this->nombre = nombre;
	this->patas = patas;
}

void Gallina::alimentarse()
{
	cout << "Soy la gallina " << nombre << " y me estoy alimentado." << endl;
}
