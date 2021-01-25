#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;

    int len = s.length();
    if (len == 4 || len == 6) {
        for (int i = 0; i < len; i++) {
            char a = s.at(i);
            if (!((int)a >= 48 && (int)a <= 57)) {
                answer = false;
                break;
            }
        }
    }
    else
        answer = false;

    return answer;
}