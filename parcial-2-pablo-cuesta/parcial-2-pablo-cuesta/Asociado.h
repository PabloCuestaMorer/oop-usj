#pragma once
#include "Profesor.h"

class Asociado :
    public Profesor
{
private:
    float porcentaje_jornada;
public:
    Asociado();
    Asociado(string nombre, string departamento,float porcentaje_jornada);
    void mostrarHoras() const;
};

