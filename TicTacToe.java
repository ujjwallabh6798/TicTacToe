import java.util.Scanner;

public class TicTacToe {

    private player player1, player2;
    private Board board;
    private int numPlayers;
    public static void main(String[] args) {
        TicTacToe t =new TicTacToe();
        t.startGame();
    }

    public void startGame(){
        Scanner s = new Scanner(System.in);
        //take player input
        player1=takePlayerInput(++numPlayers);
        player2=takePlayerInput(++numPlayers);
        //check for that if the both player have same symbol
        while(player1.getSymbol()==player2.getSymbol()){
            System.out.println("Symbol is already taken please enter another symbol again");
            player2.setSymbol(s.next().charAt(0));
        }
        //create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        //play the game
        boolean player1Turn=true;
        int status=Board.INCOMPLETE;
        while(status==Board.INCOMPLETE || status==Board.INVALIDMOVE){
            // Scanner s = new Scanner(System.in);
            if(player1Turn){
                System.out.println("Player 1 - " + player1.getName() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();

                status=board.move(player1.getSymbol(),x,y);

                if(status==Board.INVALIDMOVE){
                    System.out.println("Invalid move !!! PLease Try Again!!!");
                    continue;
                }
                //else{
                //     player1Turn=false;
                //     board.print();
                // }
            }else{
                System.out.println("Player 2 - " + player2.getName() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();

                status=board.move(player2.getSymbol(),x,y);

                if(status==Board.INVALIDMOVE){
                    System.out.println("Invalid move !!! PLease Try Again!!!");
                    continue;
                }
                //else{
                //     player1Turn=true;
                //     board.print();
                // }
            }
            player1Turn = !player1Turn;
            board.print();
        }
        if(status==Board.PLAYER1WINS){
            System.out.println("player 1- "+ player1.getName() + "wins !!");
        }else if(status==Board.PLAYER2WINS){
            System.out.println("player 2- "+ player2.getName() + "wins !!");
        }else{
            System.out.println("DRAW!!!");
        }
        s.close();
   }

   private player takePlayerInput(int num){
    Scanner s = new Scanner(System.in);
    System.out.println("Enter Player" + num + " name: ");
    String name=s.nextLine();
    System.out.println("Enter Player" + num + " symbol: ");
    char symbol = s.next().charAt(0);
    player p = new player(name, symbol);
    return p;
    // s.close();
    }
}
