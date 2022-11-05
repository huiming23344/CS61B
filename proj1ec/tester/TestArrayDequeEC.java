package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

public class TestArrayDequeEC {
    @Test
    /**
     * randomized testing
     */
    public void randomTest() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        assertTrue(test.isEmpty());
        assertTrue(solution.isEmpty());
        int times = 100000;
        for (int i = 0; i < times; i++) {
            System.out.println("test time:" + i);
            int operationCode = StdRandom.uniform(0, 5);
            System.out.println("opcode: " + operationCode);
            if (operationCode == 0 || test.size() == 0) {
                // test the add func
                int toBeAdd = StdRandom.uniform(0, 100);
                test.addFirst(toBeAdd);
                solution.addFirst(toBeAdd);
                assertEquals(test.size(), solution.size());
            } else if (operationCode == 1) {
                int toBeAdd = StdRandom.uniform(0, 100);
                test.addFirst(toBeAdd);
                solution.addFirst(toBeAdd);
                assertEquals(test.size(), solution.size());
            } else if (operationCode == 2) {
                // test the remove func
                int num_stu = test.removeFirst();
                int num_sol = solution.removeFirst();
                assertEquals(num_sol, num_stu);
                assertEquals(test.size(), solution.size());
            } else if (operationCode == 3) {
                assertEquals(test.size(), solution.size());
                int size = solution.size();
                int sol = solution.removeLast();
                int sul = test.removeLast();

//                if (test.removeLast() == null) {
//                    System.out.println("it is null");
//                    test.addLast(666);
//                    int a = test.removeLast();
//                    assertEquals(a, 666);
//                }
                assertEquals(test.size(), solution.size());
                System.out.println("it worked before?");
            } else if (operationCode == 4) {
                // test get func
                int Index = StdRandom.uniform(0, test.size());
                int stu = test.get(Index);
                int sol = solution.get(Index);
                assertEquals(stu, sol);
                assertEquals(test.size(), solution.size());
            }
        }
    }
}
