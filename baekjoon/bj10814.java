import java.io.*;
import java.util.*;

public class bj10814 {

    private static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Person> arr = new ArrayList<Person>();
        String s;
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            s = br.readLine();
            StringTokenizer stk = new StringTokenizer(s);
            int age = Integer.parseInt(stk.nextToken());
            String name = stk.nextToken();
            arr.add(new Person(name,age));
        }

        Collections.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age-o2.age;
            }
        });

        for(int i=0;i<N;i++){
            sb.append(arr.get(i).age).append(" ").append(arr.get(i).name).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
