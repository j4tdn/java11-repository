package ex04;

import java.util.Scanner;

public class App {
	String s;
    public char[] s1= new char[100];
    public char[] s2= new char[100];
    int n1;
    int n2;
    int Max(int a,int b)
    {
        if(a>=b) return a; else return b;
    }
    void init()
    {
        Scanner im= new Scanner(System.in);
        System.out.println("NHAP CHUOI S1\t");
        s=im.nextLine();
        s1=s.toCharArray();
        System.out.println("NHAP CHUOI S2");
        s=im.nextLine();
        s2=s.toCharArray();
        n1=s1.length;
        n2=s2.length;
    }
    int F_dequy(int m1,int m2)
    {
           
        if( m1 < 0 || m2< 0 ) return 0;
        else
        if( s1[m1] != s2[m2] )
            return Max(F_dequy(m1-1,m2),F_dequy(m1,m2-1));
        else
            return 1+F_dequy(m1-1,m2-1);
    }
    public static void main(String[] args)
    {
      
    	
        int n=ob.F_dequy(ob.n1,ob.n2);
        System.out.print(" DO DAI XAU CHUNG DAI NHAT LA "+n);
       
    }
}
