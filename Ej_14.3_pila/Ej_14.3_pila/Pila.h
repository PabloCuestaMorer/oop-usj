#pragma once
#define MAXPILA 5

class Pila {

private:
	int cima; // Marca la cima de la pila en cada momento.
	char* mat; // Lista de caracteres gestionada como pila.
public:
	Pila();

	void iniciarPila();
	void push(char);
	void pop();
	void mostrarPila() const;	//lo pongo como constantes porque estos metodos no cambian el valor de ningun atributo
	bool isEmpty()const;
	bool isFull()const;

	//	Pila vacía : cima = -1;
	// Pila llena : cima = MAXPILA - 1;
};

