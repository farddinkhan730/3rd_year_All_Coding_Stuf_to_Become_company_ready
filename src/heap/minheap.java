package heap;

import java.util.ArrayList;
import java.util.List;
class Heap {
    private List<Integer> l=new ArrayList<>();
    public void add(int item){
        this.l.add(item);
        upheapify(this.l.size()-1);
    }
    private void upheapify(int ci){
        int pi=(ci-1)/2;
        if(this.l.get(pi)>this.l.get(ci)){
            swap(pi,ci);
            upheapify(pi);
        }
    }
    private void swap(int pi,int ci){

        int ith=this.l.get(pi);
        int jth=this.l.get(ci);
        l.set(ci,ith);
        l.set(pi,jth);

    }
    public int remove(){
        swap(0,this.l.size()-1);
        int rv=this.l.remove(this.l.size()-1);
        downheapify(0);
        return rv;
    }
    public void downheapify(int pi){
        int c1=2*pi+1;
        int c2=2*pi+2;
        int mini=pi;
        if(this.l.get(c1)<this.l.get(mini)){
            mini=c1;
        }
        if(c2<this.l.size() && this.l.get(c2) < this.l.get(mini)){
            mini=c2;
        }
        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }
    public int getmin(){
        return this.l.get(0);
    }
    public void display(){
        System.out.println(this.l);
    }
}
class Heap_Client {
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(5);
        hp.add(6);
        hp.add(1);
        hp.add(7);
        hp.add(8);
        hp.add(-2);
        hp.add(10);
        hp.add(-1);
        hp.add(-4);
        hp.display();
        System.out.println(hp.getmin());
        System.out.println(hp.remove());
        hp.display();
    }
}
