#pragma once
#include <iostream>

using namespace std;
#define MAXSIZE 5
class Stack
{
private:
	int peek;
	char* stack;
	bool isFull();
	bool isEmpty();
public:
	Stack();
	void iniStack();
	void push(char a);
	void pop();
	void printStack();
};

