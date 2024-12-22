#include <iostream>
using namespace std;

char b[9] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'}, p = 'X';

void d() {
    for (int i = 0; i < 9; i++) {
        cout << " " << b[i] << ((i % 3 == 2) ? "\n" : " |");
        if (i % 3 == 2 && i < 6) cout << "---|---|---\n";
    }
}

bool w() {
    for (int i = 0; i < 3; i++) {
        if (b[i] == b[i + 3] && b[i] == b[i + 6]) return true;
        if (b[3 * i] == b[3 * i + 1] && b[3 * i] == b[3 * i + 2]) return true;
    }
    return (b[0] == b[4] && b[0] == b[8]) || (b[2] == b[4] && b[2] == b[6]);
}

bool dr() {
    for (char c : b) if (c != 'X' && c != 'O') return false;
    return true;
}

void g() {
    while (true) {
        d();
        int m;
        cout << "Player " << p << ", move (1-9): ";
        cin >> m;
        if (m < 1 || m > 9 || b[m - 1] == 'X' || b[m - 1] == 'O') {
            cout << "Invalid move. Try again.\n";
            continue;
        }
        b[m - 1] = p;
        if (w() || dr()) {
            d();
            cout << (w() ? "Player " + string(1, p) + " wins!\n" : "It's a draw!\n");
            break;
        }
        p = (p == 'X') ? 'O' : 'X';
    }
}

int main() {
    g();
    return 0;
}
