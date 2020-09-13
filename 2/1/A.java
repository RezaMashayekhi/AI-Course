
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

class Graph{
    
        int v; //tedad ras ha
        LinkedList<Integer> adj[]; //linked list baraye ras haye mojaver
        
        Graph(int n){
            v=n;
            adj=new LinkedList[v];
            for(int i=0;i<n;i++){
                adj[i]= new LinkedList();
            }
        }
        
        public void addEdge(int i, int j){
            adj[i-1].add(j-1);
        }
        
        public void print(){
            for(int i=0; i<v;i++){
                System.out.println("***ras haye khorooji az ras "+ (i+1) + "***");
                for(int j=0; j<adj[i].size();j++)
                    System.out.println(adj[i].get(j)+1);
            }
        }
        
        public void bfs(int s){
            LinkedList<Integer> fringe=new LinkedList();
            LinkedList<Integer> visited=new LinkedList();
            fringe.add(s-1);
            while(fringe.size()>0){
                int i=fringe.poll();                      // as avale list bardashte mishavad
                if(!visited.contains(i)){
                    visited.add(i);
                    for (int j=0;j<adj[i].size();j++)
                        fringe.add(adj[i].get(j));       // be akhare list ezafe mishavad
                }
            }
            for(int i=0;i<visited.size();i++)
                System.out.println(visited.get(i)+1);
        }
        
        public void dfs(int s){
            LinkedList<Integer> fringe=new LinkedList();
            LinkedList<Integer> visited=new LinkedList();
            fringe.add(s-1);
            while(fringe.size()>0){
                int i=fringe.poll();                            // az avale list bardashte mishavad
                if(!visited.contains(i)){
                    visited.add(i);
                    for (int j=0;j<adj[i].size();j++)
                        fringe.addFirst(adj[i].get(j));         // be avale list ezafe mishavad
                }
            }
            for(int i=0;i<visited.size();i++)
                System.out.println(visited.get(i)+1);
        }
        
}

public class A {
 
    public static void main(String args[]){
        
        Scanner var = new Scanner(System.in);
        System.out.println("tedad e ras ha ra vared konid");  //ras ha az 1 shomare gozari mishavand to v ke tedade ras hast
        Graph g = new Graph(var.nextInt());
        System.out.println("tedad e yal ha ra vared konid sepas har khat joda yek yal be soorate 1 2 yani yal az ras 1 be ras 2 vojood darad");
        int e=var.nextInt();
        for (int i=0; i<e;i++){
            g.addEdge(var.nextInt(), var.nextInt());
        }
        g.print();
        System.out.println("ras haye be tartib peymoode shode dar search bfs");
        g.bfs(1); // ba shoroo az ras 1 ba ravesh bfs graph ra peymayesh mikonad va ras hay gheir tekrari be tartib moshahede shode ra minevisad
        
        System.out.println("ras haye be tartib peymoode shode dar search dfs");
        g.dfs(1); // ba shoroo az ras 1 ba ravesh bfs graph ra peymayesh mikonad va ras hay gheir tekrari be tartib moshahede shode ra minevisad
        
    }
    
}
