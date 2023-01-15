// game.cpp
#include "Game.h"
#include <iostream>

Game::Game() : player1(), player2(), currentPlayer(&player1), finished(false) {}

Game::Game(const Player& p1, const Player& p2, Player* current, bool isFinished)
	: player1(p1), player2(p2), currentPlayer(current), finished(isFinished) {}

// Setters
void Game::setPlayer1(const Player& p1) { player1 = p1; }
void Game::setPlayer2(const Player& p2) { player2 = p2; }
void Game::setCurrentPlayer(Player* current) { currentPlayer = current; }
void Game::setFinished(bool isFinished) { finished = isFinished; }

// Getters
Player Game::getPlayer1() const { return player1; }
Player Game::getPlayer2() const { return player2; }
Player* Game::getCurrentPlayer() const { return currentPlayer; }
bool Game::isFinished() const { return finished; }


