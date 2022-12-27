#pragma once
#include <iostream>
#include <math.h>

using namespace std;
class Asignatura
{
private:
	int identificador;
	float num_horas_semana;
	int num_dias_semana;
public:
	Asignatura();
	Asignatura(int identificador, float num_horas_semana, int num_dias_semana);

	// Sobrecarga
	friend Asignatura& operator++ (const Asignatura& izq, int plus_horas);
	Asignatura operator- (int dcha);
	friend int operator== (const Asignatura& izq, const Asignatura& dcha);
	friend ostream& operator<<(ostream& os, Asignatura& asignatura);
};


