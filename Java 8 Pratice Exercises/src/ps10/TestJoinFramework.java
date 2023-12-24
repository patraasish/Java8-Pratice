package ps10;

import java.util.concurrent.ForkJoinPool;

public class TestJoinFramework {

	public static void main(String[] args) {
		int[] array = new int[10000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MaxFinderTask maxFinderTask = new MaxFinderTask(array, 0, array.length);

        int result = forkJoinPool.invoke(maxFinderTask);

        System.out.println("Max value of the array: " + result);

	}

}
