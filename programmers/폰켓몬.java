class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int[] cnt = new int[200001];
        for(int i=0;i<nums.length;i++){
            cnt[nums[i]]++;
        }
        int sum = 0;
        for(int i=0;i<200001;i++){
            if(cnt[i]==0)continue;
            sum++;
        }
        if(sum>=nums.length/2)answer = nums.length/2;
        else answer = sum;
        return answer;
    }
}