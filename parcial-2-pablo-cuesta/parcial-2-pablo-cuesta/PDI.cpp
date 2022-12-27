#include "PDI.h"

PDI::PDI() : Profesor()
{
	categoria = "";
}

PDI::PDI(string nombre, string departamento, string categoria) : Profesor(nombre, departamento)
{
	this->categoria = "";
}
