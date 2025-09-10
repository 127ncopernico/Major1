public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int[] board = new int[9];
    public static void main(String[] args) {
        boolean xturn = true;
        while(true){
            if(xturn){
                System.out.print("X, ");
            }else{
                System.out.print("O, ");
            }
            System.out.print("Enter board pos: ");
            int n = sc.nextInt();
            while (n < 1 || n > 9 || board[n] != 0){
                System.out.print("Invalid, enter board pos: ");
                n = sc.nextInt();
            }
            if(xturn){
                board[n] = 1;
            }else{
                board[n] = 2;
            }
            xturn = !xturn;
        }
    }
}