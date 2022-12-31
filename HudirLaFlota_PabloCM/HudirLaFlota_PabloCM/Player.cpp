#include "Player.h"
#include <fstream>
#include "AircraftCarrier.h"

Player::Player() : gameBoard{}, shotHistory{}, name(name), ships{}, lost(false)
{

	// Ini gameBoard_
	for (int i = 0; i < BOARD_SIZE; i++)
	{
		for (int j = 0; j < BOARD_SIZE; j++)
		{
			gameBoard[i][j] = SquareState::WATER;
		}
	}
	// Ini shotHistory_
	for (int i = 0; i < BOARD_SIZE; i++)
	{
		for (int j = 0; j < BOARD_SIZE; j++)
		{
			shotHistory[i][j] = SquareState::WATER;
		}
	}

	// Fill the ships array with Ship objects
	ships[0] = AircraftCarrier("Aircraft Carrier", 5);
	ships[1] = Ship("Battleship", 4);
	ships[2] = Ship("Submarine", 3);
	ships[3] = Ship("Cruiser", 3);
	ships[4] = Ship("Patrol Boat", 2);
}

bool Player::placeShip(const Ship& ship, int row, int col, bool is_horizontal)
{
	// First, check if the ship can fit on the board at the given position
	if (is_horizontal)
	{
		if (col + ship.getSize() > BOARD_SIZE)
		{
			return false;
		}
	} else
	{
		if (row + ship.getSize() > BOARD_SIZE)
		{
			return false;
		}
	}

	// Check if there are any other ships occupying the same position
	for (int i = 0; i < ship.getSize(); i++)
	{
		if (is_horizontal)
		{
			if (gameBoard[row][col + i] != SquareState::WATER)
			{
				return false;
			}
		} else
		{
			if (gameBoard[row + i][col] != SquareState::WATER)
			{
				return false;
			}
		}
	}

	// If all checks pass, place the ship on the board
	for (int i = 0; i < ship.getSize(); i++)
	{
		if (is_horizontal)
		{
			gameBoard[row][col + i] = SquareState::SHIP;
		} else
		{
			gameBoard[row + i][col] = SquareState::SHIP;
		}
	}

	return true;
}

bool Player::hasLost() const
{
	return lost;
}

bool Player::shoot(int row, int col)
{
	// Comprobar si la casilla ya ha sido disparada.

	// Si no ha sido disparada, actualizar el estado de la casilla y devolver true.

	// Buscar el barco que ha sido tocado.

	// Comprobar si al hundirse el barco se ha perdido la partida.
	return true;
}

void Player::printBoard() const
{
	cout << "  0 1 2 3 4 5 6 7 8 9" << endl;
	for (int row = 0; row < BOARD_SIZE; row++)
	{
		char rowLabel = 'A' + row;
		cout << rowLabel << " ";
		for (int col = 0; col < BOARD_SIZE; col++)
		{
			char symbol{};
			switch (gameBoard[row][col])
			{
				case SquareState::WATER:
					symbol = '~';
					break;
				case SquareState::SHIP:
					symbol = '#';
					break;
				case SquareState::HIT:
					symbol = 'X';
					break;
				case SquareState::SUNK:
					symbol = 'O';
					break;
			}
			cout << symbol << " ";
		}
		cout << endl;
	}
}

// Getters and setters

void Player::setName(const string& newName)
{
	name = newName;
}

string Player::getName() const
{
	return name;
}