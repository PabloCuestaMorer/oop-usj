#include "Asociado.h"


Asociado::Asociado() : Profesor()
{
	porcentaje_jornada = 0;
}

Asociado::Asociado(string nombre, string departamento, float porcentaje_jornada) : Profesor(nombre, departamento)
{
	this->porcentaje_jornada = porcentaje_jornada;
}

void Asociado::mostrarHoras()
{
}
