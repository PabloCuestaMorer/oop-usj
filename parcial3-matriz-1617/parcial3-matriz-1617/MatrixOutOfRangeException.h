#pragma once
#include <exception>
#include <sstream>
using namespace std;
class MatrixOutOfRangeException : public out_of_range
{
public:
	MatrixOutOfRangeException(int i, int j, int r, int c) :
		out_of_range(generateErrorMessage(i, j, r, c))
		// if I want just a simple msj 
		// out_of_range("msj")
	{
	}
private:
	string generateErrorMessage(int i, int j, int r, int c)
	{
		ostringstream message;
		message << "Error: trying to access element at (" << i << ", " << j << ") in matrix of size " << r << "x" << c;
		return message.str();
	}


};

