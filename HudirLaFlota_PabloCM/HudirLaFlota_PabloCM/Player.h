#pragma once

#include <string>
#include <array>
#include "ship.h"
#include <iostream>
#include <vector>

using namespace std;

enum class SquareState
{
	WATER,
	SHIP,
	HIT,
	SUNK
};

const int BOARD_SIZE = 10;

class Player
{
public:
	Player();
	bool placeShip(const Ship& ship, int row, int col, bool isHorizontal);
	bool hasLost() const;
	bool shoot(int row, int col);
	void printBoard() const;

	// Getters and setters
	void setName(const string& newName);
	string getName() const;


private:
	string name;
	array<array<SquareState, BOARD_SIZE>, BOARD_SIZE> gameBoard;
	array<array<SquareState, BOARD_SIZE>, BOARD_SIZE> shotHistory;
	array<Ship, 5> ships;
	bool lost;
};
