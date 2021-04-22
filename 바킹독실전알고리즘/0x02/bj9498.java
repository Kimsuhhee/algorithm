import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int jumsu = Integer.parseInt(br.readLine());
        if(jumsu>=90 && jumsu<=100){
            System.out.println("A");
            return;
        }else if(jumsu>=80 && jumsu<=89){
            System.out.println("B");
            return;
        }else if(jumsu>=70 && jumsu<=79){
            System.out.println("C");
            return;
        }else if(jumsu>=60 && jumsu<=69){
            System.out.println("D");
            return;
        }else{
            System.out.println("F");
        }
    }
}
