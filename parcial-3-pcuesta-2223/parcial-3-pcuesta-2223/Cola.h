#pragma once
#include <ostream>

using namespace std;

template <class T, int capacity>
class Cola
{
private:
	T* data[capacity];
	int top;
public:

	/**
	 * Empty contructor.
	 */
	Cola()
	{
		top = -1;
	}

	/**
	 * Copy constructor.
	 *
	 * \param other
	 */
	Cola(const Cola& other)
	{
		top = other.top;
		for (int i = 0; i <= top; i++)
		{
			data[i] = new T(*other.data[i]);
		}
	}

	/**
	 * Destructor.
	 */
	~Cola()
	{
		for (int i = 0; i <= top; i++)
		{
			delete data[i];
		}
	}

	/**
	 * Overload operator=.
	 *
	 * \param other
	 * \return
	 */
	Cola& operator=(const Cola& other)
	{
		if (this != &other)
		{
			for (int i = 0; i <= top; i++)
			{
				delete data[i];
			}
			top = other.top;
			for (int i = 0; i <= top; i++)
			{
				data[i] = new T(*other.data[i]);
			}
		}
		return *this;
	}

	/**
	 * Check if the stack is empty.
	 *
	 * \return
	 */
	bool isEmpty()
	{
		return top == -1;
	}

	/**
	 * Chack if the stack is full.
	 *
	 * \return bool
	 */
	bool isFull()
	{
		return top == capacity - 1;
	}
	/**
	 * Get the current size of the stack.
	 *
	 * \return
	 */
	int size() const
	{
		return top + 1;
	}

	/**
	 * Clear all the elements of the stack.
	 *
	 */
	void clear()
	{
		for (int i = 0; i <= top; i++)
		{
			delete data[i];
		}
		top = -1;
	}

	/**
	 * Push an element at the end of the stack.
	 *
	 * \param item
	 */
	void addElement(T* item)
	{
		if (isFull())
		{
			throw overflow_error("Stack overflow");
		}
		data[++top] = item;
	}

	/**
	 * Pop and return the last element of the stack.
	 *
	 * \return
	 */
	T* pop()
	{
		if (isEmpty())
		{
			throw underflow_error("Stack underflow");
		}
		return data[top--];
	}

	/**
	 * Pop and return the first element of the stack.
	 *
	 * \return
	 */
	T* extractElement()
	{
		if (isEmpty())
		{
			throw underflow_error("Queue is empty");
		}
		T* item = data[0];
		top--;
		return item;
	}

	/**
	 * Pop and return the first element of the stack updating the index.
	 *
	 * \return
	 */
	T* extractElementBetter()
	{
		if (isEmpty())
		{
			throw underflow_error("Queue is empty");
		}
		T* item = data[0];
		for (int i = 1; i <= top; i++)
		{
			data[i - 1] = data[i];
		}
		top--;
		return item;
	}

	/**
	 * To view the top element of the stack.
	 *
	 * \return
	 */
	T* peek()
	{
		if (isEmpty())
		{
			throw underflow_error("Stack is empty");
		}
		return data[top];
	}

	/**
	 * Overload operator[]. Access/Modify element.
	 *
	 * \param index
	 * \return
	 */
	T* operator[](int index)
	{
		if (index < 0 || index > top)
		{
			throw out_of_range("Index out of range");
		}
		return data[index];
	}

	/**
	 * Overload operator>>.
	 *
	 * \param is
	 * \param cola
	 * \return
	 */
	friend istream& operator>> (istream& in, Cola<T, capacity>& cola)
	{
		T* item = new T;
		in >> *item;
		cola.addElement(item);
		return in;
	}
	// TEST OTHER WAY >>
	//friend istream& operator>> (istream& in, Cola<T, capacity>& cola)
	//{
	//	T item;
	//	while (in >> item)
	//	{
	//		cola.addElement(new T(item));
	//	}
	//	return in;
	//}

	/**
	 * Overload operator<<.
	 * Display the elements of the stack.
	 *
	 * \param os
	 * \param cola
	 * \return
	 */
	friend ostream& operator<<(ostream& os, const Cola<T, capacity>& cola)
	{
		os << "[";
		for (int i = 0; i <= cola.top; i++)
		{
			os << *cola.data[i];
			if (i != cola.top)
			{
				os << ", ";
			}
		}
		os << "]";
		return os;
	}
};

