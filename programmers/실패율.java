import java.util.*;
public class 실패율 {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] answer = solution(N,stages);
        for(int i: answer) System.out.print(i+" ");
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int tot = stages.length;
        int[] count = new int[N+1];
        for(int i=0;i<stages.length;i++){
            if(stages[i]==N+1)continue;
            count[stages[i]]++;
        }

        ArrayList<Info>list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            if(tot==0)list.add(new Info(i,0));
            else list.add(new Info(i,(double)count[i]/tot));
            tot-=count[i];
        }
        Collections.sort(list);
        int idx = 0;
        for(Info info:list) {
            answer[idx++] = info.stage;
        }
        return answer;
    }
    public static class Info implements Comparable<Info>{
        int stage;
        double fails;
        public Info(int stage,double fails){
            this.stage = stage;
            this.fails = fails;
        }
        public int compareTo(Info f) {
            if(this.fails==f.fails){
                return this.stage-f.stage;
            }else
                return Double.compare(f.fails,this.fails);
        }
    }
}