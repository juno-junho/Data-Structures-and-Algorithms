package data_structures.stacks.using_array;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntStack s = new IntStack(64);
        while (true){
            System.out.println("Current data number is : " + s.size() + " / " + s.capacity());
            System.out.println("(1) push (2) pop (3) peek (4) dump (5) exit");
            int menu = sc.nextInt();
            if (menu == 5 ) {
                System.out.println("Exit the program");
                break;
            }

            int x;
            switch (menu){
                case 1:
                    System.out.println("Enter data : ");
                    x = sc.nextInt();
                    try{
                        s.push(x);
                    }catch (IntStack.OverflowIntStackException e) {
                        System.out.println("Stack is full");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("Popped data is " + x + ".");
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("Stack is empty");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("Peeked data is " + x + ".");
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("Stack is empty");
                    }
                    break;
                case 4:
                    s.dump();
                    System.out.println();
                    break;
                default:
                    System.out.println("You entered wrong number.");
            }
        }
    }
}
