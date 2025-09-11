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
    public static void draw(){
        System.out.println("\n\n\n\n\n\n\n\n "+spot(1)+" | "+spot(2)+" | "+spot(3)+" \n---+---+---\n "+spot(4)+" | "+spot(5)+" | "+spot(6)+"\n---+---+---\n "+spot(7)+" | "+spot(8)+" | "+spot(9));
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
            for(int[] c:wins){
                if(board[c[0]]==board[c[1]] && board[c[1]]==board[c[2]] && board[c[0]]!=0){
                    draw();
                    if (board[c[0]] == 1){
                        System.out.println("X WINS!");

                    }else{
                        System.out.println("O WINS!");


                    }
                    board = new int[9];
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
