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
		cerr << ex.what() << endl; // Output: Error: trying to access element at (5, 5) in matrix of size 3x4
	} catch (out_of_range& ex)
	{
		cerr << ex.what() << endl;
	} catch (exception& ex)
	{
		cerr << ex.what() << endl;
	} catch (...)
	{
		cerr << "An unknown exception occurred" << endl;
	}

	// Test out_of_range
	try
	{
		cout << "matrix(2,3) = ";
		matrix(2, 3) = 10;
		int a = matrix(2, 3);
		cerr << a << endl;
	} catch (out_of_range& ex)
	{
		cout << ex.what() << endl;
	} catch (...)
	{
		cerr << "An unknown exception occurred" << endl;
	}

	cout << "Test .gets:" << endl;
	cout << "Number of rows: " << matrix.getRows() << endl; // Output: Number of rows: 3
	cout << "Number of cols: " << matrix.getCols() << endl; // Output: Number of cols: 4
	cout << "Matrix capacity: " << matrix.getCapacity() << endl; // Output: Matrix capacity: 12
	// print the matrix
	matrix.printMatrix();

	cout << "Test .resize() :" << endl;
	matrix.resize(4, 5);
	cout << "Number of rows after resize: " << matrix.getRows() << endl; // Output: Number of rows after resize: 4
	cout << "Number of cols after resize: " << matrix.getCols() << endl; // Output: Number of cols after resize: 5
	cout << "Matrix capacity after resize: " << matrix.getCapacity() << endl;
	cout << "matrix(4,5):" << endl;
	// print the matrix (with the overload)
	cout << matrix << endl;

	cout << "Test .operator= matrix(4,5)=matrix2(5,5) :" << endl;
	Matrix<int> matrix2(5, 5);
	matrix2(4, 4) = 2;
	matrix = matrix2;
	cout << "new matrix(5,5):" << endl;
	cout << matrix << endl;


	return 0;
}

