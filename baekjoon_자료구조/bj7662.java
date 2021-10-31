import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer>map = new TreeMap<>();
            while(k-- > 0){
                stk = new StringTokenizer(br.readLine());
                String command = stk.nextToken();
                int number = Integer.parseInt(stk.nextToken());
                if(command.equals("I")){
                    map.put(number,map.getOrDefault(number,0)+1);
                }else if(command.equals("D")){
                    if(map.isEmpty())continue;
                    if(number==1){
                        int max = map.lastKey();
                        if(map.get(max)==1) map.remove(max);
                        else map.replace(max,map.get(max)-1);
                    }else{
                        int min = map.firstKey();
                        if(map.get(min)==1) map.remove(min);
                        else map.replace(min,map.get(min)-1);
                    }
                }
            }
            if(map.size()==0) System.out.println("EMPTY");
            else System.out.println(map.lastKey()+" "+map.firstKey());
        }
    }

}
