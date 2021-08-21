class Solution {
    static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        int len = numbers.length;
        dfs(0,len,numbers,target,0);
        return answer;
    }
    public static void dfs(int n, int N, int[] numbers, int target, int sum){
        if(n==N){
            if(sum==target)answer++;
            return;
        }
        dfs(n+1,N,numbers,target,sum+numbers[n]);
        dfs(n+1,N,numbers,target,sum-numbers[n]);

    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        System.out.println(solution(numbers,target));
    }
}