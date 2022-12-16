#pragma once
#include <iostream>
#include <string>
#include "Valoracion.h"
#include <list>
#define stringify( name ) #name
using namespace std;

enum Genero
{
	NO_GENERE, ACCION, AVENTURA, ANIMACION, COMEDIA, DOCUMENTAL,
	DRAMA, HORROR, MUSICAL, ROMANCE, CIENCIA_FICCION
};

class ProductoMultimedia
{
protected:
	int id;
	string titulo;
	int anio_estreno;
	Genero genero;
	string sinopsis;
	int max_num_valoraciones;
	int num_valoraciones;
	list<Valoracion> valoraciones;
	float puntuacion_media;

private:
	string devuelveGenero() const { return stringify(genero); } ;

public:
	ProductoMultimedia();
	ProductoMultimedia(
		int id,
		string titulo,
		int anio_estreno,
		Genero genero,
		string sinopsis,
		int max_num_valoraciones,
		int num_valoraciones
	);
	ProductoMultimedia(
		int id,
		string titulo,
		int anio_estreno,
		Genero genero,
		string sinopsis
	);
	ProductoMultimedia(const ProductoMultimedia& puntero);

	virtual void mostrarProducto() = 0;
	void addValoracion(Valoracion valoracion);
	void verValoraciones();
	virtual void calcularMedia() = 0;
};
