// parcial-3-pcuesta-2223.cpp : This file contains the 'main' function. Program execution begins and ends there.

#include <iostream>
#include <stdexcept>
#include "Cola.h"

using namespace std;
int main()
{

    Cola<int, 5> myStack;

    // push elements to the stack
    //for (int i = 0; i < 10; i++)
    //{
    //    myStack.addElement(new int(i));
    //}
    cout << "Test operator>>:" << endl;
    cout << "Enter 5 elements to add to the queue:" << endl;
    for (int i = 0; i < 5; i++)
    {
        cout << "myStack[" << i << "]=";
        cin >> myStack;
    }
    cout << endl;
    cout << "Elements in the queue: " << myStack << endl;

    // print the stack
    cout << "Stack: " << myStack << endl;
    cout << endl;

    // test stack overflows
    cout << "Test overflow trying to add one more element:" << endl;
    try
    {
        myStack.addElement(new int(10));
    } catch (const overflow_error& e)
    {
        cerr << "Error: " << e.what() << endl;
    }
    cout << endl;

    //cout << "Test .extractElement():" << endl;
    //myStack.extractElement();

    //// print the stack
    //cout << "Stack after .extractElement(): " << myStack << endl;
    //cout << endl;

    cout << "Test .extractElementBetter():" << endl;
    myStack.extractElementBetter();

    // print the stack
    cout << "Stack after .extractElementBetter(): " << myStack << endl;
    cout << endl;

    // test index out of range
    cout << "Test operator[3]:" << endl;
    try
    {
        cout << "myStack[3]: " << *myStack[3] << endl;
        cout << endl;
        cout << "Test operator[-1]:" << endl;
        cout << "myStack[-1]: " << *myStack[-1] << endl;
    } catch (const out_of_range& e)
    {
        cerr << "Error: " << e.what() << endl;
    }
    cout << endl;

    // test stack underflow
    cout << "Test underflow removing all element and one more:" << endl;
    try
    {
        while (!myStack.isEmpty())
        {
            cerr << "Popped: " << *myStack.extractElementBetter() << endl;
        }
        myStack.extractElement();
    } catch (const underflow_error& e)
    {
        cerr << "Error: " << e.what() << endl;
    }
    cout << endl;


    // add elements to the stack
    for (int i = 0; i < 5; i++)
    {
        myStack.addElement(new int(i));
    }
    cout << endl;
    cout << "Elements in stack: " << myStack << endl;


    // Test operator=
    Cola<int, 5> myStack2;
    myStack2 = myStack;
    cout << "Test operator= ( myStack2 = myStack) elements in the stack2= " << myStack << endl;
    cout << endl;

    // clear the stack
    cout << "Test .clear():" << endl;
    myStack.clear();
    cout << "stack after clearing: " << myStack << endl;
    cout << endl;

    return 0;
}
