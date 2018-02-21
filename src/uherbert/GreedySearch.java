
package uherbert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GreedySearch {
    //choosex,choosey tell the Algorithm what is the next SubGoal (which '1' in the grid should be our next goal)
       public static int  choosex=-1;
         public static int choosey=-1;
         public int cou=1;
     public ArrayList<Node> AHeri(Node root)
   {
       
       ArrayList<Node> explored=new ArrayList();
       ArrayList<Node> pathFounder=new ArrayList();
      PriorityQueue<Node> frontier =
                          new PriorityQueue<>();
       frontier.add(root);
       
       boolean Goalfound = false;
       System.err.println("SEARCHING.....");
       while (frontier.size()>0 && Goalfound==false) {
          
           Node state=frontier.remove();
           explored.add(state);
           if(cou==1) //chech if s exblored before 
           {
               state.EvaluateNode();
               cou++;
           }
           state.expandMove();
           //state.print();
           
           //state.print();
           for(int i=0;i<state.neighbors.size();i++)
           {
               Node currentneighbours= state.neighbors.get(i);
              
               if(currentneighbours.GoalTest())
               {
                   System.out.println("GOAL FOUND...");
                   Goalfound=true;
                   findpath(pathFounder,currentneighbours);
               }
                if(!currentneighbours.subGoal())
               {
                   
                   currentneighbours.EvaluateNode();
                   frontier.clear();
                   
                   
               } //if neighbour wasn't explored before add it to front 
               if(!contain(explored, currentneighbours) && !contain2(frontier, currentneighbours))
               {
                   currentneighbours.calculateCost();
                   frontier.add(currentneighbours);
               }
           }
           
           
       }
       return pathFounder;
   }
   public void findpath( ArrayList<Node> path,Node c)
   {
       System.out.println("TRACING THE PATH...");
       Node current =c;
       path.add(current);
       while(current.parent!=null)
       {
           current=current.parent;
           path.add(current);
           
           
       }
   }
   // cheack if  node exblored befor
   public boolean contain(ArrayList<Node> list,Node c)
   {
       boolean contains=false;
       for(int i=0;i<list.size();i++)
       {
           if(list.get(i).IsSame(c.Gride))
           {
               contains=true;
               
           }
           
       }
       return contains;
   }
    public boolean contain2(PriorityQueue<Node> list,Node c)
   {
         boolean contains=false;
       Iterator<Node> iter = list.iterator();
        while (iter.hasNext()) {
           Node current = iter.next();
 
            if(current.IsSame(c.Gride))
           {
               contains=true;
               
           }
        }
   
       return contains;
   }
    
}
