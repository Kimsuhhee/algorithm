import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class bj7785 {
    static int N;
    static ArrayList<String>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String,Integer>map = new HashMap<>();
        while(N-- > 0){
            String[] log= br.readLine().split(" ");
            if(log[1].equals("enter"))map.put(log[0],1);
            if(log[1].equals("leave"))map.remove(log[0]);
        }
        for(String s:map.keySet()){
            list.add(s);
        }
        Collections.sort(list,Collections.reverseOrder());
        for(String s:list) System.out.println(s);
    }
}
