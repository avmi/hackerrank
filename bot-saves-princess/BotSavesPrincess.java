import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavesPrincess {
    static void display(int n, String [] grid){
        int pos=0;

        String newArray[] = new String[n*n];

        for(int i=0,k=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length();j++) {
                newArray[k] = ""+grid[i].charAt(j);
                k++;
            }
        }

        if(newArray[0].equals("p"))
            pos = 0;
        else if(newArray[n-1].equals("p"))
            pos = n-1;
        else if(newArray[n*(n-1)].equals("p"))
            pos = n*(n-1);
        else if(newArray[n*(n-1) + (n-1)].equals("p"))
            pos = (n*(n-1) + (n-1));

        int m = ((n*n)+1)/2 -1 ;

        m = (n+1)/2;
        if(pos==0) {
            for(int i=0;i<n-m;i++) {
                System.out.println("LEFT");
            }

            for(int i=0;i<n-m;i++) {
                System.out.println("UP");
            }
        }

        if(pos==n-1) {
            for(int i=0;i<n-m;i++) {
                System.out.println("RIGHT");
            }

            for(int i=0;i<n-m;i++) {
                System.out.println("UP");
            }
        }

        if(pos==n*(n-1)) {
            for(int i=0;i<n-m;i++) {
                System.out.println("LEFT");
            }

            for(int i=0;i<n-m;i++) {
                System.out.println("DOWN");
            }
        }

        if(pos==(n*(n-1) + (n-1))) {
            for(int i=0;i<n-m;i++) {
                System.out.println("RIGHT");
            }

            for(int i=0;i<n-m;i++) {
                System.out.println("DOWN");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        String grid[] = new String[m];

        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        display(m,grid);
    }
}