import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String num = br.readLine();
        String[] nums = num.split(" ");
        int x = Integer.parseInt(br.readLine());

        int[] cnt = new int[1000005]; //개수 배열
        int answer = 0;

        for(int i=0;i<n;i++){
            if(Integer.parseInt(nums[i])<=x && cnt[x-Integer.parseInt(nums[i])]==1){
                answer++;
            }
            cnt[Integer.parseInt(nums[i])]++;
        }

        System.out.println(answer);

    }
}
