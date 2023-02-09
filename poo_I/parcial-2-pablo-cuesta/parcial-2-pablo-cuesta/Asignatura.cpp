#include "Asignatura.h"

Asignatura::Asignatura() :identificador(0), num_horas_semana(0), num_dias_semana(0) {}

Asignatura::Asignatura(int i, float h, int d)
{
	this->identificador = i;
	this->num_horas_semana = h;
	int dias_necesarios = (int)(round(h / 2));
	if (num_dias_semana < dias_necesarios)
	{
		cerr << "ERROR: Maximo dos horas por dia." << endl;
		this->num_dias_semana = dias_necesarios;
	} else
	{
		this->num_dias_semana = d;
	}

}

Asignatura Asignatura::operator-(int dcha)
{
	float resultado = num_horas_semana - dcha;

	if (dcha < 0 || resultado < 0)
	{
		num_horas_semana = 0;
	} else
	{
		num_horas_semana = resultado;
	}
	Asignatura asignatura_aux(identificador, num_horas_semana, num_horas_semana);

	return asignatura_aux;
}

Asignatura& operator++(const Asignatura& izq, int plus_horas)
{
	Asignatura asignatura_aux;
	/*izq.num_horas_semana + plus_horas;*/
	return asignatura_aux;
}

int operator==(const Asignatura& izq, const Asignatura& dcha)
{
	return izq.identificador == dcha.identificador && izq.num_horas_semana == dcha.num_horas_semana && izq.num_dias_semana == dcha.num_dias_semana;
}

ostream& operator<<(ostream& os, Asignatura& a)
{
	os << a.identificador << ": " << a.num_horas_semana << "h/s --- " << a.num_dias_semana << "d/s" << endl;
	return os;
}
