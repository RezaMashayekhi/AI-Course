
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

class WeightedEdge{
    int index;             // andis ras entehai yal
    int w;              // vazn yal
    WeightedEdge(int i, int w){
        this.index=i;
        this.w=w;
    }
}

class Fringe{
    int index;             // andis rasi ke ezafe mishavad
    int cost;              //  hazine residan az s be in ras
    int depth;              // dar che omghi dide shode
    Fringe(int i, int w, int depth){
        this.index=i;
        this.cost=w;
        this.depth=depth;
    }
}

class Graph{
    
        int v; //tedad ras ha
        LinkedList<WeightedEdge> adj[]; //linked list baraye ras haye mojaver
        
        Graph(int n){
            v=n;
            adj=new LinkedList[v];
            for(int i=0;i<n;i++){
                adj[i]= new LinkedList();
            }
        }
        
        public void addEdge(int i, int j, int w){
            WeightedEdge e=new WeightedEdge(j-1,w);
            adj[i-1].add(e);
        }
        
        public void print(){
            for(int i=0; i<v;i++){
                System.out.println("***ras haye khorooji az ras "+ (i+1) + "***");
                for(int j=0; j<adj[i].size();j++)
                    System.out.println(adj[i].get(j).index+1);
            }
        }
        
        public void ucs(int s, int g){
            LinkedList<Fringe> fringe=new LinkedList();
            LinkedList<Integer> visited=new LinkedList();
            fringe.add(new Fringe(s-1,0,1));
            int a1=0; int a2=0;
            int cost_of_the_path=0; int cost_of_the_path2=0;
            
            while(fringe.size()>0 && a2==0){
                int smal=smallestCost(fringe);                      // as avale list bardashte mishavad
                int small=fringe.get(smal).index;
                if(!visited.contains(small)){
                    visited.add(small);
                    if(small==g-1){
                        a1=fringe.get(smal).depth;
                        cost_of_the_path=fringe.get(smal).cost;
                    }
                    else{
                    for (int j=0;j<adj[small].size();j++)
                        fringe.add(new Fringe(adj[small].get(j).index,adj[small].get(j).w+fringe.get(smal).cost,fringe.get(smal).depth+1));       // be akhare list ezafe mishavad
                    }
                }
                else if(small==g-1){
                    a2=fringe.get(smal).depth;
                    cost_of_the_path2=fringe.get(smal).cost;
                }
                fringe.remove(smal);
            }
            System.out.println("kootahtarin masir");
            for(int i=0;i<a1-1;i++)
                System.out.println(visited.get(i)+1);
            System.out.println(g);
            System.out.println("******** cost:"+cost_of_the_path);
            
            System.out.println("\n dovomin kootahtarin masir");
            for(int i=0;i<a2-1;i++)
                System.out.println(visited.get(i)+1);
            System.out.println(g);
            System.out.println("******** cost:"+cost_of_the_path2);
        }
        
        public int smallestCost(LinkedList<Fringe> fringe){
            int min=0;
            for (int i=0;i<fringe.size();i++)
                if(fringe.get(i).cost<fringe.get(min).cost)
                    min=i;
                 
            return min;
        }
        
}

public class A {
 
    public static void main(String args[]){
        
        Scanner var = new Scanner(System.in);
        System.out.println("tedad e ras ha ra vared konid");  //ras ha az 1 shomare gozari mishavand to v ke tedade ras hast
        Graph g = new Graph(var.nextInt());
        System.out.println("tedad e yal ha ra vared konid sepas har khat joda yek yal be soorate 1 2 5 yani yal az ras 1 be ras 2 vojood darad ba vazn 5");
        int e=var.nextInt();
        for (int i=0; i<e;i++){
            g.addEdge(var.nextInt(), var.nextInt(), var.nextInt());
        }
        g.print();
        System.out.println("\nras shoroo va hadaf ra be soorate masalan 1 3 vared konid");
        g.ucs(var.nextInt(),var.nextInt()); // ba shoroo az ras 1 ba ravesh bfs graph ra peymayesh mikonad va ras hay gheir tekrari be tartib moshahede shode ra minevisad
        
    }
    
}
