import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1202 {
    static int N,K;
    static Jewel[]jewels;
    static int[] bags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        jewels = new Jewel[N];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            jewels[i] = new Jewel(m,v);
        }
   
        //보석 무게순으로 정렬
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return o1.weight - o2.weight;
            }
        });

        bags = new int[K];
        for(int i=0;i<K;i++){
            int c = Integer.parseInt(br.readLine());
            bags[i] = c;
        }

        //가방 무게순으로 정렬
        Arrays.sort(bags);

        //가격 순으로 정렬하는 힙
        PriorityQueue<Jewel>pq = new PriorityQueue<>();

        long answer = 0;
        int jIdx = 0;

        for(int i=0;i<K;i++){
            int weight = bags[i];
            while(jIdx < N && jewels[jIdx].weight<=weight){
                pq.add(jewels[jIdx++]);
            }
            if(!pq.isEmpty()){
                answer += pq.poll().price;
            }
        }
        System.out.println(answer);

    }

    private static class Jewel implements Comparable<Jewel>{
        int weight,price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return o.price - this.price;
        }
    }
}
