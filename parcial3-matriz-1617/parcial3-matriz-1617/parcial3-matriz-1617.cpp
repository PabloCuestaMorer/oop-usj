// parcial3-matriz-1617.cpp



#include <iostream>
#include <exception>


#include "Matrix.h"
#include "MatrixOutOfRangeException.h"

using namespace std;
int main()
{
	Matrix<int> matrix(3, 4);

	// Test my exception
	try
	{
		matrix(5, 5) = 10; // this will throw a MatrixOutOfRangeException
	} catch (MatrixOutOfRangeException& ex)
	{
		cout << ex.what() << endl; // Output: Error: trying to access element at (5, 5) in matrix of size 3x4
	} catch (out_of_range& ex)
	{
		cout << ex.what() << endl;
	} catch (exception& ex)
	{
		cout << ex.what() << endl;
	} catch (...)
	{
		cout << "An unknown exception occurred" << endl;
	}

	// Test out_of_range
	try
	{
		matrix(2, 3) = 10;
		int a = matrix(2, 3);
		cout << a << endl;
	} catch (out_of_range& ex)
	{
		cout << ex.what() << endl;
	} catch (...)
	{
		cout << "An unknown exception occurred" << endl;
	}


	cout << "Number of rows: " << matrix.getRows() << endl; // Output: Number of rows: 3
	cout << "Number of cols: " << matrix.getCols() << endl; // Output: Number of cols: 4
	cout << "Matrix capacity: " << matrix.getCapacity() << endl; // Output: Matrix capacity: 12
    // print the matrix
	matrix.printMatrix();

	matrix.resize(4, 5);
	cout << "Number of rows after resize: " << matrix.getRows() << endl; // Output: Number of rows after resize: 4
	cout << "Number of cols after resize: " << matrix.getCols() << endl; // Output: Number of cols after resize: 5
	cout << "Matrix capacity after resize: " << matrix.getCapacity() << endl;
	// print the matrix (with the overload)
	// count << matrix;
	matrix.printMatrix();
	return 0;
}

