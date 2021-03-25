package Z2021.a0322;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Test2 {
    public static void main(String[] args) {
        //String str = "aabbcc";
        //System.out.println(str.replaceAll("(.)\\1+","$1"));
        String ip = "192.168.3.23 202.10.34.2 3.3.3.3 127.0.0.1 80.12.23.34";
        ip = ip.replaceAll("(\\d+)","00$1");
        System.out.println(ip);
        ip = ip.replaceAll("0*(\\d{3})","$1");
        System.out.println(ip);
        String[] arr = ip.split(" +");
        TreeSet<String> set = new TreeSet<>();
        for(String str : arr){
            set.add(str);
        }
        for(String str :set){
            System.out.println(str.replaceAll("0*(\\d+)","$1"));
        }
        System.out.println();
    }
}
