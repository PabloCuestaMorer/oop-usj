#include "Registro.h"
#pragma warning(disable : 4996)
// Initialize the static variable with 0
int Registro::s_id = 0;

Registro::Registro()
{
	nombre = new char[MAX_LENGTH_NOMBRE];
	nombre[0] = '\0';
	telefono = new char[MAX_LENGTH_TELEFONO];
	telefono[0] = '\0';
	id = s_id++;
}

Registro::Registro(char* nombre, char* tfno)
{
	this->nombre = new char[MAX_LENGTH_NOMBRE];
	strcpy(this->nombre, nombre);
	this->telefono = new char[MAX_LENGTH_TELEFONO];
	strcpy(this->telefono, tfno);
	id = s_id++;
}

Registro::Registro(const Registro& original)
{
	nombre = new char[strlen(original.nombre) + 1];
	strcpy(nombre, original.nombre);
	telefono = new char[strlen(original.telefono) + 1];
	strcpy(telefono, original.telefono);
	id = original.id;
}

void Registro::entradaDatos()
{
	cout << "Introduzca su nombre: ";
	cin.getline(nombre, MAX_LENGTH_NOMBRE);
	cout << "Introduzca su numero de telefono: ";
	cin.getline(telefono, MAX_LENGTH_TELEFONO);
	//clear the input buffer
	fflush(stdin);

}

void Registro::salidaDatos()
{
	cout << "Nombre: " << nombre << endl;
	cout << "Telefono: " << telefono << endl;
	cout << "Numero de identificacion: " << id << endl;
}
