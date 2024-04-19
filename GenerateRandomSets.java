import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateRandomSets {
    private static final int numSets = 100;
    private static final int minSize = 100;
    private static final int maxSize = 10000;


    public static void main(String[] args) {

            for (int i = 0; i < numSets; i++) {
                int arraySize = generateRandomNumberInRange(minSize, maxSize);
                int[] array = generateRandomArray(arraySize);

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("input_set_" + i + ".txt"));
                    for(int num: array) {
                        writer.write(Integer.toString(num));
                        writer.newLine();
                    }
                    writer.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }
            }
    }

        public static int[] generateRandomArray(int size) {
            Random random = new Random();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = random.nextInt();
            }
            return array;
        }

        public static int generateRandomNumberInRange(int min, int max) {
            Random random = new Random();
            return random.nextInt(max - min + 1) + min;
        }


}
