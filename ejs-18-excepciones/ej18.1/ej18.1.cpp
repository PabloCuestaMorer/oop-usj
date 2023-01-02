// ej18.1.cpp

#include <iostream>
#include "Stack.h"

using namespace std;
int main()
{
	const int STACK_SIZE = 5;
	Stack stack(STACK_SIZE);

	// Test overflow
	try
	{
		for (int i = 0; i < STACK_SIZE + 1; i++)
		{
			stack.push(i);
			cout << "Pushed value: " << i << endl;
		}
	} catch (const ExceptionOverflow& e)
	{
		cerr << e.what() << endl;
	}

	// Test underflow/empty
	try
	{
		for (int i = 0; i < STACK_SIZE + 1; i++)
		{
			int value = stack.pop();
			cout << "Popped value: " << value << endl;
		}
	} catch (const ExceptionUnderflow& e)
	{
		cerr << e.what() << endl;
	}

	return 0;
}

