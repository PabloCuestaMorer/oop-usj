#include "Ship.h"

Ship::Ship() : name(), size(0), hits(0) {}

Ship::Ship(const std::string& name, int size) : name(name), size(size), hits(0) {}

std::string Ship::getName() const
{
	return name;
}

int Ship::getSize() const
{
	return size;
}

int Ship::getHits() const
{
	return hits;
}

bool Ship::isSunk() const
{
	return hits == size;
}

void Ship::hit()
{
	++hits;
}

