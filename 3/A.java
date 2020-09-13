
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reza
 */

class Puzzle{
    int [][] a;             // puzzle feli
    int p;                   // andis parent dar visited
    Puzzle(int [][] b, int parent){
        copy(b);         
        this.p=p;  
    }
    
    public void copy(int [][] b){
        a=new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=b[i][j];
    }
}

class Fringe{
    int [][] a;             // puzzle feli
    int cost;              //  haman f dar algorithm a* hast
    int depth;              // dar che omghi dide shode
    int p;                   // andis parent dar visited
    Fringe(int [][] b, int depth, int parent){
        copy(b);         
        this.depth=depth;
        this.p=p;  
        evaluateF();
    }
    
    public void copy(int [][] b){
        a=new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=b[i][j];
    }
    
    public void evaluateF(){
        cost=depth;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                 //manhatan
                if(a[i][j]!=0){
                    int ig=a[i][j]/3;
                    int jg=a[i][j]-(3*ig);
                    cost+=Math.abs(i-ig)+Math.abs(j-jg);
                    
                    
                    /* baraye halate misplaced
                    
                    if (i!=ig || j!=jg)
                        cost+=1;
                    */
                }
            }
    }
    
}

 class Problem{
    
    public void ucs(int[][] s, int [][] g){    // algorithm a * hast
        
            LinkedList<Fringe> fringe=new LinkedList();
            LinkedList<Puzzle> visited=new LinkedList();
            fringe.add(new Fringe(s,0,-1));
            int a1=0; 
            int cost_of_the_path=0; 
            while(fringe.size()>0){
                int smal=smallestCost(fringe);                      // as avale list bardashte mishavad
                int [][] small=fringe.get(smal).a;
                if(!doesVisitedContain(visited,small)){
                    visited.add(new Puzzle(small,fringe.get(smal).p));
                    if(equal(small,g)){
                        a1=visited.size()-1;
                        cost_of_the_path=fringe.get(smal).cost;
                        break;
                    }
                    else{
                        LinkedList<Puzzle> adj=new LinkedList();
                        createAdj(adj, small);
                        for (int j=0;j<adj.size();j++)
                            fringe.add(new Fringe(adj.get(j).a, fringe.get(smal).depth+1, visited.size()-1));       // be akhare list ezafe mishavad
                    }
                    
                }
                
                print(small);
                System.out.println("hazine "+fringe.get(smal).cost);
                fringe.remove(smal);
               
            }
            
            System.out.println("kootahtarin masir");
            
            while(a1!=-1){
                int[][] x=visited.get(a1).a;
                a1=visited.get(a1).p;
                print(x);
            }
                
            System.out.println("******** cost:"+cost_of_the_path);
            
            
    }
    
        
    public int smallestCost(LinkedList<Fringe> fringe){
        
        int min=0;
        for (int i=0;i<fringe.size();i++)
            if(fringe.get(i).cost<=fringe.get(min).cost)
                min=i;
                 
        return min;
        
    }
    
    public boolean doesVisitedContain(LinkedList<Puzzle> visited,int [][] b){
      
        for (int i=0;i<visited.size();i++)
            if(equal(visited.get(i).a,b))
                return true;
                 
        return false;
        
    }    
    
    
    
    public boolean equal(int [][] a, int [][] b){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(a[i][j]!=b[i][j])
                    return false;
        return true;
    }
    
    public void copy(int [][] a, int [][] b){
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=b[i][j];
    }
    
    public void createAdj(LinkedList<Puzzle> adj,int [][] small){
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(small[i][j]==0){
                    if(i-1>=0){
                        int [][] a=new int[3][3];
                        copy(a,small);
                        a[i][j]=small[i-1][j];
                        a[i-1][j]=0;
                        adj.add(new Puzzle(a,0));
                    }
                    
                    if(j+1<=2){
                        int [][] a=new int[3][3];
                        copy(a,small);
                        a[i][j]=small[i][j+1];
                        a[i][j+1]=0;
                        adj.add(new Puzzle(a,0));
                    }
                    
                    if(i+1<=2){
                        int [][] a=new int[3][3];
                        copy(a,small);
                        a[i][j]=small[i+1][j];
                        a[i+1][j]=0;
                        adj.add(new Puzzle(a,0));
                    }
                    
                    if(j-1>=0){
                        int [][] a=new int[3][3];
                        copy(a,small);
                        a[i][j]=small[i][j-1];
                        a[i][j-1]=0;
                        adj.add(new Puzzle(a,0));
                    }
                    
                    break;
                    
                }
    }
    
    public void print(int [][] a){
        System.out.println("************");
        for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++)
                        System.out.print(a[i][j]);
                    System.out.println("");
                }
    }
}

public class A {
        
 
    public static void main(String args[]){
        
        Scanner var = new Scanner(System.in);
        int [][] s= {{3,4,5},{1,2,0},{7,6,8}};
        int [][] g= {{0,1,2},{3,4,5},{6,7,8}};   
        Problem p=new Problem();
        p.ucs(s,g);
    }
    
}
