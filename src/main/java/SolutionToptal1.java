// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Map;

class SolutionToptal1 {


    public int solution(int Y, String A, String B, String W) {
        // write your code in Java SE 11

        String [] m = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        Integer [] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String [] dd = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        if( Y%4==0){ // leap year
            d[1] =d[1] + 1;
        }

        //2014,april,may,wednesday
        int days =0;
        int dayStart =0;
        int dayEnd =0;
        int shift=0;
        int shiftEnd=0;
        for(int x=0;x<d.length;x++){
            days +=d[x];

            if(m[x].equalsIgnoreCase(A)){ // start month find week
                days -=d[x];
                dayStart =days;
                 //find next monday
                shift= (days-1)%7;

            }
            if(m[x].equalsIgnoreCase(B)){ // end month find week
                dayEnd =days;

                shiftEnd= (days-1)%7;

            }

        }


        int off =0;
        for(int x=0;x<dd.length;x++){
            if(dd[x].equalsIgnoreCase(W)){
                off=x;
            }
        }
        int time =  dayEnd-dayStart -off+shiftEnd-shift;
     return (int)time/7;

    }



    public String solution(String[] a, String[] b, String p) {
        // write your code in Java SE 8
        HashSet<Integer> s = new HashSet<>();
        String small = null;
        for(int x=0;x<a.length;x++){
            if(b[x].contains(p)){
                if(small==null) small=a[x];
                if(a[x].compareToIgnoreCase(small)<0){
                    small=a[x];
                }


            }
        }
 return small!=null?small:"NO CONTACT";
    }

    public static void main(String[] args) {

        SolutionToptal1 s = new SolutionToptal1();
        System.out.println(s.solution(new String[]{"pim","pom","leo"},new String[]{"8888888","9999999","44455666"},"999"));

        System.out.println(s.solution(new String[]{"adam","eva","leo"},new String[]{"12121212","111111111","44455666"},"112"));
    }
}
