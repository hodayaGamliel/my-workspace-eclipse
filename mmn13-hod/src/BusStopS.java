public class BusStopS
{
    public static void main(String[] args)
    {
        int num = 2000;
        BusStop test = new BusStop (num);
        BusArrival[] testB = test.getBuses();
        if (testB.length > 1000)
        {      
            System.out.println("ERROR: BusStop maximun array length is 1000 !!!" + testB[num+1]);
        }
        System.out.println("Creating a new 5 objects array.");
        BusStop bs = new BusStop(5);

        System.out.println("Creating 6 times.");
        Time1 t1 = new Time1(11,11,11);
        Time1 t2 = new Time1(12,12,12);
        Time1 t3 = new Time1(6,6,6);
        Time1 t4 = new Time1(2,23,21);
        Time1 t5 = new Time1(2,23,20);
        Time1 t6 = new Time1(23,59,59);

        System.out.println("\n Adding 8 objects to the array:");
        System.out.println("Object 1 expected result (true) : " + bs.add(68,1000,t1)); 
        System.out.println("Object 2 expected result (true) : " + bs.add(905,-5,t2)); 
        System.out.println("Object 3 expected result (true) : " + bs.add(68,10,t3)); 
        System.out.println("Object 4 expected result (true) : " + bs.add(68,70,t4)); 
        System.out.println("Object 5 expected result (true) : " + bs.add(6,500,t5)); 
        System.out.println("Object 6 expected result (false) : " + bs.add(6,10,t6)); 
        System.out.println("Object 7 expected result (false) : " + bs.add(4,12,t1)); 
        System.out.println("Object 8 expected result (false) : " + bs.add(68,18,t2)); 
        System.out.println(" \n ");

        System.out.println("Printing the 5 objects array:");
        System.out.println(bs);
        System.out.println("Expected results: ");
        System.out.println("Bus no. 68 arrived at 11:11:11 with 0 passengers");
        System.out.println("Bus no. 1 arrived at 12:12:12 with 0 passengers");
        System.out.println("Bus no. 68 arrived at 06:06:06 with 10 passengers");
        System.out.println("Bus no. 68 arrived at 02:23:21 with 70 passengers");
        System.out.println("Bus no. 6 arrived at 02:23:20 with 0 passengers");
        System.out.println(" \n ");

        System.out.print("Printing average waiting time. Expected result: 8833 seconds (147 minutes). \n Actual results: ");
        System.out.println(bs.getAverageTime() + " seconds which is " + bs.getAverageTime() / 60 + " minutes.");

        // Check this out! 

        BusArrival[] bsCopy = bs.getBuses();
        System.out.println(" Just making sure the getBuses() method works. You should see 5 bus objects with time. ");

        for (int i = 0 ; i < bsCopy.length ; i++)
            System.out.println( bsCopy[i] );

        /*       System.out.println(" The actual number of busses in the array. Expected: 5. Actual: " + bs.getNoOfBuses() );

        System.out.println(" Popular Line. Expected: 68. Actual result: " + bs.getPopularLine() );

        System.out.println(" Bus with maximum passengers. Expected: Bus no. 68 arrived at 02:23:21 with 70 passengers\nActual: " + bs.maxPassengers() );

        System.out.println(" \n Remove line 68 from the array.");
        bs.removeAllLine(68);

        System.out.println("Print the array after the removal."); 
        System.out.println(bs);

        System.out.println("  Popular line. Expected: 6. Actual: " + bs.getPopularLine());

        System.out.println(" \n Remove line 6 from the array.");
        bs.removeAllLine(6);

        System.out.println("Print the array after the removal."); 
        System.out.println(bs);

        System.out.println(" Remove line 1 from the array.");
        bs.removeAllLine(1);

        System.out.println(" Print the array after the removal. There should be no output (and hopefully no crash)"); 
        System.out.println(bs); 

        //Aliasing testing 
        System.out.println("Aliasing Test");

        BusStop stop = new BusStop(3);
        Time1 t8 = new Time1(1, 1, 1);
        Time1 t9 = new Time1(2, 2, 2);
        Time1 t10 = new Time1(3, 3, 3);

        //Checking add method.
        stop.add(1, 1, t8);
        t8.setHour(5);
        System.out.println("If u get Bus no. 1 arrived at 05:01:01 with 1 passengers here- u fail:) \nActual:"  + stop);

        //Checking getBuses method.
        BusArrival[] stopArr = stop.getBuses();
        stopArr[0].setLineNum(5);
        System.out.println("If u get Bus no. 5 arrived at 01:01:01 with 1 passengers, but means the same.. \nActual: " + stop);

        System.out.print("Note: In the add method, The problem might also" +
        "\ncome from the BusArrival or even the Time1 Classes."+
        "\nSo if you use your own Classes check your grades for them first:)");
         */
    } // End of Main
} // End of Class