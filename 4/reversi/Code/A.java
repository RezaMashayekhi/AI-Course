
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
    
    public static int minimax(char[][] state, boolean ismax, int c){
        if(c==0){
            return 0;
        }
        LinkedList<Board> successor= fsuccessor(state, ismax);
        int u=utility(state,ismax,successor.size());
        if (u!=-2)               // agar bazi edame nadasht (terminal)
            return u;
        
        if(successor.size()!=0){
            if(ismax){
                int m=-2;
                int index=0;
                for(int i=0;i<successor.size();i++){
                    c--;
                    int mm=minimax(successor.get(i).board,false,c);
                    if(mm>m){
                        m=mm;
                        index=i;
                        if(m>=0)
                            break;
                    }
                }
                bestmove=copy(successor.get(index).board);
                return m;
            }
            
            else{
                int m=2;
                int index=0;
                for(int i=0;i<successor.size();i++){
                    c--;
                    int mm=minimax(successor.get(i).board,true, c);
                    if(mm<m){
                        m=mm;
                        index=i;
                        if(m<=0)
                            break;
                    }


                }
                bestmove=copy(successor.get(index).board);
                return m;
            }
        }
        c--;
        return minimax(state,!ismax,c);    
    }
    
    public static int utility(char [][] state, boolean ismax, int size){
        if(size==0 && fsuccessor(state, !ismax).size()==0){
            int blue=0;
            int red=0;
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++){
                    if(state[i][j]=='b')
                        blue++;
                    if(state[i][j]=='r')
                        red++;
                }
            if(red>=blue)
                return -1;
            if (blue==red)
                return 0;
            else
                return 1;
        }
        else{
            return -2;      // edame darad
        }
    }
    
    public static LinkedList<Board> fsuccessor(char [][] state,  boolean ismax){
        LinkedList<Board> successor= new LinkedList(); 
        
        if(ismax){
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++){
                    if(state[i][j]==0){
                        Board a=new Board(8,8);
                        a.board=copy(state);
                        Boolean f=false;
                        
                        if(i-2>=0 && j-2>=0 && state[i-1][j-1]=='r'){
                            int ii=i-2;
                            int jj=j-2;
                            while(ii>=0 && jj>=0 && state[ii][jj]=='r'){
                                ii--;
                                jj--;
                            }
                            if(ii>=0 && jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                    jj++;
                                }                          
                            }                   
                        }
                        
                        if(i-2>=0 && j+2<=7 && state[i-1][j+1]=='r'){
                            int ii=i-2;
                            int jj=j+2;
                            while(ii>=0 && jj<=7 && state[ii][jj]=='r'){
                                ii--;
                                jj++;
                            }
                            if(ii>=0 && jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                    jj--;
                                }                               
                            }                   
                        }
                        
                        if(i+2<=7 && j+2<=7 && state[i+1][j+1]=='r'){
                            int ii=i+2;
                            int jj=j+2;
                            while(ii<=7 && jj<=7 && state[ii][jj]=='r'){
                                ii++;
                                jj++;
                            }
                            if(ii<=7 && jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='b';
                                    jj--;
                                }                             
                            }                   
                        }
                        
                        if(i+2<=7 && j-2>=0 && state[i+1][j-1]=='r'){
                            int ii=i+2;
                            int jj=j-2;
                            while(ii<=7 && jj>=0 && state[ii][jj]=='r'){
                                ii++;
                                jj--;
                            }
                            if(ii<=7 && jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){
                                    a.board[ii][jj]='b';
                                    jj++;
                                }                              
                            }                   
                        }
                        
                        if(j-2>=0 && state[i][j-1]=='r'){
                            int ii=i;
                            int jj=j-2;
                            while(jj>=0 && state[ii][jj]=='r'){
                                jj--;
                            }
                            if(jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(jj=jj;jj<=j;jj++){               
                                    a.board[ii][jj]='b';
                                }                               
                            }                   
                        }
                        
                        if(j+2<=7 && state[i][j+1]=='r'){
                            int ii=i;
                            int jj=j+2;
                            while(jj<=7 && state[ii][jj]=='r'){
                                jj++;
                            }
                            if(jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(jj=jj;jj>=j;jj--){               
                                    a.board[ii][jj]='b';
                                }                               
                            }                   
                        }
                        
                        if(i-2>=0 && state[i-1][j]=='r'){
                            int ii=i-2;
                            int jj=j;
                            while(ii>=0 && state[ii][jj]=='r'){
                                ii--;
                            }
                            if(ii>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                }                          
                            }                   
                        }
                        
                        if(i+2<=7 && state[i+1][j]=='r'){
                            int ii=i+2;
                            int jj=j;
                            while(ii<=7 && state[ii][jj]=='r'){
                                ii++;
                            }
                            if(ii<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='b';
                                }                             
                            }                   
                        }
                        
                        
                        
                        if(f==true){
                            successor.add(a);
                        }                        
                    }
                }
        }
        
        else{  
            
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++){
                    if(state[i][j]==0){
                        Board a=new Board(8,8);
                        a.board=copy(state);
                        Boolean f=false;
                        
                        if(i-2>=0 && j-2>=0 && state[i-1][j-1]=='b'){
                            int ii=i-2;
                            int jj=j-2;
                            while(ii>=0 && jj>=0 && state[ii][jj]=='b'){
                                ii--;
                                jj--;
                            }
                            if(ii>=0 && jj>=0 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='r';
                                    jj++;
                                }                          
                            }                   
                        }
                        
                        if(i-2>=0 && j+2<=7 && state[i-1][j+1]=='b'){
                            int ii=i-2;
                            int jj=j+2;
                            while(ii>=0 && jj<=7 && state[ii][jj]=='b'){
                                ii--;
                                jj++;
                            }
                            if(ii>=0 && jj<=7 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='r';
                                    jj--;
                                }                               
                            }                   
                        }
                        
                        if(i+2<=7 && j+2<=7 && state[i+1][j+1]=='b'){
                            int ii=i+2;
                            int jj=j+2;
                            while(ii<=7 && jj<=7 && state[ii][jj]=='b'){
                                ii++;
                                jj++;
                            }
                            if(ii<=7 && jj<=7 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='r';
                                    jj--;
                                }                             
                            }                   
                        }
                        
                        if(i+2<=7 && j-2>=0 && state[i+1][j-1]=='b'){
                            int ii=i+2;
                            int jj=j-2;
                            while(ii<=7 && jj>=0 && state[ii][jj]=='b'){
                                ii++;
                                jj--;
                            }
                            if(ii<=7 && jj>=0 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){
                                    a.board[ii][jj]='r';
                                    jj++;
                                }                              
                            }                   
                        }
                        
                        if(j-2>=0 && state[i][j-1]=='b'){
                            int ii=i;
                            int jj=j-2;
                            while(jj>=0 && state[ii][jj]=='b'){
                                jj--;
                            }
                            if(jj>=0 && state[ii][jj]=='r'){  
                                f=true;
                                for(jj=jj;jj<=j;jj++){               
                                    a.board[ii][jj]='r';
                                }                               
                            }                   
                        }
                        
                        if(j+2<=7 && state[i][j+1]=='b'){
                            int ii=i;
                            int jj=j+2;
                            while(jj<=7 && state[ii][jj]=='b'){
                                jj++;
                            }
                            if(jj<=7 && state[ii][jj]=='r'){  
                                f=true;
                                for(jj=jj;jj>=j;jj--){               
                                    a.board[ii][jj]='r';
                                }                               
                            }                   
                        }
                        
                        if(i-2>=0 && state[i-1][j]=='b'){
                            int ii=i-2;
                            int jj=j;
                            while(ii>=0 && state[ii][jj]=='b'){
                                ii--;
                            }
                            if(ii>=0 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='r';
                                }                          
                            }                   
                        }
                        
                        if(i+2<=7 && state[i+1][j]=='b'){
                            int ii=i+2;
                            int jj=j;
                            while(ii<=7 && state[ii][jj]=='b'){
                                ii++;
                            }
                            if(ii<=7 && state[ii][jj]=='r'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='r';
                                }                             
                            }                   
                        }
                        
                        
                        
                        if(f==true){
                            successor.add(a);
                        }                        
                    }
                }
        }
        
        return successor;
    }
    
    public static char[][] copy(char[][] a){
        char[][] b=new char[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                b[i][j]=a[i][j];
            }
        return b;
    }
    
    public static void print(char[][] a){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(a[i][j]!=0)
                    System.out.print(a[i][j]+" ");
                else
                    System.out.print("* ");
            }
            System.out.println("");
        }

    }
    
}



public class A {
    public static char[][] update(char[][] state, int r , int c){
                        Board a=new Board(8,8);
                        a.board=Tic.copy(state);
                        boolean f=false;
                        int i=r;
                        int j=c;
                        if(i-2>=0 && j-2>=0 && state[i-1][j-1]=='r'){
                            int ii=i-2;
                            int jj=j-2;
                            while(ii>=0 && jj>=0 && state[ii][jj]=='r'){
                                ii--;
                                jj--;
                            }
                            if(ii>=0 && jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                    jj++;
                                }                          
                            }                   
                        }
                        
                        if(i-2>=0 && j+2<=7 && state[i-1][j+1]=='r'){
                            int ii=i-2;
                            int jj=j+2;
                            while(ii>=0 && jj<=7 && state[ii][jj]=='r'){
                                ii--;
                                jj++;
                            }
                            if(ii>=0 && jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                    jj--;
                                }                               
                            }                   
                        }
                        
                        if(i+2<=7 && j+2<=7 && state[i+1][j+1]=='r'){
                            int ii=i+2;
                            int jj=j+2;
                            while(ii<=7 && jj<=7 && state[ii][jj]=='r'){
                                ii++;
                                jj++;
                            }
                            if(ii<=7 && jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='b';
                                    jj--;
                                }                             
                            }                   
                        }
                        
                        if(i+2<=7 && j-2>=0 && state[i+1][j-1]=='r'){
                            int ii=i+2;
                            int jj=j-2;
                            while(ii<=7 && jj>=0 && state[ii][jj]=='r'){
                                ii++;
                                jj--;
                            }
                            if(ii<=7 && jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){
                                    a.board[ii][jj]='b';
                                    jj++;
                                }                              
                            }                   
                        }
                        
                        if(j-2>=0 && state[i][j-1]=='r'){
                            int ii=i;
                            int jj=j-2;
                            while(jj>=0 && state[ii][jj]=='r'){
                                jj--;
                            }
                            if(jj>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(jj=jj;jj<=j;jj++){               
                                    a.board[ii][jj]='b';
                                }                               
                            }                   
                        }
                        
                        if(j+2<=7 && state[i][j+1]=='r'){
                            int ii=i;
                            int jj=j+2;
                            while(jj<=7 && state[ii][jj]=='r'){
                                jj++;
                            }
                            if(jj<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(jj=jj;jj>=j;jj--){               
                                    a.board[ii][jj]='b';
                                }                               
                            }                   
                        }
                        
                        if(i-2>=0 && state[i-1][j]=='r'){
                            int ii=i-2;
                            int jj=j;
                            while(ii>=0 && state[ii][jj]=='r'){
                                ii--;
                            }
                            if(ii>=0 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii<=i;ii++){               
                                    a.board[ii][jj]='b';
                                }                          
                            }                   
                        }
                        
                        if(i+2<=7 && state[i+1][j]=='r'){
                            int ii=i+2;
                            int jj=j;
                            while(ii<=7 && state[ii][jj]=='r'){
                                ii++;
                            }
                            if(ii<=7 && state[ii][jj]=='b'){  
                                f=true;
                                for(ii=ii;ii>=i;ii--){               
                                    a.board[ii][jj]='b';
                                }                             
                            }                   
                        }
                        return a.board;
    }
    public static void main(String args[]){
        Scanner var=new Scanner (System.in);
        Board a = new Board(8,8);
        char[][] g={{'\0','\0','\0','\0','\0','\0','\0','\0'},
                      {'\0','\0','\0','\0','\0','\0','\0','\0'},
                      {'\0','\0','\0','\0','\0','\0','\0','\0'},
                      {'\0','\0','\0','b','r','\0','\0','\0'},
                      {'\0','\0','\0','r','b','\0','\0','\0'},
                      {'\0','\0','\0','\0','\0','\0','\0','\0'},
                      {'\0','\0','\0','\0','\0','\0','\0','\0'},
                      {'\0','\0','\0','\0','\0','\0','\0','\0'}};
        a.board=g;
        /*LinkedList <Board> b=Tic.fsuccessor(g, false);
        Tic.print(b.get(3).board);*/
        System.out.println("shoma bazikone b hastin. satr ha va sotoon az 0 shomaregozari shodand. bala samte chap derayeye 0,0 hast");
        Tic.print(a.board);
        int counter=0;      // mikhaham begooyam agar 20 nobat bazi shod tedad maraheli ke dar minimax pish miravad ziad shavad
        int cc=5;           //tedad maraheli ke dar minimax pish miravad
        while(true){
            if(counter==20)
                cc=10;
            System.out.println("b turn");
            System.out.println("satr entekhab konid az 0 ta 7");
            int r=var.nextInt();
            System.out.println("sotoon entekhab konid az 0 ta 7");
            int c=var.nextInt();
            /*System.out.println("x ya o ");
            String xo=var.next();*/
            a.board[r][c]='b';
            a.board=Tic.copy(update(a.board, r,c));
            Tic.print(a.board);
            if(Tic.utility(a.board,false,Tic.fsuccessor(a.board, false).size())!=-2){
                int u=Tic.utility(a.board,false,Tic.fsuccessor(a.board, false).size());
                if(u==-1)
                    System.out.println("r bord");
                if(u==1)
                    System.out.println("b bord");
                if(u==0)
                    System.out.println("Tasavi");
                break;
            }
            
            System.out.println("r turn");
            Tic.minimax(a.board, false, cc);
            a.board=Tic.copy(Tic.bestmove);
            Tic.print(a.board);
            if(Tic.utility(a.board,true,Tic.fsuccessor(a.board, true).size())!=-2){
                int u=Tic.utility(a.board,true,Tic.fsuccessor(a.board, true).size());
                if(u==-1)
                    System.out.println("r bord");
                if(u==1)
                    System.out.println("b bord");
                if(u==0)
                    System.out.println("Tasavi");
                break;
            }
        }
        
        //System.out.println(Tic.minimax(g, true));
        
    }
}
