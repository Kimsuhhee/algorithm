/*
����:���α׷��ӽ� > �ڵ��׽�Ʈ���� > 2017����Ÿ�� > ¦���������ϱ�
��ó:https://programmers.co.kr/learn/courses/30/lessons/12973
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