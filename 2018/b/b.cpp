#include <bits/stdc++.h>

using namespace std;

int calcCandles(int days) {
  return (days + 1) * (days) / 2 + days;
}

int main() {
  int numProblems, problemNum, days;
  ifstream input{"B.txt"};
  if (input.is_open()) {
    input >> numProblems;
    for (int i =1; i <= numProblems; i++) {
      input >>problemNum >> days;
      cout << problemNum << " " << calcCandles(days) << "\n";
    }
  }
}