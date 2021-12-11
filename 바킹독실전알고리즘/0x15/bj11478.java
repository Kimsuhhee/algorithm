import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String>set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            String temp = "";
            temp += s.charAt(i);
            set.add(temp);
            for(int j=i+1;j<s.length();j++){
                temp += s.charAt(j);
                set.add(temp);
            }
        }
        System.out.println(set.size());
    }
}
