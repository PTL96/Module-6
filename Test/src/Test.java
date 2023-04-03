public class Test {
    void readCard(int cardNo) throws Exception{
        System.out.println("Reading Card");
    }
    void checkCard(int cardNo) throws RuntimeException{   //line 1
        System.out.println("Checking Card");
    }
    public static void main(String[] args){
        Test ex = new Test();
        int cardNo = 12344;
        ex.checkCard(cardNo); //line 2
        ex.readCard(cardNo); //line 3


















//    void readCard(int cardNo) throws Exception {
//        System.out.println("Reading Card");
//    }
//
//    void checkCard(int cardNo) throws RuntimeException {   //line 1
//        System.out.println("Checking Card");
//    }
//
//    public static void main(String[] args) {
//        Test ex = new Test();
//        int cardNo = 12344;
//        try {
//            ex.readCard(cardNo); //line 3
//
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        ex.checkCard(cardNo); //line 2
//
    }
}
