import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean find = false;
        for(int i=0;i<7;i++){
            int num = Integer.parseInt(br.readLine());
            if(num % 2 == 1){
                find = true;
                sum += num;
                min = Math.min(min,num);
            }
        }
        if(find){
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
    }
}
