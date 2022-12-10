#ifndef MIVECTOR_H
#define MIVECTOR_H

template <class T> class MiVector
{
public:
    // Constructor
    MiVector(int tam_max);

    // Constructor copia
    MiVector(const MiVector& miVector);

    // Indicar tama�o del vector
    int size() const;

    // Debe permitir la asignaci�n de dos vectores
    MiVector& operator=(const MiVector& miVector);

    // Debe permitir la comparaci�n de dos vectores
    bool operator==(const MiVector& miVector) const;

    // Debe permitir el acceso a un elemento del vector por su posici�n
    T& operator[](int index);

    const T& operator[](int index) const;

    // Destructor
    ~MiVector();

private:
    T* datos;
    int tam_max;
    int num_elem;
};

#endif
