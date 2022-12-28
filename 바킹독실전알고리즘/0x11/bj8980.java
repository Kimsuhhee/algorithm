import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj8980 {
    static int N,C,M;
    static PriorityQueue<Box>boxes;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;

        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(br.readLine());

        boxes = new PriorityQueue<>();

        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int sendNum = Integer.parseInt(stk.nextToken());
            int recepNum = Integer.parseInt(stk.nextToken());
            int cnt = Integer.parseInt(stk.nextToken());
            boxes.add(new Box(sendNum, recepNum, cnt));
        }

        arr = new int[N + 1];
        for(int i = 0 ; i <= N ; i++){
            arr[i] = C;
        }

//        int answer = 0;
//        while(!boxes.isEmpty()){
//            Box b = boxes.poll();
//            int max = 0;
//            for(int i = b.send ; i < b.reception ; i++){
//                max = Math.max(max, arr[i]);
//            }
//
//            int w = Math.min(C - max,b.cnt);
//
//            for(int i = b.send ; i < b.reception ; i++){
//                arr[i] += w;
//            }
//            answer += w;
//        }

        int answer = 0;
        while(!boxes.isEmpty()){
            Box b = boxes.poll();
            int min = 100000;

            //구간에서 태울 수 있는 최소 택배 개수
            for(int i = b.send ; i < b.reception ; i++){
                min = Math.min(min, arr[i]);
            }

            //현재 태우려하는 택배개수와 구간내 최소 택배 개수
            int w = Math.min(min,b.cnt);

            for(int i = b.send ; i < b.reception ; i++){
                arr[i] -= w;
            }

            answer += w;
        }

        System.out.println(answer);
    }

    private static class Box implements Comparable<Box>{
        int send, reception, cnt;

        public Box(int send, int reception, int cnt) {
            this.send = send;
            this.reception = reception;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Box o) {
            if(this.reception == o.reception){
                return this.send - o.send;
            }
            return this.reception - o.reception;
        }
    }
}
