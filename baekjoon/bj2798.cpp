/*
문제:백준2798번
출처:https://www.acmicpc.net/problem/2798
*/
#include<iostream>
#include<algorithm>
#include<cstring>
#include<vector>
using namespace std;

int A[101];
int N, M;
vector<int>v;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i = 0; i < N; i++)cin >> A[i];

    for (int i = 0; i < N - 2; i++) {
        for (int j = i + 1; j < N - 1; j++) {
            for (int k = j + 1; k < N; k++) { 
                int sum = A[i] + A[j] + A[k];
                if(sum<=M) v.push_back(sum);
            }
        }
    }
    sort(v.begin(), v.end());
    cout << v[v.size()-1] << '\n';
}
