import java.util.*;
public class Tictactoe {
    static ArrayList<Integer> player1_pos=new ArrayList<>();
    static ArrayList<Integer> player2_pos=new ArrayList<>();
    public static void main(String args[]){
        char[][] board={
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '},
            {'-','+','-','+','-'},
            {' ','|',' ','|',' '}
        };
        printboard(board);
        String p1="player1";
        String p2="player2";
        while(true){
            Scanner input=new Scanner(System.in);
            System.out.println(p1+" choose your position-(1 to 9)");
            int p1_pos=input.nextInt();
            while(player1_pos.contains(p1_pos)||player2_pos.contains(p1_pos)){
                System.out.println("enter correct position tis position is alredy taken");
                p1_pos=input.nextInt();
            }
            placepiece(board, p1_pos, p1);
            printboard(board);
            String result=winning();
            System.out.println(result);
        
            System.out.println(p2+" choose your position-(1 to 9)");
            int p2_pos=input.nextInt();
            while(player1_pos.contains(p2_pos)||player2_pos.contains(p2_pos)){
                System.out.println("enter correct position tis position is alredy taken");
                p2_pos=input.nextInt();
            }    
            placepiece(board, p2_pos, p2);

            printboard(board);

            result=winning();
            System.out.println(result);
        }
    }
    public static void printboard(char[][] board){
        for(char[] r:board){
            for(char s:r){
                System.out.print(s);
            }
            System.out.println();
        }
    }
    public static void placepiece(char[][] board , int pos,String user){
        char symbol=' ';
        if(user.equals("player1")){
            symbol='o';
            player1_pos.add(pos);
        }else{
            symbol='x';
            player2_pos.add(pos);
        }
        switch(pos){
            case 1:
                board[0][0]=symbol;
                break;
            case 2:
                board[0][2]=symbol;
                break;
            case 3:
                board[0][4]=symbol;
                break;
            case 4:
                board[2][0]=symbol;
                break;
            case 5:
                board[2][2]=symbol;
                break;
            case 6:
                board[2][4]=symbol;
                break;
            case 7:
                board[4][0]=symbol;
                break;
            case 8:
                board[4][2]=symbol;
                break;
            case 9:
                board[4][4]=symbol;
                break;
            default:
                break;   
        }
    }
    public static String winning(){
        List<Integer> toprow=Arrays.asList(1,2,3);
        List<Integer> midrow=Arrays.asList(4,5,6);
        List<Integer> lostrow=Arrays.asList(7,8,9);
        List<Integer> firstcol=Arrays.asList(1,4,7);
        List<Integer> secondcol=Arrays.asList(2,5,8);
        List<Integer> thirdcol=Arrays.asList(3,6,9);
        List<Integer> cross1=Arrays.asList(1,5,9);
        List<Integer> cross2=Arrays.asList(7,5,3);
        
        List<List> winningcon=new ArrayList<List>();
        winningcon.add(toprow);
        winningcon.add(midrow);
        winningcon.add(lostrow);
        winningcon.add(firstcol);
        winningcon.add(secondcol);
        winningcon.add(thirdcol);
        winningcon.add(cross1);
        winningcon.add(cross2);

        for(List l:winningcon){
            if(player1_pos.containsAll(l)){
                return "Player1 win the game";
            }else if(player2_pos.containsAll(l)){
                return "player2 win the game";
            }else if(player1_pos.size()+player2_pos.size()==9){
                return "Tie!";
            }
        }
        return " ";
    }
}
