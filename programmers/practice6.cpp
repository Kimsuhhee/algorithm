#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool solution(int x) {
    bool answer = true;
    int sum = 0;
    int ori = x;
    while (x != 0) {
        sum += x % 10;
        x = x / 10;
    }
    if (ori % sum != 0)
        answer = false;

    return answer;
}

int main() {
    int x = 12;
    cout << boolalpha << solution(x) << endl;
}