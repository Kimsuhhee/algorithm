import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int two = 0, five = 0;
        for(int i=2;i<=N;i++){
            int temp = i;
            while(temp%2==0){
                two++;
                temp /= 2;
            }
            while(temp%5==0){
                five++;
                temp /= 5;
            }
        }
        int ans = Math.min(two,five);
        System.out.println(ans);
    }
}
