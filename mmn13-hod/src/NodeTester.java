
public class NodeTester {
    public static void main(String[] args) {

        nullConstructor();
        checkAliasing();
        copyCheck();
    }

    public static void nullConstructor() {
        try {
            BusArrivalNode node = new BusArrivalNode((BusArrival) null);
        } catch (NullPointerException e) {
            System.out.println("[public BusArrivalNode(BusArrival b)] Constructor doesn\'t handle well when entering null values");
        }
        try {
            BusArrivalNode node = new BusArrivalNode(null, null);
        } catch (NullPointerException e) {
            System.out.println("[public BusArrivalNode(BusArrival b, BusArrivalNode n)] Constructor doesn\'t handle well when entering null values");
        }

        try {
            BusArrivalNode node = new BusArrivalNode((BusArrivalNode) null);
        } catch (NullPointerException e) {
            System.out.println("[public BusArrivalNode(BusArrivalNode b)] Constructor doesn\'t handle well when entering null values");
        }
        try {
            BusArrivalNode node = new BusArrivalNode((BusArrivalNode) null);
            node.setBusArr(null);
        } catch (NullPointerException e) {
            System.out.println("setBusArr() method doesn't handle the case when the BusArrival is null");
        }

    }

    public static void checkAliasing() {
        BusArrival bus = new BusArrival(1,1,1,1,1);
        BusArrivalNode node = new BusArrivalNode(bus);
        bus.setLineNum(2);
        if(node.getBusArr().getLineNum() == 2 ){
            System.out.println("Constructor committing aliasing");
        }
        if(node.getBusArr() == node.getBusArr()){
            System.out.println("getBusArr() method committing aliasing");
        }
    }
    public static void copyCheck(){
        BusArrival bus = new BusArrival(1,1,1,1,1);
        BusArrival bus2 = new BusArrival(2,2,2,2,2);
        BusArrivalNode node = new BusArrivalNode(bus);
        node.setNext(new BusArrivalNode(bus2));

        BusArrivalNode node2 = new BusArrivalNode(node);
        if(node2 == node || node.getBusArr() == node2.getBusArr()){
            System.out.println("copy constructor committing aliasing");
        }
        if(node.getNext() != node2.getNext()){
            System.out.println("copy constructor doesn't commit aliasing on the 'next' attribute");
        }
        if(!node.getBusArr().equals(node2.getBusArr()) || !node.getNext().getBusArr().equals(node2.getNext().getBusArr())){
            System.out.println("copy constructor didn't copy the object well (the values doesn't match)");
        }
    }
}
