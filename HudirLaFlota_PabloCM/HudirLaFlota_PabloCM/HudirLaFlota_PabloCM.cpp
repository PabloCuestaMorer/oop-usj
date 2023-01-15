// HudirLaFlota_PabloCM.cpp

#include <iostream>
#include "Game.h"
using namespace std;

void displayMenu()
{
    cout << "Welcome to the game! Please select an option:" << endl;
    cout << "1. New game" << endl;
    cout << "2. Load game" << endl;
    cout << "3. Exit" << endl;
    cout << "Enter your selection: ";
}

void startNewGame()
{
    cout << "Starting a new game..." << endl;

    Game game;

    Player player1;
    Player player2;

    cout << "Enter the name of player 1: ";
    string name1;
    cin >> name1;
    player1.setName(name1);

    cout << "Enter the name of player 2: ";
    string name2;
    cin >> name2;
    player2.setName(name2);

    game.setPlayer1(player1);
    game.setPlayer2(player2);

    while (true)
    {
        cout << "In game menu:" << endl;
        cout << "1. Continue playing" << endl;
        cout << "2. Save and exit to main menu" << endl;
        cout << "Enter your selection: ";

        int selection;
        cin >> selection;

        switch (selection)
        {
            case 1:
                cout << "Continuing the game..." << endl;
                break;
            case 2:
                cout << "Saving and exiting to main menu..." << endl;
                return;
            default:
                cout << "Invalid selection. Please try again." << endl;
                break;
        }
    }
}

int main()
{
	
    while (true)
    {
        displayMenu();

        int selection;
        cin >> selection;

        switch (selection)
        {
            case 1:
                cout << "Starting a new game..." << endl;
                startNewGame();
                break;
            case 2:
                cout << "Loading a saved game..." << endl;
                break;
            case 3:
                cout << "Exiting the program..." << endl;
                return 0;
            default:
                cout << "Invalid selection. Please try again." << endl;
                break;
        }
    }

    return 0;
}

