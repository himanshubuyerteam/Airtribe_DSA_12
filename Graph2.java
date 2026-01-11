import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class Graph2 {
    class data{
        int vtx;
        int par;
        data(int vtx,int par)
        {
            this.vtx=vtx;
            this.par=par;
        }
    }
    public boolean isCycle(int n, int [][]edges)
    {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int []e:edges)
        {
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                if(bfsUndirectedCycle(i, vis, graph)==true)
                    return true;
            }
        }
        return false;
    }
    private boolean bfsUndirectedCycle(int src,boolean []vis,
                                    List<List<Integer>>graph)
    {
        Queue<data>q=new LinkedList();
        q.add(new data(src, -1));
        vis[src]=true;
        while(q.size()>0)
        {
            data d=q.remove();
            int vtx=d.vtx;
            int par=d.par;
            for(int nbr:graph.get(vtx))
            {
                if(nbr == par)
                    continue;
                if(vis[nbr]==true)
                    return true;
                vis[nbr]=true;
                q.add(new data(nbr,vtx));
            }
        }
        return false;
    }
    public boolean isPossible(int noOfCourses,int [][]prereq)
    {
        int []indegree=new int[noOfCourses];
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<noOfCourses;i++)
            graph.add(new ArrayList<>());
        
        for(int []e:prereq)
        {
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer>q=new LinkedList();
        for(int i=0;i<noOfCourses;i++)
        {
            if(indegree[i]==0)
                q.add(i);
        }
        List<Integer>topologicalOrder=new ArrayList<>();
        while(q.size()>0)
        {
            int fnt=q.remove();
            topologicalOrder.add(fnt);
            for(int nbr:graph.get(fnt))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                    q.add(nbr);
            }
        }
        if(topologicalOrder.size()==noOfCourses)
            return true;
        else
            return false;

    }
}
