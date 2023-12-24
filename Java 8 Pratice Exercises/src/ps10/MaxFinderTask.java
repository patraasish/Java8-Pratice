package ps10;

import java.util.concurrent.RecursiveTask;

public class MaxFinderTask extends RecursiveTask<Integer>{
	
	 private static final int THRESHOLD = 1000;
	    private int[] array;
	    private int start, end;

	    public MaxFinderTask(int[] array, int start, int end) {
	        this.array = array;
	        this.start = start;
	        this.end = end;
	    }

	    @Override
	    protected Integer compute() {
	        if (end - start <= THRESHOLD) {
	            int max = Integer.MIN_VALUE;
	            int rangeStart = start;
	            int rangeEnd = end;

	            for (int i = start; i < end; i++) {
	                if (array[i] > max) {
	                    max = array[i];
	                    rangeStart = i;
	                    rangeEnd = i + 1;
	                }
	            }

	            System.out.println("Max value found: " + max + ", range: " + rangeStart + "-" + rangeEnd);
	            return max;
	        } else {
	            int mid = start + (end - start) / 2;

	            MaxFinderTask leftTask = new MaxFinderTask(array, start, mid);
	            MaxFinderTask rightTask = new MaxFinderTask(array, mid, end);

	            invokeAll(leftTask, rightTask);

	            int leftResult = leftTask.join();
	            int rightResult = rightTask.join();

	            return Math.max(leftResult, rightResult);
	        }
	    }
}
