#pragma once
template <class T> class Matriz
{
private:
	T* matriz; //punteros --> constructor copia,destructor y sobrecarga del =
	int filas;
	int columnas;
public:
	/**
	 * Constructor vacio.
	 */
	Matriz()
	{
		filas = 0;
		columnas = 0;
		matriz = NULL;
	}


	/**
	 * Destructor.
	 */
	~Matriz() 
	{
		if (matriz != NULL) delete matriz;
		matriz = NULL;
	}
};

