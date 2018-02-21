/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uherbert;

import java.util.ArrayList;

/**
 *
 * @author hagarmohamad75
 */
public class DepthFirst {
    public ArrayList<Node> DFs(Node root)
   {
       ArrayList<Node> frontier=new ArrayList();
       ArrayList<Node> temp=new ArrayList();
       ArrayList<Node> explored=new ArrayList();
       ArrayList<Node> pathFounder=new ArrayList();
      
       frontier.add(root);
       boolean Goalfound = false;
       System.err.println("searching.....");
       while (frontier.size()>0 && Goalfound==false) {
          
           Node state=frontier.remove(frontier.size()-1);
           explored.add(state);
           state.expandMove();
           
           //state.print();
           for(int i=0;i<state.neighbors.size();i++)
           {
               Node currentneighbours= state.neighbors.get(i);
               if(currentneighbours.GoalTest())
               {
                   System.out.println("Goal found...");
                   Goalfound=true;
                   findpath(pathFounder,currentneighbours);
               }
               else
               if(!contain(explored, currentneighbours) && !contain(frontier, currentneighbours))
               {
                   temp.add(currentneighbours);
                   
               }
           }
           for(int i=0;i<temp.size();i++)
           {
               frontier.add(temp.remove(temp.size()-1));
           }
           
           
       
       
   }
   return pathFounder;}
   public void findpath( ArrayList<Node> path,Node c)
   {
       System.out.println("trace the path...");
       Node current =c;
       path.add(current);
       while(current.parent!=null)
       {
           current=current.parent;
           path.add(current);
           
           
       }
   }
   
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
    
    
}
