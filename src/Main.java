public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int[] board = new int[9];
    public static String spot(int i){
        if (board[i-1] == 0){
            return ""+i;
        }else if (board[i-1] == 1){
            return "X";
        }else{
            return "O";
        }
    }
    public static void draw(){
        System.out.println(" "+spot(1)+" | "+spot(2)+" | "+spot(3)+" \n---+---+---\n "+spot(4)+" | "+spot(5)+" | "+spot(6)+"\n---+---+---\n "+spot(7)+" | "+spot(8)+" | "+spot(9));
    }
    public static void main(String[] args) {
        boolean xturn = true;
        while(true){
            draw();
            if(xturn){
                System.out.print("X, ");
            }else{
                System.out.print("O, ");
            }
            System.out.print("Enter board pos: ");
            int n = sc.nextInt();
            while (n < 1 || n > 9 || board[n-1] != 0){
                System.out.print("Invalid, enter board pos: ");
                n = sc.nextInt();
            }
            if(xturn){
                board[n-1] = 1;
            }else{
                board[n-1] = 2;
            }
            xturn = !xturn;
        }
    }
}