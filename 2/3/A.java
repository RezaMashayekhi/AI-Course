
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
class Node{
    int x;
    int y;
    
    Node(int x,int y){
        this.x=x;
        this.y=y;
    }

    boolean isEqual(Node e) {
        if(e.x==x && e.y==y)
            return true;
        else
            return false;
    }
}

class Fringe{
    Node node;             // rasi ke ezafe mishavad
    int g;                  // haman g(n) hast. hazinei ke tey karde
    int cost;              //  f(n). baravord hazine kol masir az s be g ba gozashtan azin masir
    int depth;              // dar che omghi dide shode
    LinkedList<Node> path;
    
    Fringe(Node n, int g, int depth){
        this.node=n;
        this.depth=depth;
        this.g=g;
        cost= g + Math.abs(node.x-Graph.goal.x)+Math.abs(node.y-Graph.goal.y); //f(n)= g(n) + h(n)
    }
    public void updatePath(LinkedList<Node> parent){
        if (parent!=null)
            path=parent;
        else
            path=new LinkedList();
        
        path.add(node);
        
    }
}

class Graph{
    
        int m; //tedad satrha
        int n; //tedad sotoonha
        static Node start;
        static Node goal;
        LinkedList<Node> adj[][]; //linked list baraye ras haye mojaver
        
        Graph(int m, int n){
            this.m=m;
            this.n=n;
            adj=new LinkedList[m][n];
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    adj[i][j]= new LinkedList();
            addEdges();
            
        }
        
        public void addEdges(){
            adj[0][0].add(new Node(0,1)); adj[0][0].add(new Node(1,0)); adj[0][0].add(new Node(1,1));  // shoroo bala samte chap hast
            adj[m-1][0].add(new Node(m-2,0)); adj[m-1][0].add(new Node(m-2,1)); adj[m-1][0].add(new Node(m-1,1));
            adj[m-1][n-1].add(new Node(m-1,n-2)); adj[m-1][n-1].add(new Node(m-2,n-2)); adj[m-1][n-1].add(new Node(m-2,n-1));
            adj[0][n-1].add(new Node(0,n-2)); adj[0][n-1].add(new Node(1,n-2)); adj[0][n-1].add(new Node(1,n-1));
            
            
            for(int i=1;i<m-1;i++){
                adj[i][0].add(new Node(i-1,1));
                adj[i][0].add(new Node(i,1));
                adj[i][0].add(new Node(i+1,1));
                
                adj[i][n-1].add(new Node(i-1,n-2));
                adj[i][n-1].add(new Node(i,n-2));
                adj[i][n-1].add(new Node(i+1,n-2));
            }
            
            for(int j=1;j<n-1;j++){
                adj[0][j].add(new Node(1,j-1));
                adj[0][j].add(new Node(1,j));
                adj[0][j].add(new Node(1,j+1));
                
                adj[m-1][j].add(new Node(m-2,j-1));
                adj[m-1][j].add(new Node(m-2,j));
                adj[m-1][j].add(new Node(m-2,j+1));
            }
            
            for(int i=1;i<m-1;i++)
                for(int j=1;j<n-1;j++){
                    adj[i][j].add(new Node(i-1,j-1));
                    adj[i][j].add(new Node(i-1,j));
                    adj[i][j].add(new Node(i-1,j+1));
                    adj[i][j].add(new Node(i,j+1));
                    adj[i][j].add(new Node(i+1,j+1));
                    adj[i][j].add(new Node(i+1,j));
                    adj[i][j].add(new Node(i+1,j-1));
                    adj[i][j].add(new Node(i,j-1));
                }
            
        }
        

        
        public void ucs(Node start, Node goal){
            Node parent[][]= new Node[m][n]; // masir ra zakhire mikonad. dar har khane adrese parentash ra darad 
            this.start=start; this.goal=goal;
            LinkedList<Fringe> fringe=new LinkedList();
            LinkedList<Node> visited=new LinkedList();

            fringe.add(new Fringe(start,0,1));
            fringe.get(0).updatePath(null);
            int a1=0; 
            int cost_of_the_path=0; 
            
            while(fringe.size()>0){
                int smal=smallestCost(fringe);                   // andis koochiktarin node dar linked list fringe   
                Node small=fringe.get(smal).node;                // khode koochictarin node
                if(!contain(visited,small)){
                    visited.add(small);
                    if(small.isEqual(goal)){
                        a1=fringe.get(smal).depth;
                        cost_of_the_path=fringe.get(smal).cost;
                        System.out.println("kootahtarin masir");
                        for(int i=fringe.get(smal).path.size()-cost_of_the_path-1;i<fringe.get(smal).path.size();i++)
                            System.out.println(fringe.get(smal).path.get(i).x+""+fringe.get(smal).path.get(i).y);
                        System.out.println("******** cost:"+cost_of_the_path);
                    }
                    else{
                        for (int j=0;j<adj[small.x][small.y].size();j++){
                            int hazine=1;
                            if(small.x!=adj[small.x][small.y].get(j).x && small.y!=adj[small.x][small.y].get(j).y)    //agar ghotri beravad hazine 2 mishavad
                                hazine=2;
                                
                            fringe.add(new Fringe(adj[small.x][small.y].get(j), fringe.get(smal).g + hazine, fringe.get(smal).depth+1));    
                            fringe.get(fringe.size()-1).updatePath(fringe.get(smal).path);
                        }
                    }
                }
          
                fringe.remove(smal);
            }
            /*System.out.println("kootahtarin masir");

            System.out.println(goal.x+ " "+goal.y);
            while(x!=start.x || y!=start.y){
                System.out.println(parent[x][y].x+" "+parent[x][y].y);
                x=parent[x][y].x; y=parent[x][y].y;
            }
            
            System.out.println("******** cost:"+cost_of_the_path);*/
            
        }
        
        public int smallestCost(LinkedList<Fringe> fringe){
            int min=0;
            for (int i=0;i<fringe.size();i++)
                if(fringe.get(i).cost<fringe.get(min).cost)
                    min=i;
                 
            return min;
        }
        
        public boolean contain (LinkedList<Node> visited,Node e){
            
            for (int i=0;i<visited.size();i++)
                if(visited.get(i).isEqual(e))
                    return true;
                 
            return false;
        }
        
        
        
}

public class A {
 
    public static void main(String args[]){
        
        Scanner var = new Scanner(System.in);
        System.out.println("matrise chand dar chan hast? be soorate 2 2 vared konid yani masalan do dar do hast ");  //ras ha az 1 shomare gozari mishavand to v ke tedade ras hast
        Graph g = new Graph(var.nextInt(),var.nextInt());
     
        //g.print();
        System.out.println("\nras shoroo va hadaf ra be soorate masalan 0 0 2 2 vared konid do taye aval khaneye shoroo va dotaye dovom khaneye hadaf dar matris hast");
        g.ucs(new Node(var.nextInt(),var.nextInt()),new Node(var.nextInt(),var.nextInt())); // ba shoroo az ras 1 ba ravesh bfs graph ra peymayesh mikonad va ras hay gheir tekrari be tartib moshahede shode ra minevisad
        
    }
    
}
