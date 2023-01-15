#pragma once

#include "Player.h"

class Game
{
public:
	Game();
	Game(const Player& p1, const Player& p2, Player* current, bool isFinished);
	//void Play();
	//void SaveGame(const std::string& filename) const;
	//void LoadGame(const std::string& filename);

	// Setters
	void setPlayer1(const Player& p1);
	void setPlayer2(const Player& p2);
	void setCurrentPlayer(Player* current);
	void setFinished(bool isFinished);

	// Getters
	Player getPlayer1() const;
	Player getPlayer2() const;
	Player* getCurrentPlayer() const;
	bool isFinished() const;

private:
	Player player1;
	Player player2;
	Player* currentPlayer;
	bool finished;
};

