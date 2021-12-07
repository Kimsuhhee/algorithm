import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11653 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=2;i*i<=N;i++){
            while(N%i==0){
                System.out.println(i);
                N/=i;
            }
        }
        //N이 1인경우 아무것도 출력하지 않음
        if(N!=1) System.out.println(N);
    }
}
