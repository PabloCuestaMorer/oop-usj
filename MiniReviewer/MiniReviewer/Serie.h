#pragma once
#include "ProductoMultimedia.h"
class Serie :
	public ProductoMultimedia
{
private:
	int num_temporadas;
public:
	Serie();
	Serie(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, int num_temporadas);
	void mostrarProducto();
};

