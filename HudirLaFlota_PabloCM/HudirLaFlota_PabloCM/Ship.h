#pragma once

#include <string>

using namespace std;

class Ship
{
public:
	Ship();
	Ship(const string& name, int size);
	string getName() const;
	int getSize() const;
	int getHits() const;
	bool isSunk() const;
	void hit();

private:
	string name;
	int size;
	int hits;
};

