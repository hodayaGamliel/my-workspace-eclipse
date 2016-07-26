
public class TimeDriver {
    final static Time1 time1 = new Time1(5,60,5);//this var is manipulated.
    public final static Time1 time1_2 = new Time1(5,3,15);
    public final static Time1 time1_3 = new Time1(1,23,5);

    public final static Time2 time2 = new Time2(5,60,5);//this var is manipulated.
    public final static Time2 time2_2 = new Time2(5,3,15);
    public final static Time2 time2_3 = new Time2(1,23,5);

    public static void main(String[] args) {
        Check_Equally();
        Check_validation();
        Check_aliasing();
        CheckTimeToString();
        CheckBefore();
        CheckAfter();
        CheckTime2();

    }
    private static void Check_Equally(){
        //string equally
        if(!time1_2.toString().equals(time2_2.toString()) || !time1_3.toString().equals(time2_3.toString()))
            System.out.println("Err : toString() method does not equal in both time1 and time2");

        //difference equally
        if(time1_2.difference(time1_3) != time2_2.difference(time2_3))
            System.out.println("Err : Issue with `difference()` method equally between Time1 and Time2");

        //secFromMidnight
        if(time1_2.secFromMidnight() != time2_2.secFromMidnight() || time1_3.secFromMidnight() != time2_3.secFromMidnight())
            System.out.println("Err : Issue with `secFromMidnight()` method equally between Time1 and Time2");
        //before equally
        if(time1_2.before(time1_3) != time2_2.before(time2_3))
            System.out.println("Err : Issue with `before()` method equally between Time1 and Time2");
        if(time1_2.after(time1_3) != time2_2.after(time2_3))
            System.out.println("Err : Issue with `after()` method equally between Time1 and Time2");

    }
    private static void Check_validation(){
        if(time1.getHour() != 5 || time1.getMinute() != 0 || time1.getSecond() != 5)
            System.out.println("Err : Time1 constructor invalid");

        time1.setMinute(4);
        time1.setHour(24);
        if(time1.getHour() != 5 || time1.getMinute() != 4){
            System.out.println("Err : Time1 set functions invalid");
        }

        Time1 tmp_time = new Time1(-1,-1,-1);
        Time1 tmp_time2 = new Time1(0,0,0);
        if(!tmp_time.equals(tmp_time2))
            System.out.println("Err : Time1 construct doesn't initial to 0 in case value is invalid");
    }
    private static void Check_aliasing(){
        Time1 copy_time1 = new Time1(time1);

        if(!time1.equals(copy_time1))
            System.out.println("Err : Time1 copy-constructor invalid");

        time1.setHour(1);

        if(time1.equals(copy_time1))
            System.out.println("Err : Time1 copy-constructor aliasing");

        Time2 copy_time2 = new Time2(time2);
        if(!time2.equals(copy_time2))
            System.out.println("Err : Time2 copy-constructor invalid");

        time2.setHour(1);

        if(time2.equals(copy_time2))
            System.out.println("Err : Time2 copy-constructor aliasing");

    }
    private static void CheckTimeToString(){
        if(!time1_3.toString().equals("01:23:05"))
            System.out.println("Err : Issue with Time1.toString() method");
    }
    private static void CheckBefore(){
        if(time1_2.before(time1_3))
            System.out.println("Err : Issue with Time1.before() method");
    }
    private static void CheckAfter(){
        Time1 copy_time = new Time1(time1_2);
        if(time1_2.after(copy_time))
            System.out.println("Err : Issue with Time1.after() method - return true when equals");
    }

    //Time2 class checks (make sure you did calculations right)
    private static void CheckTime2(){
        Time2 c_time = new Time2(1,1,1);
        if(c_time.getHour() != 1 || c_time.getMinute() != 1 || c_time.getSecond() != 1)
            System.out.println("Err : Issue with Time2 set/construct methods");

        c_time.setHour(3);
        if(c_time.getHour() != 3)
            System.out.println("Err : Issue with Time2 set/get hour method");

        c_time.setMinute(7);
        if(c_time.getMinute() != 7)
            System.out.println("Err : Issue with Time2 set/get minute method");

        c_time.setSecond(17);
        if(c_time.getSecond() != 17)
            System.out.println("Err : Issue with Time2 set/get second method");
    }
}
