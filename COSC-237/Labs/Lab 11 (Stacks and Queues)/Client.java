import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        LinkedStackClass stack = new LinkedStackClass<Integer>();
        stack.initializeStack();
        Scanner in = new Scanner(System.in);

        int num = getInt(in, "Enter integers for stack (999 to stop): ");
        stack.push(num);
        while (num != 999){
            num = getInt(in, "");
            if (num != 999)
                stack.push(num);
        }

        System.out.println("The original stack printed in direct order (bottom to top) is:");
        printStack(stack);
        System.out.println();

        System.out.println("The stack printed in reverse order (top to bottom) is:");
        printBackStack(stack);
        System.out.println();

        System.out.println("The stack stores " + countItems(stack) + " items.");

        System.out.println("The second item (below the top) is: " + getSecond(stack)); 

        System.out.println("The top is: " + stack.peek());

        int remove = getInt(in,"Enter value to be removed from stack: ");
        removeItem(stack, remove);

        System.out.println("The stack after remvoing every occurence of " + remove + " is:");
        printStack(stack);
        System.out.println();

        System.out.println("Reverse the stack. The new stack printed in direct order is:");
        reverseStack(stack);
        printStack(stack);
        System.out.println();


        QueueClass queue = new QueueClass<Integer>();
        queue.initializeQueue();
        num = getInt(in, "Enter integers for queue (999 to stop): ");
        queue.enqueue(num);
        while (num != 999){
            num = getInt(in, "");
            if (num != 999)
                queue.enqueue(num);
        }
        
        System.out.println("The queue is:");
        printQueue(queue);
        System.out.println();


        reverseQueue(queue);
        System.out.println("The reversed queue is:");
        printQueue(queue);
    }

    public static int getInt(Scanner input, String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.next(); // consume unwanted input type
            System.out.print("Not an Integer! Try again!\n");
            System.out.print(prompt);
        }
        return input.nextInt();
    }

    public static void printBackStack(LinkedStackClass<Integer> stack) {
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!stack.isEmptyStack()) {
            System.out.print(stack.peek() + " ");
            temp.push(stack.peek());
            stack.pop();
        }
        while (!temp.isEmptyStack()) {
            stack.push(temp.peek());
            temp.pop();
        }
    }
    

    public static void printStack(LinkedStackClass<Integer> stack) {
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!stack.isEmptyStack()) {
            temp.push(stack.peek());
            stack.pop();
        }
        while (!temp.isEmptyStack()) {
            System.out.print(temp.peek() + " ");
            stack.push(temp.peek());
            temp.pop();
        }
    }

    public static Integer getSecond(LinkedStackClass<Integer> stack) {
        int helper = stack.peek();
        stack.pop();
        int second = stack.peek();
        stack.push(helper);
        return second;
    }

    public static int countItems(LinkedStackClass<Integer> stack) {
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        int count = 0;
        while (!stack.isEmptyStack()) {
            count++;
            temp.push(stack.peek());
            stack.pop();
        }
        while (!temp.isEmptyStack()) {
            stack.push(temp.peek());
            temp.pop();
        }
        return count;
    }

    public static void removeItem(LinkedStackClass<Integer> stack, Integer n) {
        LinkedStackClass<Integer> temp = new LinkedStackClass<>();
        while (!stack.isEmptyStack()) {
            if (stack.peek() != n)
                temp.push(stack.peek());
            stack.pop();
        }
        while (!temp.isEmptyStack()) {
            stack.push(temp.peek());
            temp.pop();
        }
    }

    public static void reverseStack(LinkedStackClass<Integer> stack) {
        QueueClass<Integer> queue = new QueueClass<Integer>();
        while (!stack.isEmptyStack()) {
            queue.enqueue(stack.peek());
            stack.pop();
        }
        while (!queue.isEmptyQueue()) {
            stack.push(queue.front());
            queue.dequeue();
        }

    }

    public static void reverseQueue(QueueClass<Integer> queue) {
        LinkedStackClass<Integer> stack = new LinkedStackClass<Integer>();
        while (!queue.isEmptyQueue()) {
            stack.push(queue.front());
            queue.dequeue();
        }
        while (!stack.isEmptyStack()) {
            queue.enqueue(stack.peek());
            stack.pop();
        }
    }

    public static void printQueue(QueueClass<Integer> queue) {
        QueueClass<Integer> temp = new QueueClass<Integer>();
        while (!queue.isEmptyQueue()) {
            System.out.print(queue.front() + " ");
            temp.enqueue(queue.front());
            queue.dequeue();
        }
        while (!temp.isEmptyQueue()) {
            queue.enqueue(temp.front());
            temp.dequeue();
        }

    }
}
