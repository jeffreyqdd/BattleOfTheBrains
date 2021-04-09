#include <iostream>
#include <fstream>
using namespace std;

typedef long long ll;

int main() {

    ifstream fin("a.txt");

    //input format
    // N text cases
    // test case #, A, B, k, x_k
    // find x0
    // When in doubt LONG LONG!

    int N; fin >> N;

    for (int i = 0; i < N; i++)
    {
        long long P, A, B, K, XK; fin >> P >> A >> B >> K >> XK;
        
        //so we need to find x0
        for(int j = K - 1; j >= 0; j--){
            //cout << XK << endl;
            XK = (XK - B) / A;
        }
        cout << P << " " << XK << endl;
        //cout << endl;
    }
    return 0; 
}