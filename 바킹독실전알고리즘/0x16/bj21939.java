import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class bj21939 {
    static int N,M;
    static TreeSet<Info>list;
    static Map<Integer,Integer> list1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //문제 리스트에 있는 문제의 개수
        list = new TreeSet<>();
        list1 = new HashMap<>();

        StringTokenizer stk;
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(stk.nextToken());
            int L = Integer.parseInt(stk.nextToken());
            list.add(new Info(P,L));
            list1.put(P,L);
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("add")){
                int P = Integer.parseInt(arr[1]);
                int L = Integer.parseInt(arr[2]);
                list.add(new Info(P,L));
                list1.put(P,L);
            }else if(arr[0].equals("recommend")){
                int x = Integer.parseInt(arr[1]);
                if(x==1){
                    sb.append(list.last().num+"\n");
                }else if(x==-1){
                    sb.append(list.first().num+"\n");
                }
            }else {
                int P = Integer.parseInt(arr[1]);
                list.remove(new Info(P,list1.get(P)));
                list1.remove(P);
            }
        }
        System.out.print(sb);
    }

    private static class Info implements Comparable<Info>{
        int num,level;

        public Info(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Info o) {
            if(this.level==o.level){
                return this.num - o.num;
            }
            return this.level - o.level;
        }
    }
}
