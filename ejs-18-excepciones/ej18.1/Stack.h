#pragma once
#include "ExceptionOverflow.h"
#include "ExceptionUnderflow.h"

using namespace std;
class Stack
{
private:
	int* data;
	int size;
	int top;

	bool isEmpty() const;
	bool isFull() const;

public:
	Stack(int size);
	void push(int value);
	int pop();
	~Stack();
};

