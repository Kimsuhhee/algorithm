/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 정수내림차순으로배치하기
출처:https://programmers.co.kr/learn/courses/30/lessons/12933
*/
#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    string s = "";
    s = to_string(n); //문자열로 변환
    sort(s.begin(), s.end(), greater<char>()); //문자열내에서 문자 기준으로 정렬
    return answer = stoll(s);
}

int main() {
    cout << solution(118372) << '\n';

}