import java.io.*;
import java.util.*;

public class bj16165 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        HashMap<String, ArrayList<String>>map = new HashMap<>();
        for(int i=0;i<N;i++){
            String g = br.readLine();
            int m = Integer.parseInt(br.readLine());
            ArrayList<String>list = new ArrayList<>();
            for(int j=0;j<m;j++){
                String name = br.readLine();
                list.add(name);
            }
            Collections.sort(list);
            map.put(g,list);
        }

        while(M-- > 0){
            String find = br.readLine();
            String type = br.readLine();
            if(type.equals("1")){
                for(Map.Entry<String,ArrayList<String>>m:map.entrySet()){
                    ArrayList<String>t = m.getValue();
                    if(t.contains(find)){
                        bw.write(m.getKey()+"\n");
                        break;
                    }
                }
                continue;
            }
            if(type.equals("0")){
                ArrayList<String>temp = map.get(find);
                for(String s:temp){
                    bw.write(s+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
