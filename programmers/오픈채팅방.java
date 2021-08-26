import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi",
                "Enter uid4567 Prodo","Leave uid1234",
                "Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);
        for(String s:answer) System.out.println(s);
    }
    public static String[] solution(String[] record) {
        HashMap<String,String>map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<record.length;i++){
            String[] comm = record[i].split(" ");
            if(comm[0].equals("Enter")||comm[0].equals("Change")){
                map.put(comm[1],comm[2]);
                if(comm[0].equals("Enter"))cnt++;
            }else cnt++;
        }
        String[] answer = new String[cnt];
        int j = 0;
        for(int i=0;i<record.length;i++){
            String[] comm = record[i].split(" ");
            if(comm[0].equals("Enter")){
                answer[j]=map.get(comm[1])+"님이 들어왔습니다.";
                j++;
            }else if(comm[0].equals("Leave")){
                answer[j]=map.get(comm[1])+"님이 나갔습니다.";
                j++;
            }
        }
        return answer;
    }
}
