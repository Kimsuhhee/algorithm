#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int num) {
    int answer = 0;
    long long N = num;
    while (1) {
        if (N == 1)break;

        if (N % 2 == 0) {
            N = N / 2;
            answer++;
        }
        else {
            N = N * 3 + 1;
            answer++;
        }
    }
    if (answer >= 500) answer = -1;
    return answer;
}
int main() {
    int num = 626331;
    cout << solution(num) << endl;
}