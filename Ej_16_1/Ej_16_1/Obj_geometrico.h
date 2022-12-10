#pragma once
using namespace std;

class Obj_geometrico
{
protected:
	float xC;
	float yC;
public:
	Obj_geometrico (float x = 0, float y = 0);
	void imprimirCentro() const;

};

