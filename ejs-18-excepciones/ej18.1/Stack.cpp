#include "Stack.h"

bool Stack::isEmpty() const
{
	return top == -1;
}

bool Stack::isFull() const
{
	return top == size - 1;
}

Stack::Stack(int size)
{
	this->size = size;
	data = new int[size];
	top = -1;
}

void Stack::push(int value)
{
	if (isFull())
	{
		throw ExceptionOverflow();
	}
	data[++top] = value;
}

int Stack::pop()
{
	if (isEmpty())
	{
		throw ExceptionUnderflow();
	}
	return data[top--];
}

Stack::~Stack()
{
	delete[] data;
}
