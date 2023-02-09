// ej17.2.cpp

#include <iostream>
#include "Stack.h"

using namespace std;
int main()
{
	Stack<int> stack(3);

	stack.push(1);
	stack.push(2);
	stack.push(3);

	try
	{
		// Test is full
		// stack.push(4);

		// Test is empty
		while (true)
		{
			cout << stack.pop() << endl;
		}
	} catch (out_of_range& e)
	{
		cout << e.what() << endl;
	}
	return 0;
}

