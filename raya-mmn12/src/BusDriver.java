
public class BusDriver {
    public static void main(String[] args) {
        CheckFull();
        CheckToString();
        CheckElapsedTime();
        Check_aliasing();
        Check_fuller();
    }

    private static void CheckFull(){
        BusArrival bus = new BusArrival(1,70,1,1,1);
        if(!bus.isFull())
            System.out.println("Err : isFull method return false when bus is full");

        bus.setNoOfPass(69);
        if(bus.isFull())
            System.out.println("Err : isFull method return true when bus isn't full");
    }
    private static void CheckToString(){
        BusArrival bus = new BusArrival(27,13,9,24,10);
        if(!bus.toString().equals("Bus no. 27 arrived at 09:24:10 with 13 passengers"))
            System.out.println("Err : toString method return wrong output - check whitespaces");
    }
    private static void CheckElapsedTime(){
        BusArrival bus = new BusArrival(27,13,9,24,10);
        BusArrival bus2 = new BusArrival(27,13,8,25,15);
        if(bus.elapsedTime(bus2) != 58 || bus2.elapsedTime(bus) != 58)
            System.out.println("Err : elapsedTime method return wrong value");
        if(bus.elapsedTime(bus) != 0)//useless but still
            System.out.println("Err : elapsedTime method doesn't calculate right.");
    }
    private static void Check_aliasing(){
        BusArrival bus = new BusArrival(27,13,9,24,10);
        BusArrival bus_copy1 = new BusArrival(bus);
        BusArrival bus_copy2 = new BusArrival(bus);
        Time1 time = new Time1(1,1,1);
        if(!bus.equals(bus_copy1) || !bus_copy1.equals(bus_copy2))
            System.out.println("Err : BusArrival constructor doesn't copy well the values");

        bus_copy1.setNoOfPass(1);
        if(bus.equals(bus_copy1))
            System.out.println("Err : BusArrival constructor aliasing NoOfPass attribute");

        bus.setArrivalTime(time);
        if(bus.equals(bus_copy2))
            System.out.println("Err : BusArrival constructor aliasing Time1 _arrivalTime");

        time.setHour(2);
        if(time.equals(bus.getArrivalTime()))
            System.out.println("Err : BusArrival setArrivalTime aliasing Time1 _arrivalTime");
    }
    private static void Check_fuller(){
        BusArrival bus = new BusArrival(27,13,9,24,10);
        BusArrival bus2 = new BusArrival(27,13,9,24,10);
        if(bus.fuller(bus2))
            System.out.println("Err : BusArrival fuller method return true when equals");
        bus.setNoOfPass(1);
        if(bus.fuller(bus2))
            System.out.println("Err : BusArrival fuller method return true when instance is smaller then 'other'");
    }

}
