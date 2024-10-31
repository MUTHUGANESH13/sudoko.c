#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int generateRandomNumber(int min, int max) { return min + rand() % (max - min + 1); }

void playRound(int &score) {
    int target = generateRandomNumber(1, 100), attempts = 0, guess;
    cout << "Guess the number (1 to 100): ";
    while (true) {
        cin >> guess;
        attempts++;
        if (guess == target) {
            cout << "Correct! Attempts: " << attempts << endl;
            score += max(10 - attempts, 1);
            break;
        } else if (guess < target) cout << "Higher! Try again: ";
        else cout << "Lower! Try again: ";
    }
}

int main() {
    srand(time(0));
    int rounds, score = 0;
    cout << "Enter number of rounds: ";
    cin >> rounds;
    for (int i = 1; i <= rounds; i++) {
        cout << "\nRound " << i << endl;
        playRound(score);
    }
    cout << "\nFinal Score: " << score << endl;
    return 0;
}
