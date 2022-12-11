// EjemploHerencia.cpp : Este archivo contiene la función "main". La ejecución del programa comienza y termina ahí.
//

#include <iostream>
#include "Vehiculo.h"
#include "Camion.h"
#include "Autobus.h"

int main()
{
    Vehiculo v(100,"Opel");
    v.mostrar();

    Camion c;
    c.mostrar();

    Camion c1(2000, 150, "Mercedes");
    c1.mostrar();

    Autobus a;
    a.mostrar();

    Vehiculo* punteroV = new Camion(1200, 200, "Skoda");
    punteroV->mostrar();
    cout << "PESO CAMION: " << static_cast <Camion*> (punteroV)->getPeso() << endl;
    
    Vehiculo* garaje[5];
    for (int i = 0; i < 5; i++) {
        int random = rand() % 2;
        if (random == 0) {
            garaje[i] = new Camion();
        }
        else {
            garaje[i] = new Autobus();
        }
    }

    for (int i = 0; i < 5; i++) {
        garaje[i]->mostrar();
        if (dynamic_cast <Camion*> (garaje[i]) != nullptr) {
            cout << "PESO: " << dynamic_cast <Camion*> (garaje[i])->getPeso() << endl;
        }
    }
}

// Ejecutar programa: Ctrl + F5 o menú Depurar > Iniciar sin depurar
// Depurar programa: F5 o menú Depurar > Iniciar depuración

// Sugerencias para primeros pasos: 1. Use la ventana del Explorador de soluciones para agregar y administrar archivos
//   2. Use la ventana de Team Explorer para conectar con el control de código fuente
//   3. Use la ventana de salida para ver la salida de compilación y otros mensajes
//   4. Use la ventana Lista de errores para ver los errores
//   5. Vaya a Proyecto > Agregar nuevo elemento para crear nuevos archivos de código, o a Proyecto > Agregar elemento existente para agregar archivos de código existentes al proyecto
//   6. En el futuro, para volver a abrir este proyecto, vaya a Archivo > Abrir > Proyecto y seleccione el archivo .sln
