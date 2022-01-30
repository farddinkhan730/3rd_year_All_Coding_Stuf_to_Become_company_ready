package Oops;

public class practice {

}
abstract class p{
    public p() {
        System.out.println("1");
    }
}
class q extends p{
    public q(){
        System.out.println("2");
    }
}
class r extends  q{
    public r(){
        System.out.println("3");
    }
}
class test{
    public static void main(String[] args) {
        new r();
    }
}
class  mammal{
    void eat(){
        System.out.println("mamal eat food");
    }
}
class cattle extends mammal{
    void eat(){
        System.out.println("cattle eat food");
    }
}
class horse extends cattle{
    void eat(){
        System.out.println("horse eat food");
    }
}
class test1{
//    public static void print(int i,int j,int k){
//        System.out.println("int");
//    }
//    public static void print(String...b){
//
//        System.out.println("long");
//    }
    public static void main(String[] args) {
        mammal h=new mammal();
        cattle c=new horse();
        c.eat();
//        byte b=9;
//        print(b,b,b);
    }
}
class mm{
    static  int add(int i,int j){
        return i+j;
    }
}
class  a extends  mm{
    public static void main(String[] argv) {
        short b=9;
        System.out.println(add(b,6));
    }
}
class aa{
    int i=10;
    public void printval(){
        System.out.println("Value-A");
    }
}
class b extends aa{
    int i=12;
    public void printval() {
        System.out.println("value-b");
    }
}
class  t{
    public static void main(String[] args) {
        b obj=new b();
        System.out.println(obj.i);
        obj.printval();
    }
}
class rectangel{
    public void area(int length,int width){
        System.out.println(length*width);
    }
}
class square extends rectangel{
    public void area(long length,long width){
        System.out.println(Math.pow(length,2));
    }
}
class testt{
    public static void main(String[] args) {
        square s=new square();
        s.area(5,4);
    }
}
class base{
    int val=0;
    base(){
        addval();
    }
    void addval(){
        val+=10;
    }
    int getVal(){
        return val;
    }
}
class derived extends base{
    derived(){
        addval();
    }
    void addval(){

        val+=20;
    }
}
class tt{
    public static void main(String[] args) {
        base b=new derived();
        System.out.println(b.getVal());
    }
}

class A{
    public A() {
        System.out.println("A");
    }
    public A(int i) {
        this();
        System.out.println(i);
    }
}
class B extends A{
    public  B() {
        super();
        System.out.println("B");
    }

    public B(int i) {
        this();
        System.out.println(i+3);
    }
}
class tn{
    public static void main(String[] args) {
        new B(5);
    }
}
class Animal{
    public Animal() {
        System.out.println("Animal");
    }
}
class wild extends Animal{
    public wild() {
        System.out.println("Wild");
//        super();  super call shuld bhi first in constructor body
    }
}

