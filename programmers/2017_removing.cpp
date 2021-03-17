/*
문제:프로그래머스 > 코딩테스트연습 > 2017팁스타운 > 짝지어제거하기
출처:https://programmers.co.kr/learn/courses/30/lessons/12973
*/
#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = 1;
    stack<int>st;
    for(int i=0;i<s.size();i++){
        if(st.empty() || st.top()!=s[i])st.push(s[i]);
        else if(st.top()==s[i] && !st.empty())st.pop();
    }
    if(st.empty()) return answer;
    else return 0;
}
int main(){
   string s="baabaa";
   cout<<solution(s)<<'\n';
}