/*
문제:백준2941번
출처:https://www.acmicpc.net/problem/2941
*/
#include<iostream>
#include<vector>
using namespace std;

int main() {
	vector<string> c = {"c=","c-","dz=","d-","lj","nj","s=","z=" };
	string s = "";
	cin >> s;
	for (int i = 0; i < c.size(); i++) {
		for (int idx = s.find(c[i]) ; idx != string::npos; idx = s.find(c[i])) {
			s.replace(s.find(c[i]), c[i].length(),"0");
			cout << s << '\n';
		}
	}
	cout << s.length();
	
}