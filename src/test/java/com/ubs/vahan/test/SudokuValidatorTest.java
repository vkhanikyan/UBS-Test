package com.ubs.vahan.test;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * if the nested classes start to be bigger and more complex they can be moved to separate files
 */
@RunWith(Enclosed.class)
public class SudokuValidatorTest {


    @RunWith(Parameterized.class)
    public static class ValidateTest {

        @Parameterized.Parameters(name = "{0}")
        public static Collection<Object[]> data() {
            int[][] validBoard1 = new int[][]{
                    {9, 0, 4, 0, 6, 0, 7, 0, 1},
                    {0, 2, 0, 4, 0, 3, 0, 8, 0},
                    {8, 0, 0, 0, 0, 0, 0, 0, 4},
                    {0, 0, 1, 8, 4, 9, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 2, 5, 7, 9, 0, 0},
                    {4, 0, 0, 0, 0, 0, 0, 0, 7},
                    {0, 8, 0, 6, 0, 4, 0, 5, 0},
                    {5, 0, 6, 0, 8, 0, 2, 0, 3}
            };

            int[][] validBoard2 = new int[][]{
                    {3, 1, 4, 0, 6, 0, 7, 0, 0},
                    {0, 2, 0, 4, 0, 3, 0, 8, 0},
                    {8, 0, 0, 0, 0, 0, 0, 0, 4},
                    {0, 0, 1, 8, 4, 9, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 2, 5, 7, 9, 0, 0},
                    {4, 0, 2, 0, 3, 0, 0, 0, 7},
                    {0, 8, 0, 6, 0, 4, 0, 5, 0},
                    {5, 0, 6, 0, 8, 0, 2, 0, 3}
            };

            int[][] invalidBoard1 = new int[][]{
                    {9, 0, 4, 0, 6, 0, 7, 0, 1},
                    {0, 2, 0, 4, 0, 3, 0, 8, 0},
                    {8, 0, 0, 0, 0, 0, 0, 0, 4},
                    {0, 0, 1, 8, 4, 9, 6, 1, 0}, // we have two ones in one row
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 2, 5, 7, 9, 0, 0},
                    {4, 0, 0, 0, 0, 0, 0, 0, 7},
                    {0, 8, 0, 6, 0, 4, 0, 5, 0},
                    {5, 0, 6, 0, 8, 0, 2, 0, 3}
            };
            // we have two 4s on the 3rd column. Start the calculation from 0
            int[][] invalidBoard2 = new int[][]{
                    {9, 0, 4, 0, 6, 0, 7, 0, 1},
                    {0, 2, 0, 4, 0, 3, 0, 8, 0},
                    {8, 0, 0, 0, 0, 0, 0, 0, 4},
                    {0, 0, 1, 8, 4, 9, 6, 0, 0},
                    {0, 0, 0, 4, 0, 0, 0, 0, 0},
                    {0, 0, 3, 2, 5, 7, 9, 0, 0},
                    {4, 0, 0, 0, 0, 0, 0, 0, 7},
                    {0, 8, 0, 6, 0, 4, 0, 5, 0},
                    {5, 0, 6, 0, 8, 0, 2, 0, 3}
            };

            int[][] invalidBoard3 = new int[][]{
                    {9, 0, 4, 0, 6, 0, 7, 0, 1},
                    {0, 2, 0, 4, 0, 3, 0, 8, 0},
                    {8, 0, 0, 0, 3, 0, 0, 0, 4}, // there are two 3s on the second 3x3 sub-square
                    {0, 0, 1, 8, 4, 9, 6, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 2, 5, 7, 9, 0, 0},
                    {4, 0, 0, 0, 0, 0, 0, 0, 7},
                    {0, 8, 0, 6, 0, 4, 0, 5, 0},
                    {5, 0, 6, 0, 8, 0, 2, 0, 3}
            };


            return Arrays.asList(new Object[][]{
                    {"valid board 1", validBoard1, true},
                    {"valid board 2", validBoard2, true},
                    {"invalid board 1", invalidBoard1, false},
                    {"invalid board 2", invalidBoard2, false},
                    {"invalid board 3", invalidBoard3, false},
            });
        }

        @Parameterized.Parameter
        public String name;

        @Parameterized.Parameter(1)
        public int[][] data;

        @Parameterized.Parameter(2)
        public boolean isValid;

        @Test
        public void validate() {
            assertEquals(isValid, SudokuValidator.isValid(data));
        }

    }

    @RunWith(Parameterized.class)
    public static class IsUniqueTest {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 2, 3}, true},
                    {new int[]{1, 2, 3, 987, 654, 321, 5, 6, 7}, true},
                    {new int[]{-1, -2, 3, -987, -654, -321, -5, 6, 7}, true},
                    {new int[]{1, 2, 3, 1}, false},
                    {new int[]{1, 1, 2, 3, 4, 5, 156, 56}, false},
                    {new int[]{-1, -1, 2, -3, 4, -5, 156, 56}, false},
                    {new int[]{1, 2, 3, 456, 789, 123, 456}, false},
                    {new int[]{1, 2, -3, -456, 789, -123, -456}, false},
            });
        }

        @Parameterized.Parameter
        public int[] data;

        @Parameterized.Parameter(1)
        public boolean isUnique;

        @Test
        public void isUnique() {
            assertEquals(isUnique, SudokuValidator.isUnique(data));
        }
    }
}