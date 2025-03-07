import java.util.ArrayList;
import java.util.List;

public class Exercises {

    /*
        there is an array of positive integers as input of function and another integer for the target value
        all the algorithm should do is to find those two integers in array which their multiplication is the target
        then it should return an array of their indices
        e.g. {1, 2, 3, 4} with target of 8 -> {1, 3}

        note: you should return the indices in ascending order and every array's solution is unique
    */
    public int[] productIndices(int[] values, int target) {

        // todo
        for(int i=0 ; i<value.length ; i++){
            for(int j=0 ; j<i ; j++){
                int result= value[i]*value[j];
                if(result==target) System.out.println("{"+j+", "+i+"}");
            }
        }
        return null;
    }

    /*
        given a matrix of random integers, you should do spiral traversal in it
        e.g. if the matrix is as shown below:
        1 2 3
        4 5 6
        7 8 9
        then the spiral traversal of that is:
        {1, 2, 3, 6, 9, 8, 7, 4, 5}

        so you should walk in that matrix in a curl and then add the numbers in order you've seen them in a 1D array
    */
    public int[] spiralTraversal(int[][] values, int rows, int cols) {
        // todo
        int top = 0, bottom = cols - 1, left = 0, right = rows - 1;
        System.out.print("{");
        int sum=0;

        // Keep looping until we’ve covered the whole matrix
        while (top <= bottom && left <= right) {
           
            for (int i = left; i <= right; ++i) {
                System.out.print(values[top][i]);

                sum++;
                if(sum<=rows) System.out.print(",");
                
            }
            top++;// Move the top boundary down
            
    
            
            for (int i = top; i <= bottom; ++i) {
                System.out.print(values[i][right]);
                System.out.print(",");
            }
            right--;// Move the right boundary left
           
    
            
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    System.out.print(values[bottom][i]);
                    System.out.print(",");
                }
                bottom--;// Move the bottom boundary up
            }
            
            
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    
                    System.out.print(values[i][left]);
                    System.out.print(",");

                   
                }
                
               
            }
                left++;// Move the left boundary right
        }
        System.out.print("}");
        
    
    
        return null;
    }

    /*
        integer partitioning is a combinatorics problem in discreet maths
        the problem is to generate sum numbers which their summation is the input number

        e.g. 1 -> all partitions of integer 3 are:
        3
        2, 1
        1, 1, 1

        e.g. 2 -> for number 4 goes as:
        4
        3, 1
        2, 2
        2, 1, 1
        1, 1, 1, 1

        note: as you can see in examples, we want to generate distinct summations, which means 1, 2 and 2, 1 are no different
        you should generate all partitions of the input number and

        hint: you can measure the size and order of arrays by finding the pattern of partitions and their number
        trust me, that one's fun and easy :)

        if you're familiar with lists and arraylists, you can also edit method's body to use them instead of array
    */
    public int[][] intPartitions(int n)
        {
            List<List<Integer>> result = new ArrayList<>();

            partitionGeneration(n, n, new ArrayList<>(), result);

            // Convert the list of lists to an array
            int[][] finalResult = new int[result.size()][];
            for (int i = 0; i < result.size(); i++)
            {
                finalResult[i] = new int[result.get(i).size()];
                for (int j = 0; j < result.get(i).size(); j++)
                {
                    finalResult[i][j] = result.get(i).get(j);
                }
            }
            return finalResult;
        }

        // Recursive function for partition generation
        private void partitionGeneration(int n, int max, List<Integer> current, List<List<Integer>> result)
        {
            if (n == 0)
            {
                result.add(new ArrayList<>(current)); // Add the current partition to the result
                return;
            }

            // Iterate from max to 1 to generate unique partitions
            for (int i = Math.min(max, n); i >= 1; i--)
            {
                current.add(i);
                partitionGeneration(n - i, i, current, result);
                current.remove(current.size() - 1);
            }
        }

    public static void main(String[] args) {
        // you can test your code here
    }
}
