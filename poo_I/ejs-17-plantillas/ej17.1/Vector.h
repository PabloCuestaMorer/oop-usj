#pragma once

using namespace std;

template <class T>
class Vector
{
private:
	int size;
	T* data;

public:
	// Constructor
	Vector(int size);

	// Copy constructor
	Vector(const Vector& origin);

	// Get the size of the vector
	int getSize() const;

	// Assignment operator
	Vector& operator=(const Vector& opDcha);

	// Comparison operator (equals)
	bool operator==(const Vector& opDcha) const;

	// Modify element by position
	T& operator[](int i);
	// Access element by position
	const T& operator[](int i) const;

	// Destructor
	~Vector();

};

template <class T>
inline Vector<T>::Vector(int size) : size(size), data(new T[size]) {}

template <class T>
inline Vector<T>::Vector(const Vector& origin)
{
	size = origin.size;
	data = new T[origin.size];
	for (int i = 0; i < size; i++)
	{
		data[i] = origin.data[i];
	}
}

template <class T>
inline int Vector<T>::getSize() const
{
	return size;
}

template <class T>
inline Vector<T>& Vector<T>::operator=(const Vector& opDcha)
{
	if (this != &opDcha)
	{
		delete[] data;
		size = opDcha.size;
		data = new T[size];
		for (int i = 0; i < size; i++)
		{
			data[i] = opDcha.data[i];
		}
	}
	return *this;
}

template <class T>
inline bool Vector<T>::operator==(const Vector& opDcha) const
{
	if (size != opDcha.size) return false;
	for (int i = 0; i < size; i++)
	{
		if (data[i] != opDcha.data[i]) return false;
	}
	return true;
}

template <class T>
inline T& Vector<T>::operator[](int i)
{
	return data[i];
}

template <class T>
inline const T& Vector<T>::operator[](int i) const
{
	return data[i];
}

template <class T>
inline Vector<T>::~Vector()
{
	delete[] data;
}

