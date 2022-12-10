#include "Pelicula.h"

Pelicula::Pelicula()
{
}

Pelicula::Pelicula(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, float min_duracion) : ProductoMultimedia(id, titulo, anio_estreno, genero, sinopsis)
{
	this->min_duracion = min_duracion;

}

void Pelicula::mostrarProducto()
{
}
