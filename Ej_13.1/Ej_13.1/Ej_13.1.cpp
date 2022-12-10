// Ej_13.1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>

int main()
{
	int a = 0, b = 0, c = 0;
	double x1 = 0;
	double x2 = 0;

	// User in
	std::cout << "a: ";
	std::cin >> a;
	std::cout << "b: ";
	std::cin >> b;
	std::cout << "c: ";
	std::cin >> c;

	if (a != 0)
	{
		// ax2 + bx + c = 0 
		double root = sqrt(pow(b, 2) - (4 * a * c));
		if (root > 0)
		{
			x1 = (-b + root) / (2 * a);
			x2 = (-b - root) / (2 * a);
			if (x1 == x2)
			{
				std::cout << "The value of x is double x = " << x1;
			}
			else 
			{
				std::cout << "The values of x are x = " << x1 << " and x2 = " << x2;
			}

		}
		else
		{
			std::cout << "The equation has not result, because the root is < 0";
		}
	}
	else 
	{
		std::cout << "It is not a second degree equation because the coefficient of x^2 is a = 0";
	}
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
