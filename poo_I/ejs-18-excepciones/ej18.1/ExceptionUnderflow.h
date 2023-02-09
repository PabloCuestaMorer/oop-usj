#pragma once
#include <exception>
#include <sstream>
using namespace std;
class ExceptionUnderflow : public exception
{
public:
	const char* what() const throw()
	{
		return "Exception: stack is underflow/empty";
	}

private:
	string generateErrorMessage(int i, int j, int r, int c)
	{
		ostringstream message;
		message << "Error: trying to access element at (" << i << ", " << j << ") in matrix of size " << r << "x" << c;
		return message.str();
	}
};

