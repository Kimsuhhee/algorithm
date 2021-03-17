/*
문제:프로그래머스 > 코딩테스트연습 > Summer/Winter Coding > 예산
출처:https://programmers.co.kr/learn/courses/30/lessons/12982
*/
#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> d, int budget) {
    
    int answer = 0;

    sort(d.begin(),d.end());
    
    for(int i=0;i<d.size();i++){
        if(d[i]>budget)break;
        budget-=d[i];
        answer++;
    }
    
    return answer;
}

int main(){

   vector<int>d={1,3,2,5,4};
   budget=9;
   cout<<solution(d,budget)<<'\n';
}