#include "Producto.h"

Producto::Producto()
{
	identificador = 0;
	precio = 0;
}

Producto::Producto(int ide, float pre = 0.0) {
	identificador = ide;
	precio = pre;
}

Producto::Producto(const Producto& original) {
	identificador = original.identificador;
	precio = original.precio;
}


void Producto::modificarPrecio(float nuevoPrecio) {
	if (nuevoPrecio > 0)
	{
		precio = nuevoPrecio;
	}
}

void Producto::mostrar() const
{
	cout << "Producto " << identificador << endl;
	cout << "Precio " << precio << endl;
}
