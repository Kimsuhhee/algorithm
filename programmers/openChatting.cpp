/*
문제:프로그래머스 > 코딩테스트연습 > 2019 KAKAO BLIND RECRUITMENT > 오픈채팅방
출처:https://programmers.co.kr/learn/courses/30/lessons/42888
*/
#include <string>
#include <vector>
#include <map>
#include <sstream>
#include <iostream>
using namespace std;

vector<string>record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
"Leave uid1234 Prodo","Enter uid1234 Prodo","Change uid4567 Ryan"};

int main() {
    vector<string> answer;
    map<string, string>m;
    string command, id, name;

    for (int i = 0; i < record.size(); i++) {
        stringstream s(record[i]);
        s >> command;
        s >> id;
        s >> name;
        if (command == "Enter") {
            m[id] = name;
        }
        else if (command == "Change") {
            m[id] = name;
        }
    }
    for (int i = 0; i < record.size(); i++) {
        stringstream s(record[i]);
        s >> command;
        s >> id;
        if (command == "Enter") {
            answer.push_back(m[id] + "님이 들어왔습니다.");
        }
        if (command == "Leave") {
            answer.push_back(m[id] + "님이 나갔습니다.");
        }
    }
    for (string s : answer)cout << s << '\n';
}