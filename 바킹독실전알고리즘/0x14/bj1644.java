import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj1644 {
    static int N;
    static ArrayList<Integer>prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        primeSieve();

        int st = 0, en = 0;
        int sum = prime.get(0);
        int answer = 0;
        while(true){
            if(sum<N){
                en++;
                if(en== prime.size())break;
                sum += prime.get(en);
            }else if(sum>=N){
                if(sum==N){
                    answer++;
                }
                sum -= prime.get(st);
                st++;
            }
        }
        System.out.println(answer);
    }

    private static void primeSieve() {
        int[]sieve = new int[4000001];

        for(int i=2;i<=4000000;i++){
            sieve[i] = i;
        }
        for(int i=2;i<=4000000;i++){
            for(int j=i+i;j<=4000000;j+=i){
                if(sieve[j]==0)continue;
                sieve[j] = 0;
            }
        }

        for(int i=2;i<=4000000;i++){
            if(sieve[i]!=0){
                prime.add(sieve[i]);
            }
        }
    }

}
