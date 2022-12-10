#pragma once
#include <string>
#include "Valoracion.h"
#include <list>

using namespace std;

enum Genero {
	NO_GENERE, ACCION, AVENTURA, ANIMACION, COMEDIA, DOCUMENTAL,
	DRAMA, HORROR, MUSICAL, ROMANCE, CIENCIA_FICCION
};

class ProductoMultimedia {
private:
	int id;
	string titulo;
	int anio_estreno;
	Genero genero;
	string sinopsis;
	int max_num_valoraciones;
	int num_valoraciones;
	list<Valoracion> valoraciones;

	void devuelveGenero() const;

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
};
