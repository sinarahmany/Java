package com.company;

public class third {
    public int time(int hour, int minute, int second)
    {
        if(hour>12)
        {
            int r = ((hour-12)*3600) + (minute*60) + second;
            System.out.println(r);
            return r;
        }
        else
        {
            int r = (hour*3600) + (minute*60) + second;
            System.out.println(r);
            return r;
        }
    }


}
