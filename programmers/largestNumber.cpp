/*
문제:프로그래머스 > 코딩테스트연습 > 정렬 > 가장큰수
출처:https://programmers.co.kr/learn/courses/30/lessons/42746
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
//vector<int> numbers = { 6,10,2 };
vector<int> numbers = { 3,30,34,5,9 };

bool compare(int a, int b) {
    string s1 = to_string(a) + to_string(b);
    string s2 = to_string(b) + to_string(a);
    if (stoi(s1) > stoi(s2))return true;
    else return false;

}

string solution(vector<int> numbers) {
    string answer = "";
    sort(numbers.begin(), numbers.end(), compare);
    for (int i = 0; i < numbers.size(); i++) {
        answer += to_string(numbers[i]);
    }
    if (answer[0] == '0') answer = '0';
    return answer;
}

int main() {

    cout << solution(numbers);
}