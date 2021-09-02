import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {
    static int max = -10000;
    public static void main(String[] args) {
        int[] numbers = {0,0,0};
        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr ,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(String s: arr){
            answer += s;
        }
        if(answer.charAt(0)=='0')answer = "0";
        return answer;
    }
}
