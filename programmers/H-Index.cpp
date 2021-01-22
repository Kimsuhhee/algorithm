#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int find = 0;
    sort(citations.begin(), citations.end());
    reverse(citations.begin(), citations.end());
    for (int h = 0; h < citations.size(); h++) {
        if (citations[h] <= h) {
            answer = h;
            break;
        }
        else find++;
    }
    if (find == citations.size())
        answer = find;
    return answer;
}
int main() {
    vector<int>citations;
    citations.push_back(3);
    citations.push_back(0);
    citations.push_back(6);
    citations.push_back(1);
    citations.push_back(5);

    cout << solution(citations) << endl;
    
}