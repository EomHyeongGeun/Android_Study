package my.kmu.com.quickcoding05;

import java.util.ArrayList;

/**
 * Created by eomhyeong-geun on 2016. 11. 13..
 */

public class GenericList<T1, T2> {

    public ArrayList<T1> list_int =  new ArrayList<T1>();
    public ArrayList<T2> list_string =  new ArrayList<T2>();

    public void addInt(T1 text){
        list_int.add(text);
    }

    public void addString(T2 text){
        list_string.add(text);
    }

}

