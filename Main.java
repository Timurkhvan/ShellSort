import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        countOfIterations();
        countOfTime();

    }

    public static int shellSort(int[] array) {
        int countShell = 0;
        for(int step = array.length/2; step > 0; step = step / 2) {
            for(int pass = step; pass < array.length; pass++) {
                for(int replacment = pass - step; replacment >= 0 && array[replacment] > array[replacment + step]; replacment -= step) {
                    int item = array[replacment];
                    array[replacment] = array[replacment + step];
                    array[replacment + step] = item;
                    countShell++;

                }
            }
        }
        return countShell;
    }


    private static int[] readDataFromFile(int numberOfFile) {
        String fileName = "input_set_" + numberOfFile + ".txt";
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        int[] numArray = new int[numbers.size()];

        for (int i = 0; i < numbers.size(); i++) {
                numArray[i] = numbers.get(i);
            }
        return numArray;
        }

    public static void countOfIterations() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("count_of_iterations.txt"));
        for (int i = 0; i < 100; i++) {
            int[] currentArray = readDataFromFile(i);
            int countOfIterations = shellSort(currentArray);
            writer.write(Integer.toString(currentArray.length) + " " +Integer.toString(countOfIterations));
            writer.newLine();
        }
        writer.close();

    }

    private static void countOfTime() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("count_of_time.txt"));
        for (int i = 0; i < 100; i++) {
            int[] currentArray = readDataFromFile(i);
            long startTime = System.nanoTime();
            shellSort(currentArray);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            writer.write(Integer.toString(currentArray.length) + " " +Long.toString(duration));
            writer.newLine();
        }
        writer.close();
    }

}

