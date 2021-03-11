/*
문제:프로그래머스 > 코딩테스트연습 > 해시 > 전화번호목록
출처:https://programmers.co.kr/learn/courses/30/lessons/42577
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(), phone_book.end());

    for (int i = 0; i < phone_book.size() - 1; i++) {
        if (phone_book[i + 1].find(phone_book[i]) == 0) {
            return false;
        }
    }
    return answer;
}

int main() {
    vector<string> phone_book = { "119","97674223","1195524421" };
    cout << boolalpha << solution(phone_book);
}