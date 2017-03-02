package merte;

import java.util.Random;

public class Sorts {
	
	static long numComparison;
	static int[] array = new int[10];
	static int[] temp = new int[10];
	static long time;
	static Random rand = new Random();
	static int randomBound = 50;
	static boolean sorted;

	public static void main(String[] arg){
	
		Sorts.insert(array);
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
		numComparison = Sorts.mergesort(array);
		System.out.print("\n");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i]+" ");
		}
		sorted = Sorts.isSorted(array);
		System.out.print("\n"+sorted);
	}
	
	public static long merge(int temp[], int i, int m, int j) {

		int lowBound = i; 
		int n = j - lowBound + 1;
		int k = 0; 
		int mid = m - 1;

		while (i <= mid && m <= j) {
			if (array[i] < array[m]) {
				numComparison++;
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[m++];
			}
		}
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		while (m <= j) {
			temp[k++] = array[m++];
		}
		for (k = 0; k < n; k++) { // put the sorted temp array back into original
			array[lowBound + k] = temp[k];
		}
		return numComparison;
	}
	

	private static long mergesort(int temp[], int i, int j) {

		if (i == j) {
			return numComparison;
		} else {
			int mid = (i + j) / 2;
			mergesort(temp, i, mid);
			mergesort(temp, (mid + 1), j);
			
			merge(temp, i, (mid + 1), j);
		}
		return numComparison;

	}

	
	public static long mergesort(int[] a) {
		
		
		temp = new int[a.length];
		
		long startTime = System.nanoTime();
		
		mergesort(temp, 0, temp.length - 1);
		
        long finishTime = System.nanoTime();
        
        time = finishTime - startTime;
        
		return numComparison;
	}

	//create an array:
	
	public static void insert(int a[]) { // fill in any array with random ints

		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(randomBound)+1;

		}
	}
	
	public static boolean isSorted(int a[]){
	
		for (int i =1; i < a.length; i++){
			if (a[i-1]<= a[i]){
				continue;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
