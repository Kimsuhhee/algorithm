import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj14476 {
    static int N;
    static int[] arr,gcdR,gcdL;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        //Arrays.sort(arr);

        gcdR = new int[N];
        gcdL = new int[N];

        //오른쪽 방향으로 누적 최대 공약수 배열 채우기
        gcdR[0] = arr[0];

        for(int i=1;i<N;i++){
            gcdR[i] = gcd(gcdR[i-1],arr[i]);
        }

        //왼쪽 방향으로 누적 최대 공약수 배열 채우기
        gcdL[N-1] = arr[N-1];
        for(int i=N-2;i>=0;i--){
            gcdL[i] = gcd(gcdL[i+1],arr[i]);
        }

        int maxGCD = -1, number = 0;
        for(int i=0;i<N;i++){
            int temp = 0;
            if(i==0){
                temp = gcdL[1];
            }else if(i==N-1){
                temp = gcdR[N-2];
            }else{
                temp = gcd(gcdL[i+1],gcdR[i-1]);
            }

            if((arr[i]%temp)!=0){
                if(maxGCD<temp){
                    maxGCD = temp;
                    number = arr[i];
                }
            }
        }
        if(maxGCD!=-1) {
            System.out.println(maxGCD+" "+number);
        }else System.out.println(-1);

    }

    private static int gcd(int a, int b) {
        if(a==0)return b;
        return gcd(b%a,a);
    }
}
