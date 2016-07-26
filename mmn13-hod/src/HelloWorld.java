public class HelloWorld{

     public static void main(String []args){
         /*
        Time1 time = new Time1 (10,0,0);
        Time1 time1 = new Time1 (9,40,0);
        Time1 time2 = new Time1 (9,30,0);
        Time1 time3 = new Time1 (10,30,0);
        BusStopList a = new BusStopList ();
        a.add(1,1,time);
        a.add(1,2,time1);
        a.add(2,2,time2);
        a.add(2,3,time3);
        System.out.println("Average: " +a.getAverageTime());
        System.out.println("Popular: " +a.getPopularLine());
        a.add(1,3,time);
        a.add(3,3,time);
        System.out.print(a);
        System.out.println("Popular: " +a.getPopularLine());
        System.out.println("Total: " +a.totalPassengers());
        System.out.println("Max: " + a.maxPassengers());
        a.removeAllLine(4);
        System.out.println("after remove 4");
        a.removeAllLine(100);
        System.out.println("after remove 100");
        System.out.print(a);
        a.removeAllLine(2);
        System.out.println("after remove 2");
        System.out.print(a);
        a.removeAllLine(1);
        System.out.println("after remove 1");
        System.out.print(a);
        
        BusArrival b = new BusArrival (4,5,time);
        */
        
        //Tester
        
        /*
        BusStopList b1 = new BusStopList();
        Time1 t1 = new Time1 (10,5,24);
        Time1 t2 = new Time1 (9,5,5);
        Time1 t3 = new Time1 (8,0,5);
        Time1 t4 = new Time1 (7,0,5);
        b1.add(4,25,t1);
        b1.add(2,20,t2);
        b1.add(5,30,t3);
        b1.add(5,10,t4);
        b1.add(3,40,t2);
        b1.add(2,30,t3);
        b1.add(5,55,t3);
        System.out.print (b1);
        System.out.println ("average time = " + b1.getAverageTime());
        System.out.println ("popular line = " + b1.getPopularLine());
        System.out.println ("bus with max passengers");
        System.out.println (b1.maxPassengers());
        System.out.println ("total passengers = " + b1.totalPassengers());
        System.out.println ("printing BusList");
        System.out.print (b1);
        b1.removeAllLine(5);
        System.out.println ("removing lines");
        System.out.print (b1);
        System.out.println ("average time = " + b1.getAverageTime());
        System.out.println ("popular line = " + b1.getPopularLine());
        System.out.println ("bus with max passengers");
        System.out.println (b1.maxPassengers());
        System.out.println ("total passengers = " + b1.totalPassengers());
        System.out.println ("Adding additional busses to the BusList.");
        b1.add(11,25,t1);
        b1.add(22,20,t2);
        b1.add(33,30,t3);
        b1.add(44,10,t4);
        System.out.println ("Printing BusList: ");
        System.out.println (b1.toString());
        b1.removeAllLine(2);
        System.out.println ("Printing BusList: ");
        System.out.println (b1.toString());
        System.out.println ("popular line = " + b1.getPopularLine());
        System.out.println ("popular line can be also 4 depend on how you did the method");
        System.out.println ("Cheers!");
        */
        //Tester2
        BusStopList bs = new BusStopList();

        System.out.println("Creating 6 times.");
        Time1 t1 = new Time1(11,11,11);
        Time1 t2 = new Time1(12,12,12);
        Time1 t3 = new Time1(6,6,6);
        Time1 t4 = new Time1(2,23,21);
        Time1 t5 = new Time1(2,23,20);
        Time1 t6 = new Time1(23,59,59);

        System.out.println("\n Adding 5 objects to the List:");
        System.out.println("Object 1 expected result (true) : " + bs.add(68,1000,t1)); 
        System.out.println("Object 2 expected result (true) : " + bs.add(905,-5,t2)); 
        System.out.println("Object 3 expected result (true) : " + bs.add(68,10,t3)); 
        System.out.println("Object 4 expected result (true) : " + bs.add(68,70,t4)); 
        System.out.println("Object 5 expected result (true) : " + bs.add(6,500,t5)); 
        System.out.println(" \n ");

        System.out.println("Printing the objects List:");
        System.out.println(bs.toString()); //hod System.out.println(bs);
        System.out.println("Expected results: ");
        System.out.println("Bus no. 68 arrived at 11:11:11 with 0 passengers");
        System.out.println("Bus no. 1 arrived at 12:12:12 with 0 passengers");
        System.out.println("Bus no. 68 arrived at 06:06:06 with 10 passengers");
        System.out.println("Bus no. 68 arrived at 02:23:21 with 70 passengers");
        System.out.println("Bus no. 6 arrived at 02:23:20 with 0 passengers");
        System.out.println(" \n ");

        System.out.print("Printing average waiting time. Expected result: 8833 seconds (147 minutes). \n Actual results: ");
        System.out.println(bs.getAverageTime() + " seconds which is " + bs.getAverageTime() / 60 + " minutes.");

        System.out.println(" Popular Line. Expected: 68. Actual result: " + bs.getPopularLine() );

        System.out.println(" Bus with maximum passengers. Expected: Bus no. 68 arrived at 02:23:21 with 70 passengers\nActual: " + bs.maxPassengers() );

        System.out.println(" \n Remove line 68 from the List.");
        bs.removeAllLine(68);

        System.out.println("Print the List after the removal."); 
        System.out.println(bs);

        System.out.println("  Popular line. Expected: 6. Actual: " + bs.getPopularLine());

        System.out.println(" \n Remove line 6 from the List.");
        bs.removeAllLine(6);

        System.out.println("Print the List after the removal."); 
        System.out.println(bs.toString());

        System.out.println(" Remove line 1 from the List.");
        bs.removeAllLine(1);

        System.out.println(" Print the List after the removal. There should be null output (and hopefully no crash)"); 
        System.out.println(bs); 

     }
}
