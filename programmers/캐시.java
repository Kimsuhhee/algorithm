import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju","Pangyo","Seoul","NewYork","LA","Jeju","Pangyo","Seoul","NewYork","LA"};
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        //String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(cacheSize,cities));
    }
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize==0) return cities.length*5;

        ArrayList<String>list = new ArrayList<>();
        list.add(cities[0].toLowerCase());
        answer += 5;
        for(int i=1;i<cities.length;i++){
            if(list.remove(cities[i].toLowerCase())){
                list.add(cities[i].toLowerCase());
                answer+=1;
            }else{
                if(list.size()<cacheSize){
                    list.add(cities[i].toLowerCase());
                    answer+=5;
                }else{
                    list.remove(0);
                    list.add(cities[i].toLowerCase());
                    answer+=5;
                }
            }
        }
        return answer;
    }
}
