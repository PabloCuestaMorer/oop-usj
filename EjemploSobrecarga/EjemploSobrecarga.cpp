// EjemploSobrecarga.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include "Punto2D.h"

int main()
{
    std::cout << "Hello World!\n";
    Punto2D p(1.2,3.4);
    cout << p;

    Punto2D p2(7, 9);
    Punto2D res;
    res = p + p2; //p.operator+(p2);
    cout << res;

    res = res - p2; //operator-(res,p2);
    cout << res;

    Punto2D p3(5.6);
    cout << p3;

    float coordenadaXcomoFloat = p2;
    cout << coordenadaXcomoFloat << endl;

    cout << "coordenada X: " << p2[0] << " coordenada Y: " << p2[1] << endl;
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
