package Classes;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory<K,V>{

    /*
    HashMap hashmap = new HashMap();
    TreeMap treemap= new TreeMap();
    LinkedHashMap linkedhashmap= new LinkedHashMap();
     */

    //This method has the function of gave one of the three mapping style.
    //depending of the choice of the user.

    public Map<K,V> SetType(String type){
        if(type.toUpperCase().equals("HashMap")){
            return new HashMap<>();
        }
        else if (type.toUpperCase().equals("TreeMap")){
            return new TreeMap<>();
        }
        else if(type.toUpperCase().equals("LinkedHashMap")){
            return new LinkedHashMap<>();
        }

        return null;
    }

}
