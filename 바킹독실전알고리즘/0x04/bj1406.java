import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class bj1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList list = new LinkedList();

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int N = s.length();

        for(int i=0;i<N;i++){
            list.add(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        ListIterator cursor = list.listIterator(N); //커서위치

        for(int i=0;i<M;i++){

            String command = br.readLine();
            String[] commands = command.split(" ");

            if(commands[0].equals("P")){
                //commands[1]을 붙임
                cursor.add(commands[1]);
            }else if(commands[0].equals("L")){
                if(cursor.hasPrevious())
                    cursor.previous();
            }else if(commands[0].equals("D")){
                if(cursor.hasNext())
                    cursor.next();
            } else if (commands[0].equals("B")) {
                if(cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
        }

        Iterator it = list.iterator();
        while(it.hasNext()){
            sb.append(it.next());
        }
        System.out.println(sb);
      }
    }
