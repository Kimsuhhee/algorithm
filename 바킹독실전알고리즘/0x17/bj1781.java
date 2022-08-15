import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj1781 {
    static int N;
    static long sum;
    static PriorityQueue<HomeWork>homeWork,pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //데드라인 작은순, 같다면 라면 개수가 많은 순
        homeWork = new PriorityQueue<>(new Comparator<HomeWork>() {
            @Override
            public int compare(HomeWork o1, HomeWork o2) {
                if(o1.deadLine == o2.deadLine)
                    return o2.count - o1.count;
                return o1.deadLine - o2.deadLine;
            }
        });

        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(stk.nextToken());
            int count = Integer.parseInt(stk.nextToken());
            homeWork.add(new HomeWork(deadLine, count));
        }

        //라면개수 작은 순
        pq = new PriorityQueue<>(new Comparator<HomeWork>() {
            @Override
            public int compare(HomeWork o1, HomeWork o2) {
                if(o1.count == o2.count)
                    return o2.deadLine - o1.deadLine;
                return o1.count - o2.count;
            }
        });

        while(!homeWork.isEmpty()){
            HomeWork hm = homeWork.poll();
            pq.add(hm);
            if(pq.size() > hm.deadLine)pq.poll();
        }

        while(!pq.isEmpty()){
            sum += pq.poll().count;
        }
        System.out.println(sum);
    }

    private static class HomeWork {
        int deadLine;
        int count;

        public HomeWork(int deadLine, int count) {
            this.deadLine = deadLine;
            this.count = count;
        }
    }
}
