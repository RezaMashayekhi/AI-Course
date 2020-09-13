
import java.util.LinkedList;
import java.util.Scanner;


class Board{
    char[][] board;
    Board(int r, int c){
        board=new char[r][c];
    }
}
class Tic{
    
    static char[][] bestmove;
    public static int minimax(char[][] state, boolean ismax){
        int u=utility(state);
        if (u!=-2)               // agar bazi edame nadasht (terminal)
            return u;
        LinkedList<Board> successor= fsuccessor(state, ismax);

        if(ismax){
            int m=-2;
            int index=0;
            for(int i=0;i<successor.size();i++){
                int mm=minimax(successor.get(i).board,false);
                if(mm>m){
                    m=mm;
                    index=i;
                }
                
                    
            }
            bestmove=copy(successor.get(index).board);
            return m;
        }
        else{
            int m=2;
            int index=0;
            for(int i=0;i<successor.size();i++){
                int mm=minimax(successor.get(i).board,true);
                if(mm<m){
                    m=mm;
                    index=i;
                }
                
                    
            }
            bestmove=copy(successor.get(index).board);
            return m;
        }
        
    }
    
    public static int utility(char [][] state){
        for(int i=0;i<3;i++){
            if (state[i][0]==state[i][1] && state[i][1]==state[i][2])
                if (state[i][0]=='o')
                    return 1;
                else if(state[i][0]=='x')
                    return -1;
        }
        
        for(int j=0;j<3;j++){
            if (state[0][j]==state[1][j] && state[1][j]==state[2][j])
                if (state[0][j]=='o')
                    return 1;
                else if(state[0][j]=='x')
                    return -1;
        }
        
        if(state[0][0]==state[1][1] && state[1][1]==state[2][2])
            if (state[0][0]=='o')
                return 1;
            else if(state[0][0]=='x')
                return -1;
        
        if(state[0][2]==state[1][1] && state[1][1]==state[2][0])
            if (state[0][2]=='o')
                return 1;
            else if(state[0][2]=='x')
                return -1;
        
        for(int i=0;i<3;i++)
            for(int j=0;j<2;j++)
                if(state[i][j]==0)
                    return -2;                  // yani bazi edame darad
        
        return 0;
    }
    
    public static LinkedList<Board> fsuccessor(char [][] state,  boolean ismax){
        LinkedList<Board> successor= new LinkedList(); 
        
        if(ismax){
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    if(state[i][j]==0){
                        Board a=new Board(3,3);
                        a.board=copy(state);
                        a.board[i][j]='o';

                        successor.add(a);
                        
                    }
                }
        }
        else{  
            
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++){
                    if(state[i][j]==0){
                        Board a=new Board(3,3);
                        a.board=copy(state);
                        a.board[i][j]='x';
                        successor.add(a);
                        
                    }
                }
        }
        
        return successor;
    }
    
    public static char[][] copy(char[][] a){
        char[][] b=new char[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++){
                b[i][j]=a[i][j];
            }
        return b;
    }
    
    public static void print(char[][] a){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]!=0)
                    System.out.print(a[i][j]);
                else
                    System.out.print("*");
            }
            System.out.println("");
        }

    }
    
}



public class A {
    public static void main(String args[]){
        Scanner var=new Scanner (System.in);
        Board a = new Board(3,3);
        /*char[][] g={{'o','\0','x'},
                    {'x','\0','x'},
                    {'\0','o','o'}};*/
        System.out.println("shoma bazikone o shoroo konandeye bazi hastin. satr ha va sotoon az 0 shomaregozari shodand. bala samte chap derayeye 0,0 hast");
        while(true){
            System.out.println("o turn");
            System.out.println("satr");
            int r=var.nextInt();
            System.out.println("sotoon");
            int c=var.nextInt();
            /*System.out.println("x ya o ");
            String xo=var.next();*/
            a.board[r][c]='o';
            Tic.print(a.board);
            if(Tic.utility(a.board)!=-2){
                int u=Tic.utility(a.board);
                if(u==-1)
                    System.out.println("x bord");
                if(u==1)
                    System.out.println("o bord");
                if(u==0)
                    System.out.println("Tasavi");
                break;
            }
            
            System.out.println("x turn");
            Tic.minimax(a.board, false);
            a.board=Tic.copy(Tic.bestmove);
            Tic.print(a.board);
            if(Tic.utility(a.board)!=-2){
                int u=Tic.utility(a.board);
                if(u==-1)
                    System.out.println("x bord");
                if(u==1)
                    System.out.println("o bord");
                if(u==0)
                    System.out.println("Tasavi");
                break;
            }
        }
        
        //System.out.println(Tic.minimax(g, true));
        
    }
}
