import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Problem 1
        Integer intArray[] = {10,15,20,40,30};
        ProblemOne problemOne = new ProblemOne();
        List<Integer> intArrayList = Arrays.asList(intArray);
        Integer sumWithForLoop = problemOne.getSumWithForLoop(intArrayList);
        System.out.println("Sum with for loop: " + sumWithForLoop);
        Integer sumWithWhileLoop = problemOne.getSumWithWhileLoop(intArrayList);
        System.out.println("Sum with while loop: " + sumWithWhileLoop);


        //Problem 2
        ProblemTwo problemTwo = new ProblemTwo();
        List<Object> result = problemTwo.combineList();
        System.out.println("Combined List: " + result);

        //Problem 3
        ProblemThree problemThree = new ProblemThree();
        List<Integer> integers = problemThree.computeFibonacci(0, 1);
        System.out.println("Fibonacci Numbers list: " + integers);

        ProblemFour problemFour = new ProblemFour();
        Integer integerArray[] = {10,15,20,40,30};
        StringBuilder stringBuilder = problemFour.largestPosibleNo(Arrays.asList(integerArray));
        System.out.println("Largest posible Number: " + stringBuilder);
    }
}
