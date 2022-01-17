import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1713 {
    static int N,recCnt;
    static int[] recOrder;
    static PriorityQueue<Info>pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        recCnt = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        recOrder = new int[recCnt];
        for(int i=0;i<recCnt;i++){
            recOrder[i] = Integer.parseInt(stk.nextToken());
        }

        pq = new PriorityQueue<>();

        int time = 0;
        for(int i=0;i<recCnt;i++){
            int order = recOrder[i];
            if(pq.size()!=N) {
                //현재 사진이 게시된 학생인지 확인
                if (!isIncluded(order)) {
                    pq.add(new Info(order,time++,0));
                }
            }else{
                //현재 사진이 게시된 학생인지 확인
                if(!isIncluded(order)){
                    pq.poll();
                    pq.add(new Info(order,time++,0));
                }
            }
        }

        ArrayList<Integer>answer = new ArrayList<>();
        while(!pq.isEmpty()){
            answer.add(pq.poll().idx);
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int i:answer){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

    private static boolean isIncluded(int order) {

        Queue<Info>q = new LinkedList<>();
        while(!pq.isEmpty()){
            q.add(pq.poll());
        }

        pq = new PriorityQueue<>();
        boolean flag = false;
        while(!q.isEmpty()){
            Info cur = q.poll();
            if(cur.idx==order) {
                flag = true;
                cur.recCnt+=1;
            }
            pq.add(cur);
        }
        return flag;
    }

    private static class Info implements Comparable<Info>{
        int idx,times,recCnt;

        public Info(int idx, int times, int recCnt) {
            this.idx = idx;
            this.times = times;
            this.recCnt = recCnt;
        }

        @Override
        public int compareTo(Info o) {
            if(o.recCnt==this.recCnt){
                return this.times - o.times;
            }else return this.recCnt - o.recCnt;
        }
    }
}

