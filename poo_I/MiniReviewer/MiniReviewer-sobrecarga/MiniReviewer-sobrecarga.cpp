#include <iostream>
#include "../MiniReviewer/ProductoMultimedia.h"
#include "../MiniReviewer/Pelicula.h"
#include "../MiniReviewer/Serie.h"

#define MAX_PRODUCTOS 10

using namespace std;

int main()
{
	int numProductos = 0;

	ProductoMultimedia* catalogo[MAX_PRODUCTOS];

	catalogo[0] = new Pelicula(1, "Cadena Perpetua", 1994, Genero::DRAMA,
		"El banquero Andy Dufresne es arrestado por matar a su esposa y amante. Tras una dura adaptacion, intenta mejorar las condiciones de la prision y dar esperanza a sus companeros.", 142);
	numProductos++;

	catalogo[0]->addValoracion(Valoracion(9, "Una pelicula popular que merece su popularidad"));
	catalogo[0]->addValoracion(Valoracion(10, "Encantadora, fantastica, intrigante, verdaderamente notable!"));
	catalogo[0]->addValoracion(Valoracion(6, "Una pelicula generica, pero satisfactoria ..."));

	catalogo[1] = new Serie(2, "Breaking Bad", 2008, Genero::DRAMA,
		"Un profesor de instituto diagnosticado con cancer de pulmon empieza a manufacturar y vender metamfetamina para asegurar el futuro de su familia.", 5);
	numProductos++;

	catalogo[1]->addValoracion(Valoracion(10, "Tan buena como has escuchado"));
	catalogo[1]->addValoracion(Valoracion(8, "Brillante y peculiar comedia negra con la actuacion experta de Bryan Cranston ..."));


	for (int i = 0; i < numProductos; i++)
	{
		catalogo[i]->mostrarProducto();
		catalogo[i]->calcularMedia();
		cout << endl;
	}

	return 0;
}
