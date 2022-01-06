import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj21276 {
    static int N,M;

    //이름 정보만 가지고 있는 리스트
    static ArrayList<String>list;

    //이름으로 해당 인덱스 찾는 hashmap
    static HashMap<String,Integer>name;

    //인덱스로 해당하는 이름 찾는 hashmap
    static HashMap<Integer,String>number;
   
    //계보 정보
    static ArrayList<Integer>genealogy[];
    static ArrayList<String> childList[];
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        name = new HashMap<>();
        number = new HashMap<>();
        list = new ArrayList<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            String s = stk.nextToken();
            name.put(s,i);
            number.put(i,s);
            list.add(s);
        }

        genealogy = new ArrayList[N];
        for(int i=0;i<N;i++){
            genealogy[i] = new ArrayList<>();
        }

        indegree = new int[N];
        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            String des = stk.nextToken();
            String anc = stk.nextToken();
            genealogy[name.get(anc)].add(name.get(des));
            indegree[name.get(des)]++;
        }

        StringBuilder sb = new StringBuilder();

        //진입 차수가 0 - > 각 가문의 시조임
        ArrayList<String>root = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                root.add(number.get(i));
                q.add(i);
            }
        }

        Collections.sort(root);
        
       //총 가문 수와 각 가문의 시조 출력
        sb.append(root.size() + "\n");
        for(String s:root)sb.append(s + " ");
        sb.append("\n");

        childList = new ArrayList[N];
        for(int i=0;i<N;i++){
            childList[i] = new ArrayList<>();
        }

       //시조의 자식부터 위상정렬 하기
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : genealogy[cur]){
                indegree[next]--;
                if(indegree[next]==0){
                    childList[cur].add(number.get(next));
                    q.add(next);
                }
            }
        }

        //이름 정렬
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            String s = list.get(i);
            int idx = name.get(s);

            //해당 이름의 자식정보리스트 정렬
            Collections.sort(childList[idx]);

            sb.append(s+" "+childList[idx].size()+" ");
            for(String child : childList[idx]){
                sb.append(child+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
