#include "Punto2D.h"

Punto2D::Punto2D() {
	coor_x = 0.0;
	coor_y = 0.0;
}

Punto2D::Punto2D(float x, float y) {
	coor_x = x;
	coor_y = y;
}

ostream& operator<<(ostream& os, Punto2D& p) {
	os << "(" << p.coor_x << ", " << p.coor_y << ")" << endl;
	return os;
}

Punto2D Punto2D::operator+(Punto2D op_dcha) {
	Punto2D resultado;
	resultado.coor_x = coor_x + op_dcha.coor_x;
	resultado.coor_y = coor_y + op_dcha.coor_y;
	return resultado;
	//return Punto2D(coor_x + op_dcha.coor_x, coor_y + op_dcha.coor_y);
}

Punto2D operator-(Punto2D op_izda, Punto2D op_dcha) {
	Punto2D resultado;
	resultado.coor_x = op_izda.coor_x - op_dcha.coor_x;
	resultado.coor_y = op_izda.coor_y - op_dcha.coor_y;
	return resultado;
}

Punto2D& Punto2D::operator=(const Punto2D& op_dcha) {
	coor_x = op_dcha.coor_x;
	coor_y = op_dcha.coor_y;
	return *this;
}

Punto2D::operator float() {
	return coor_x;
}

float Punto2D::operator[](int index) {
	float aux = 0.0;
	if (index == 0) {
		aux = coor_x;
	} else if (index == 1) {
		aux = coor_y;
	}
	return aux;
}
