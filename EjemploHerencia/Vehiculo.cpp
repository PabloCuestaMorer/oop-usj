#include "Vehiculo.h"

Vehiculo::Vehiculo() {
	potencia = 0;
	marca = "default";
}

Vehiculo::Vehiculo(int potencia, string marca) {
	this->potencia = potencia;
	this->marca = marca;
}

void Vehiculo::mostrar() {
	cout << "Soy un vehiculo." << endl;
	cout << "Potencia: " << potencia << "CV y marca: " << marca << endl;
}