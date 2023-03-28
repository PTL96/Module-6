public class Test {

    public static void main(String[] args) {
        int soThuNhat = 0;
        int soThuHai = 1;
        int soThuN;
        for (int i = 0; i < 100; i++) {
            soThuN = soThuNhat + soThuHai;
            soThuNhat = soThuHai;
            soThuHai = soThuN;
        }
        System.out.println(soThuNhat);
    }
}
