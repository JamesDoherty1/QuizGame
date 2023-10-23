package EPICGame;

public class Main {

    public static void main(String[] args) {

        IDandPasswords idandPasswords = new IDandPasswords();

        LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

    }
}


import java.util.Random;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(1000000);

        // Record the start time before sorting
        long startTime = System.currentTimeMillis();

        // Perform Bubble Sort
        bubbleSort(numbers);

        // Record the end time after sorting
        long endTime = System.currentTimeMillis();

        // Calculate the execution time for sorting
        long executionTime = endTime - startTime;

        // Print the sorting time in milliseconds
        System.out.println("Sorting time: " + executionTime + " milliseconds");
    }

    public static int[] generateRandomNumbers(int count) {
        int[] randomNumbers = new int[count];
        Random random = new Random();

        // Generate random integers and store them in the array
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextInt();
        }

        return randomNumbers;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    // Swap arr[i-1] and arr[i]
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            // Reduce the range for the next pass
            n--;
        } while (swapped);
    }
}
