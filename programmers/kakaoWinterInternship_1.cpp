/*
문제:프로그래머스 > 코딩테스트연습 > 2019 카카오 개발자 겨울 인턴십 > 크레인 인형뽑기 게임
출처:https://programmers.co.kr/learn/courses/30/lessons/64061
*/
#include <string>
#include <vector>
#include <stack>
#include <iostream>
using namespace std;
stack<int>s;
vector<vector<int>> board = { {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1} };
vector<int> moves = { 1,5,3,5,1,2,1,4 };

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;

    for (int i = 0; i < moves.size(); i++) {
        int target = moves[i] - 1;
        for (int i = 0; i < board.size(); i++) {
            if (board[i][target] == 0)continue;
            if (!s.empty() && s.top() == board[i][target]) {
                s.pop();
                answer += 2;
            }
            else s.push(board[i][target]);

            board[i][target] = 0; break;
        }

    }

    return answer;
}

int main() {
    cout << solution(board, moves);
}