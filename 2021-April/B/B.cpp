#include <bits/stdc++.h>
#include <cstddef>
#include <iterator>

using namespace std;

struct drone {
  long x;
  long vel;
  size_t index;
  bool crashed = false;
};

bool willCrash(drone curr, drone other) {
  return curr.vel > other.vel;
}

bool RunSim(vector<drone>& drones) {
  int initialSize = drones.size();
  // handle first drone
  // if (drones[0].vel > drones[1].vel) {
  //   cout << drones[0].index << " and " << drones[1].index << "Crashed\n";
  //   drones[0].crashed = true;
  //   drones[1].crashed = true;
  // }

  for (size_t i = 1; i < drones.size() - 1; i++) {
    if (drones[i].crashed) {
      continue;
    }
    if (drones[i - 1].crashed && drones[i].vel < 0 && drones[i].vel * ((drones[i-1].x - drones[i-2].x)/(drones[i-1].vel - drones[i - 2].vel)) == (drones[i].x - drones[i-2].x)) {
      drones[i].crashed = true;
    } else if(drones[i].vel > drones[i + 1].vel || drones[i - 1].vel > drones[i].vel) {
      drones[i].crashed = true;
      // handle the case of 3 ways
      if (drones[i].vel > drones[i + 1].vel && drones[i - 1].vel > drones[i].vel) {
        long vCurrentNext = abs(drones[i].vel - drones[i + 1].vel);
        long vCurrentPrev = abs(drones[i].vel - drones[i - 1].vel);
        if (vCurrentNext < vCurrentPrev) {
          drones[i - 1].crashed = true;
        } else if (vCurrentNext > vCurrentPrev) {
          drones[i + 1].crashed = true;
        } else {
          // Both crash if its equal
          drones[i + 1].crashed = true;
          drones[i - 1].crashed = true;
        }
      } else {
        if (willCrash(drones[i], drones[i + 1])) {
        drones[i + 1].crashed = true;
        } else {
          drones[i - 1].crashed = true;
        }
      }
    }
  }

  for (int i = 0; i < drones.size(); i++) {
    if (drones[i].crashed) {
      drones.erase(drones.begin() + i);
    }
  }
  return initialSize == drones.size() || drones.size() == 0;
}

int main() {
  size_t numInputs;
  long tempX, tempVel;
  cin >> numInputs;
  vector<drone> drones;

   for (size_t i = 0; i < numInputs; i++) {
     cin >> tempX >> tempVel;
     drone tempDrone{tempX, tempVel, i};
      drones.push_back(tempDrone);
   }

  while (!RunSim(drones)){}
  cout << drones.size() << "\n";
  for (size_t i = 0; i < drones.size(); i++) {
    cout << drones[i].index + 1 << " ";
  }
  cout << "\n";
}

