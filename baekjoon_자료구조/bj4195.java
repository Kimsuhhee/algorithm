import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj4195 {
    static int T,F;
    static HashMap<String,Integer>nameToIndex;
    static int[] parent,size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        T = Integer.parseInt(br.readLine());
        while(T-- >0){
            F = Integer.parseInt(br.readLine());
            nameToIndex = new HashMap<>();
            int idx = 1;
            parent = new int[2 * F + 1];
            size = new int[2 * F + 1];
            for(int i=1;i<=2*F;i++){
                parent[i] = i;
                size[i] = 1;
            }
            for(int i=0;i<F;i++){
                //두명의 이름 map에 저장
                stk = new StringTokenizer(br.readLine());
                String name1 = stk.nextToken();
                String name2 = stk.nextToken();
                if(!nameToIndex.containsKey(name1))nameToIndex.put(name1,idx++);
                if(!nameToIndex.containsKey(name2))nameToIndex.put(name2,idx++);

                //각 이름의 인덱싱을 가져옴
                int a = nameToIndex.get(name1);
                int b = nameToIndex.get(name2);

                union(a,b);

                int pa = find(a);
                int pb = find(b);

                //두 명이 같은 친구 그룹이 아니라면 각 그룹의 크기를 더해줌,
                //같은 그룹이라면 해당 그룹의 크기를 반환
                if(pa == pb) {
                    System.out.println(size[pa]);
                }else{
                    System.out.println(size[pa] + size[pb]);
                }
            }
        }
    }

    private static int find(int a) {
        if(parent[a]==a)return a;
        int idx = find(parent[a]);
        size[a] += size[parent[a]] ;
        return parent[a] = idx;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b)return;
        parent[b] = a;
        size[a] += size[b];
    }
}
