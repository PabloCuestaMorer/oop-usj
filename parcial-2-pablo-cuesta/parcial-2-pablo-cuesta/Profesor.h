#pragma once
#include <string>
#include <list>
#include "Asignatura.h"

using namespace std;
class Profesor
{
protected:
	string nombre;
	string departamento;
	list<Asignatura> asignaturas;
public:
	Profesor();
	Profesor(string nombre, string departamento);
	virtual void mostrarHoras() const = 0;
};

