// ej17.1.cpp

#include <iostream>
#include "Vector.h"

using namespace std;
int main()
{
    // Crea un vector de enteros de tamaño 3
    Vector<int> v1(3);

    // Asigna valores a los elementos del vector
    v1[0] = 1;
    v1[1] = 2;
    v1[2] = 3;

    // Imprime el vector
    for (int i = 0; i < v1.getSize(); i++)
    {
        cout << v1[i] << " ";
    }
    cout << endl;

    // Crea una copia del vector v1
    Vector<int> v2(v1);

    // Compara v1 y v2
    if (v1 == v2)
    {
        cout << "v1 and v2 are equals" << endl;
    } else
    {
        cout << "v1 and v2 are different" << endl;
    }

    // Modifica un elemento de v2
    v2[1] = 0;

    // Compara v1 y v2 de nuevo
    if (v1 == v2)
    {
        cout << "v1 and v2 are equals" << endl;
    } else
    {
        cout << "v1 and v2 are different" << endl;
    }

    return 0;

}

