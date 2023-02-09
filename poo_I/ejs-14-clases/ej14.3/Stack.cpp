#include "Stack.h"

Stack::Stack()
{
	peek = -1;
	stack = new char[MAXSIZE];
}

bool Stack::isFull()
{
	return peek == MAXSIZE - 1;
}

bool Stack::isEmpty()
{
	return peek == -1;
}

void Stack::iniStack()
{
	Stack();
}

void Stack::push(char a)
{
	if (!isFull())
	{
		peek++;
		stack[peek] = a;
	} else
	{
		cout << "The stack is full.";
	}
}

void Stack::pop()
{
	if (!isEmpty())
	{
		peek--;
	} else
	{
		cout << "The stack is empty.";
	}
}

void Stack::printStack()
{
	if (!isEmpty())
	{
		int i = peek;
		while (i >= 0)
		{
			cout << "[ " << i << " ] " << stack[i] << endl;
			i--;
		}
		cout << "\n" << endl;
	} else
	{
		cout << "The stack is empty.";
	}

}
