#pragma once
#include <algorithm>

#include "MatrixOutOfRangeException.h"

using namespace std;
template <class T> class Matrix
{
private:
	T* data; // pointer to store the matrix --> copy constructor + destructor + overload operator=
	int rows, cols; // number of rows and columns

public:
	/**
	 * Empty constructor.
	 */
	Matrix() : rows(0), cols(0)
	{
		data = NULL;
	}

	/**
	 * Constructor to create a matrix with given number of rows and columns.
	 *
	 * \param r rows of the matrix
	 * \param c colums of the matrix
	 * \return the matrix
	 */
	Matrix(int r, int c) : rows(r), cols(c)
	{
		data = new T[r * c];
	}


	/**
	 * Destructor to release memory.
	 */
	~Matrix()
	{
		delete[] data;
	}

	// Overload operator=
	Matrix<T>& operator=(const Matrix<T>& other)
	{
		if (this != &other)
		{
			delete[] data;
			rows = other.rows;
			cols = other.cols;
			data = new T[rows * cols];
			for (int i = 0; i < rows * cols; i++)
			{
				data[i] = other.data[i];
			}
		}
		return *this;
	}

	//overload operator()
	T& operator()(int i, int j)
	{
		if (i < 0 || i >= rows || j < 0 || j >= cols)
		{
			throw MatrixOutOfRangeException(i, j, rows, cols);
		}
		return data[i * cols + j];
	}

	//overload operator<<
	friend ostream& operator<<(ostream& os, const Matrix<T>& matrix)
	{
		for (int i = 0; i < matrix.rows; i++)
		{
			for (int j = 0; j < matrix.cols; j++)
			{
				os << matrix.data[i * matrix.cols + j] << " ";
			}
			os << endl;
		}
		return os;
	}

	/**
	 * Method to print the matrix..
	 */
	void printMatrix()
	{
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				cout << data[i * cols + j] << " ";
			}
			cout << endl;
		}
	}

	/**
	 * Method to resize the matrix.
	 *
	 * \param r new num of rows
	 * \param c new num of columns
	 */
	void resize(int r, int c)
	{
		T* newData = new T[r * c];
		// Check if the new data is smaller than the old one and 
		// determine the number of elements that should be copied from the old matrix
		// the min() function, which is a built-in function in C++ that returns the smaller of two values.
		int minRows = min(r, rows);
		int minCols = min(c, cols);
		// copy elements from the old matrix to the new matrix
		for (int i = 0; i < minRows; i++)
		{
			for (int j = 0; j < minCols; j++)
			{
				newData[i * c + j] = data[i * cols + j];
			}
		}
		// release the memory used by the old matrix
		delete[] data;
		// assign the pointer data to the newData
		data = newData;
		// update the number of rows and columns
		rows = r;
		cols = c;
	}


	/**
	 * Method to obtain the capacity of the matrix.
	 */
	int getCapacity()
	{
		return rows * cols;
	}

	/**
	 * Method to get the number of rows.
	 */
	int getRows()
	{
		return rows;
	}

	/**
	 * Method to get the number of columns.
	 *
	 * \return
	 */
	int getCols()
	{
		return cols;
	}



};

