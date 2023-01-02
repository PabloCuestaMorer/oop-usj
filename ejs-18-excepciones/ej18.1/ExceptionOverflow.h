#pragma once
#include <exception>

using namespace std;
class ExceptionOverflow : public exception
{
public:
    const char* what() const throw()
    {
        return "Exception: stack overflow";
    }
};

