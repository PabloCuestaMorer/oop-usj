#include "Pelicula.h"

Pelicula::Pelicula()
{
	min_duracion = 0;
}

Pelicula::Pelicula(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, float min_duracion)
	: ProductoMultimedia(id, titulo, anio_estreno, genero, sinopsis)
{
	this->min_duracion = min_duracion;
}

void Pelicula::mostrarProducto()
{
	cout << "Pelicula: { titulo: " << ProductoMultimedia::titulo << "; minutos furacion: " << min_duracion << "; }" << endl;
}

void Pelicula::calcularMedia()
{
	cout << "puntuacion media: " << round(puntuacion_media) << endl;
}

istream& operator>>(istream& input, Pelicula& pelicula)
{
	input >> pelicula.puntuacion_media;
	return input;
}
