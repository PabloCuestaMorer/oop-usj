#include <iostream>

#include "Cadena.h"

int main() {


	Cadena cadena;
	Cadena cadena1("Hola");
	Cadena cadena2('c');
	Cadena cadena3(cadena2);

	cadena1.muestra();
	cadena2.cambiaCaracter(0,'a');
	cadena2.muestra();
	cadena2.agnadir("Pedro");
	cadena2.muestra();

}