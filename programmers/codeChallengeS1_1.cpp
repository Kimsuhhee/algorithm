/*
����:���α׷��ӽ� > �ڵ��׽�Ʈ���� > �����ڵ�ç��������1 > ����
��ó:https://programmers.co.kr/learn/courses/30/lessons/70128
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> a, vector<int> b) {
    int answer = 0;
    for (int i = 0; i < a.size(); i++) {
        answer += a[i] * b[i];
    }
    return answer;
}

int main() {
   // vector<int>a{ 1,2,3,4 };
    vector<int>a{ -1,0,1 };
   // vector<int>b{ -3,-1,0,2 };
    vector<int>b{ 1,0,-1 };
    cout << solution(a, b);
}