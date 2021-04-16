import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dice = br.readLine();
        String[] diceArr = dice.split(" ");

        int[] cnt = new int[7];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<3;i++){
            cnt[Integer.parseInt(diceArr[i])]++;
            max = Math.max(max,Integer.parseInt(diceArr[i]));
        }

        int cost=0;
        for(int i=1;i<7;i++){
            if(cnt[i]==3){
                cost = 10000+(i*1000);
                break;
            }else if(cnt[i]==2){
                cost=1000+(i*100);
                break;
            }else{
                cost=max*100;
            }
        }
        System.out.println(cost);
    }
}
