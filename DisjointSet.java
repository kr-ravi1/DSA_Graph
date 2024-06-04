import java.util.*;
class DisjointSetByUnion {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSetByUnion(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v) return;
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}

public class DisjointSet {
    public static void main(String[] args){
        DisjointSetByUnion ds = new DisjointSetByUnion(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("Same Component");
        }
        else {
            System.out.println("Not same component");
        }

        ds.unionBySize(3, 7);
        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("Same Component");
        }
        else {
            System.out.println("Not same component");
        }
    }
}
