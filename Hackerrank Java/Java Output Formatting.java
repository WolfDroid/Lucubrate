import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                //Forcing the char into 15 space, Left Alignment
                System.out.printf("%-15s", s1);
                //Forcing the Number into 3 space, Fill the blank with Zero, end formatting, new line
                System.out.printf("%03d%n", x);
            }
            System.out.println("================================");

    }
}