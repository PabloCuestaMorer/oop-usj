#pragma once
#include <stdexcept>

using namespace std;

template <class T>
class Stack
{

public:
    // Constructor
    Stack(int size);

    // Constructor copia
    Stack(const Stack& other);

    // Destructor
    ~Stack();

    // Insertar elemento
    void push(const T& element);

    // Extraer elemento
    T pop();

    // Comprobar si está llena
    bool isFull() const;

    // Comprobar si está vacía
    bool isEmpty() const;

private:
	int size;
	int currentPosition;
	T* data;
};

template<class T>
inline Stack<T>::Stack(int size) : size(size)
{
    currentPosition = -1;
    data = new T[size];
}

template<class T>
inline Stack<T>::Stack(const Stack& origin)
{
    size = origin.size;
    currentPosition = origin.currentPosition;
    data = new T[size];
    for (int i = 0; i <= currentPosition; i++)
    {
        data[i] = origin.data[i];
    }
}

template<class T>
inline Stack<T>::~Stack()
{
    delete[] data;
}

template<class T>
inline void Stack<T>::push(const T& element)
{
    if (isFull())
    {
        throw out_of_range("The stack is full.");
    }
    currentPosition++;
    data[currentPosition] = element;
}

template<class T>
inline T Stack<T>::pop()
{
    if (isEmpty())
    {
        throw out_of_range("The stack is empty.");
    }
    T element = data[currentPosition];
    currentPosition--;
    return element;
}

template<class T>
inline bool Stack<T>::isFull() const
{
    return currentPosition == size - 1;
}

template<class T>
inline bool Stack<T>::isEmpty() const
{
    return currentPosition == -1;
}
