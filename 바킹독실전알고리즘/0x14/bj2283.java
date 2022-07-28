import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj2283 {
    static int N, K, maxV = -1;
    static int[] len, sum;
    static PriorityQueue<Length>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        len = new int[1000001];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stk.nextToken());
            int B = Integer.parseInt(stk.nextToken());

            //구간에서 가장 큰 값
            maxV = Math.max(maxV, B);

            //구간별 길이 합
            for(int l = A+1 ; l <= B ; l++){
                len[l]++;
            }
        }

        //구간에 해당하는 누적합
        sum = new int[1000001];
        for(int i=1;i<=1000000;i++){
            sum[i] += len[i] + sum[i-1];
        }

        pq = new PriorityQueue<>(new Comparator<Length>() {
            @Override
            public int compare(Length o1, Length o2) {
                //sum이 가장 작은 구간이 여러개 있다면 A가 가장 작은것 그러한것도 여러개가 있다면 B가 가장 작은것
                if(o1.sum == o2.sum){
                    if(o1.A == o2.A){
                        return o1.B - o2.B;
                    }
                    return o1.A - o2.A;
                }
                return o1.sum - o2.sum;
            }
        });

        int st = 0, en = 1;
        while(st <= en && en <=maxV){
            int res = sum[en] - sum[st];
            if(res < K){
                en++;
            }else {
                pq.add(new Length(st,en,res));
                st++;
            }
        }

        if(pq.isEmpty()) System.out.println(0+" "+0);
        else System.out.println(pq.peek().A+" "+pq.peek().B);

    }

    private static class Length {
        int A, B, sum;

        public Length(int a, int b, int sum) {
            this.A = a;
            this.B = b;
            this.sum = sum;
        }
    }
}
