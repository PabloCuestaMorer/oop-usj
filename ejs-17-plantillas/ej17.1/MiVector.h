#ifndef MIVECTOR_H
#define MIVECTOR_H

template <class T> class MiVector
{
public:
    // Constructor
    MiVector(int tam_max);

    // Constructor copia
    MiVector(const MiVector& miVector);

    // Indicar tamaño del vector
    int size() const;

    // Debe permitir la asignación de dos vectores
    MiVector& operator=(const MiVector& miVector);

    // Debe permitir la comparación de dos vectores
    bool operator==(const MiVector& miVector) const;

    // Debe permitir el acceso a un elemento del vector por su posición
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
