import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int[] board = new int[9];
    public static int[][] wins = {
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };
    public static String spot(int i){
        if (board[i-1] == 0){
            return ""+i;
        }else if (board[i-1] == 1){
            return "X";
        }else{
            return "O";
        }
    }
    public static void draw() {
        System.out.println("\n\n\n\n\n\n\n\n " + spot(1) + " | " + spot(2) + " | " + spot(3) + " \n---+---+---\n " + spot(4) + " | " + spot(5) + " | " + spot(6) + "\n---+---+---\n " + spot(7) + " | " + spot(8) + " | " + spot(9));
    }
    public static int ply(){
        System.out.print("Enter board pos: ");
        int n = sc.nextInt();
        while (n < 1 || n > 9 || board[n-1] != 0){
            System.out.print("Invalid, enter board pos: ");
            n = sc.nextInt();
        }
        return n;
    }
    public static int botF(int x, int ply){
        int free = 0;
        for(int[] c:wins){
            int amt = 0;
            boolean flag = false;
            for(int i:c){
                if(board[i] == ply){
                    if(amt < 0 || flag){
                        amt = 0;
                        flag = true;
                    }else{
                        amt++;
                    }
                }else if(board[i] == 0) {
                    free = i;
                }else{
                    if(amt > 0 || flag){
                        amt = 0;
                        flag = true;
                    }else{
                        amt--;
                    }
                }
            }
            if(amt == x){
                return free;
            }
        }
        return -free;
    }
    public static int bot(int ply){
        int x = botF(2,ply);
        if (x > 0){
            return x;
        }
        return Math.abs(botF(-2,ply));
    }
    public static void main(String[] args) {
        boolean ended = true;
        boolean xturn = true;
        boolean xbot = false;
        boolean obot = false;
        while(true){
            if(ended){
               ended = false;

               System.out.print("IS X A BOT? (Y/N): ");
               while (true){
                   String s = sc.nextLine();
                   if (s.equals("Y")){
                       xbot = true;
                       break;
                   }else if(s.equals("N")){
                       xbot = false;
                       break;
                   }
               }

               System.out.print("IS O A BOT? (Y/N): ");
                while (true){
                    String s = sc.nextLine();
                    if (s.equals("Y")){
                        obot = true;
                        break;
                    }else if(s.equals("N")){
                        obot = false;
                        break;
                    }
                }
            }
            draw();
            if(xturn){
                System.out.print("X, ");
            }else{
                System.out.print("O, ");
            }
            int n;
            if(xturn){
                if(xbot){
                    board[bot(1)] = 1;
                }else {
                    board[ply()-1] = 1;
                }
            }else{
                if(obot){
                    board[bot(2)] = 2;
                }else {
                    board[ply()-1] = 2;
                }
            }
            for(int[] c:wins){
                if(board[c[0]]==board[c[1]] && board[c[1]]==board[c[2]] && board[c[0]]!=0){
                    draw();
                    if (board[c[0]] == 1){
                        System.out.println("X WINS!");


                    }else{
                        System.out.println("O WINS!");

                    }
                    board = new int[9];
                    ended = true;
                    xturn = false;
                    System.out.print("Enter 1 to continue.");
                    sc.nextInt();
                }
            }
            for(int i = 0; i < 10; i++){
                if(i == 9){
                    draw();
                    System.out.println("ITS A DRAW!");
                    board = new int[9];
                    xturn = false;
                    System.out.print("Enter 1 to continue.");
                    sc.nextInt();
                }else{
                    if (board[i] == 0){
                        break;
                    }
                }
            }
            xturn = !xturn;
        }

    }
}