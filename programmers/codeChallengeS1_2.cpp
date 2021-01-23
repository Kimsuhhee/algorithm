/*
����:���α׷��ӽ� > �ڵ��׽�Ʈ���� > �����ڵ�ç��������1 > 3����������
��ó:https://programmers.co.kr/learn/courses/30/lessons/68935
*/
#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> vec;

    while (n) {
        vec.push_back(n % 3);
        n /= 3;
    }
    reverse(vec.begin(), vec.end());
    for (int i = 0; i < vec.size(); i++) {
        answer += pow(3, i) * vec[i];
    }
    return answer;
}

int main() {
    int n = 45;
    cout << solution(n) << endl;
}