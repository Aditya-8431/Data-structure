package Map;
import java.util.*;

public class Hash_Map{
    public static void addingvalues(HashMap<Integer,String> map){
        map.put(1,"Aditya Raj");
        map.put(2,"Anmol");
        map.putIfAbsent(3,"Utkarsh");
        map.putIfAbsent(4,"Nitesh");

    }
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        addingvalues(map);
        for(Map.Entry<Integer,String> e : map.entrySet()){
            System.out.println(e.getKey() + "->" +e.getValue());
        }
        for(String i:map.values()){
            System.out.println(i);
        }
        for(Integer i:map.keySet()){
            System.out.println(i);
        }
    }
}
