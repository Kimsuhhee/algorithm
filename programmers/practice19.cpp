/*
문제:프로그래머스 > 코딩테스트연습 > 연습문제 > 멀리뛰기
출처:https://programmers.co.kr/learn/courses/30/lessons/12914
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;

long long d[2001];
long long solution(int n) {
    d[1]=1;d[2]=2;d[3]=3;d[4]=5;
    for(int i=5;i<=n;i++){
        d[i]=(d[i-1]+d[i-2])%1234567;
    }
    
    return d[n];
}

int main() {
    cout << solution(5) << '\n';
}