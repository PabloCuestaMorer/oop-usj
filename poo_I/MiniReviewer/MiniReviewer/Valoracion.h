#pragma once
#include <string>

using namespace std;

class Valoracion {
private:
	float puntuacion;
	string comentario;

public:
	Valoracion();
	Valoracion(float puntuacion, string comentario);

	void mostrar();
};

