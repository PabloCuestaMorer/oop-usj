#pragma once
#include "Profesor.h"
#include <string>
class PDI :
    public Profesor
{
private:
    string categoria;
public:
    PDI();
    PDI(string nombre, string departamento, string categoria);
    void mostrarHoras();
};

