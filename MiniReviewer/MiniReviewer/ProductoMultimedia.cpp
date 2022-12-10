#include "ProductoMultimedia.h"

ProductoMultimedia::ProductoMultimedia() 
{
	
}

ProductoMultimedia::ProductoMultimedia(int id, string titulo, int anio_estreno, Genero genero, string sinopsis, int max_num_valoraciones, int num_valoraciones)
{
	this->id = id;
	this->titulo = titulo;
	this->anio_estreno = anio_estreno;
	this->genero = genero;
	this->sinopsis = sinopsis;
}

ProductoMultimedia::ProductoMultimedia(int id, string titulo, int anio_estreno, Genero genero, string sinopsis)
{
}

ProductoMultimedia::ProductoMultimedia(const ProductoMultimedia& puntero)
{
}

void ProductoMultimedia::addValoracion(Valoracion valoracion)
{
}

void ProductoMultimedia::verValoraciones()
{
}

void ProductoMultimedia::devuelveGenero() const
{

}


