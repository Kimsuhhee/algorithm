import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class bj5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            String L = br.readLine();
            int len = L.length();
            LinkedList list = new LinkedList();
            ListIterator cursor = list.listIterator();

            for(int j=0;j<len;j++){
                if(L.charAt(j)=='<'){
                    if(cursor.hasPrevious())
                        cursor.previous();
                }else if(L.charAt(j)=='>'){
                    if(cursor.hasNext())
                        cursor.next();
                }else if(L.charAt(j)=='-'){
                    if(cursor.hasPrevious()){
                        cursor.previous();
                        cursor.remove();
                    }
                }else{
                    cursor.add(L.charAt(j));
                }
            }

            Iterator it = list.iterator();
            while(it.hasNext()){
                sb.append(it.next());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
