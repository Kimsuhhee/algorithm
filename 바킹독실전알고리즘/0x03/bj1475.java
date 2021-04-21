import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int cnt = 0;
        int[] cntArr = new int[10];

        for(int i=0;i<N.length();i++){
            int tmp = N.charAt(i)-'0';
            if(tmp == 9){
                tmp = 6;
            }
            cntArr[tmp]++;
        }
        int tmp = cntArr[6];
        if(cntArr[6] % 2 ==0){
            cntArr[6] = tmp/2;
        }else{
            cntArr[6] = tmp/2 +1;
        }
        int max = Integer.MIN_VALUE;
        for(int i:cntArr){
            max = Math.max(max,i);
        }
        System.out.println(max);
    }
}
