#include "Camion.h"

Camion::Camion() : Vehiculo() {
	peso = 0.0;
}

Camion::Camion(float peso, int potencia, string marca) : Vehiculo(potencia, marca) {
	this->peso = peso;
}

void Camion::mostrar() {
	cout << "Soy un camion." << endl;
	cout << "Potencia: " << potencia << " CV, marca: " << marca << " y peso: " << peso << endl;
}