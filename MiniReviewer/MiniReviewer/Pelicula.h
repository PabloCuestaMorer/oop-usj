#pragma once
#include "ProductoMultimedia.h"

class Pelicula :
	public ProductoMultimedia
{
private:
	float min_duracion;
public:
	Pelicula();
	Pelicula(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, float min_duracion);
	void mostrarProducto();
	void calcularMedia();
	friend istream& operator>>(istream& input, Pelicula& pelicula);
};

