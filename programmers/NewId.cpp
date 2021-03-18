/*
문제:프로그래머스 > 코딩테스트연습 > 2021 KAKAO BLIND RECRUITMENT > 신규아이디추천
출처:https://programmers.co.kr/learn/courses/30/lessons/72410
*/
#include <iostream>
#include <string>
#include <vector>
#include <cctype>
using namespace std;

string new_id = "z-+.^.";

string solution(string new_id) {
    string answer = "";
    string tmp = "";

    // 1. 대문자->소문자
    for (int i = 0; i < new_id.size(); i++) {
        if (new_id[i] >= 'A' && new_id[i] <= 'Z') {
            int c = new_id[i];
            new_id[i] = tolower(c);
        }
    }

    // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
    for (int i = 0; i < new_id.size(); i++) {
        if (islower(new_id[i]) || isdigit(new_id[i]) || new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.') {
            tmp += new_id[i];
        }
    }

    //3. (.)가 2번 이상 연속된 부분을 하나의 (.)로 치환
    bool b = false; //(.)이 나왔는지 체크
    for (int i = 0; i < tmp.size(); i++) {
        if (tmp[i] == '.' && b == true) continue;
        answer += tmp[i];
        b = (tmp[i] == '.');
    }

    // 4. (.)가 처음이나 끝에 위치한다면 제거
    if (answer.size() >= 1 && answer[0] == '.') {
        answer.erase(0, 1);
    }
    if (answer.size() >= 1 && answer[answer.size() - 1] == '.') {
        answer = answer.substr(0, answer.size() - 1);
    }

    // 5. 빈 문자열이라면, new_id에 "a"를 대입
    if (answer.size() == 0) answer += 'a';

    // 6. 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    if (answer.size() >= 16) {
        answer = answer.substr(0, 15);
    }
    // 만약 제거 후 (.)가 new_id의 끝에 위치한다면 끝에 위치한 (.) 문자를 제거
    if (answer[answer.size() - 1] == '.') answer = answer.substr(0, answer.size() - 1);

    // 7. 길이가 2이하면 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
    while (answer.size() <= 2) {
        if (answer.size() == 3)break;
        answer += answer[answer.size() - 1];
    }

    return answer;
}

int main() {
    cout << solution(new_id) << '\n';
}