import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer>map = new TreeMap<>();
        int sum = 0; //총 개수
        while(true){
            String tree = br.readLine();
            if(tree==null || tree.isBlank())break;
            map.put(tree,map.getOrDefault(tree,0)+1);
            sum++;
        }

        StringBuilder sb = new StringBuilder();
        for(String s:map.keySet()){
            double p = map.get(s)*100/(double)sum;
            sb.append(s+" "+String.format("%.4f",p)).append("\n");
        }

        System.out.println(sb);

    }

}
