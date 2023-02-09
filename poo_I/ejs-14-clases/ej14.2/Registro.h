#pragma once
#include <string>
#include <iostream>

using namespace std;
class Registro
{
private:
	const int MAX_LENGTH_NOMBRE = 50;
	const int MAX_LENGTH_TELEFONO = 15;
	char* nombre;
	char* telefono;
	int id;
	// Static variable to keep track of the last assigned id
	static int s_id;
public:
	Registro();
	Registro(char*, char*);
	
	Registro(const Registro&);
	void entradaDatos();
	void salidaDatos();
};

