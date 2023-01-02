#pragma once
#include <exception>

using namespace std;
class ExceptionUnderflow : public exception
{
public:
    const char* what() const throw()
    {
        return "Exception: stack is underflow/empty";
    }
};

