public class snt {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        int sum = 0;
        while (count < 20) {
            boolean SNT = true;
            for (int i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    SNT = false;
                    break;
                }
            }
            if (SNT) {
                sum += number;
                count++;
            }
            number++;
        }
        System.out.println(sum);
    }
}
