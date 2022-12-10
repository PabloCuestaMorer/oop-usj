#include "Serie.h"

Serie::Serie()
{
}

Serie::Serie(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, int num_temporadas) : ProductoMultimedia(id, titulo, anio_estreno, genero, sinopsis)
{
	this->num_temporadas = num_temporadas;
}

void Serie::mostrarProducto()
{
}
