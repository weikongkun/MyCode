package com.sort;

import java.util.Random;

import javax.security.auth.kerberos.KerberosKey;

/*
 * 排序算法
 */
public class ArraySort{
	//====================================================
	/*
	 * 冒泡排序
	 */
	public static void BubbleSort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}
	//====================================================
	/*
	 * 选择排序
	 */
	public static void SelectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j])
					index = j;
			}
			swap(arr, i, index);
		}
	}
	//====================================================
	/*
	 * 插入排序
	 */
	public static void InsertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] >= arr[j - 1]) break;
				else swap(arr, j, j - 1);
			}
		}
	}
	//====================================================
	/*
	 * 归并排序
	 */
	public static void MergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		MergeSort(arr, 0, arr.length - 1, temp);
	}
	private static void MergeSort(int[] arr, int lo, int hi, int[] temp) {
		if (lo >= hi) return;
		int mid = (lo + hi) / 2;
		MergeSort(arr, lo, mid, temp);
		MergeSort(arr, mid + 1, hi, temp);
		merge(arr, lo, mid, hi, temp);
	}
	private static void merge(int[] arr, int lo, int mid, int hi, int[] temp) {
		int x1 = lo;
		int x2 = mid + 1;
		//合并到temp数组
		for (int i = lo; i <= hi; i++) {
			if (x2 > hi) temp[i] = arr[x1++];
			else if (x1 > mid) temp[i] = arr[x2++];
			else if (arr[x1] <= arr[x2]) temp[i] = arr[x1++];
			else temp[i] = arr[x2++];
		}
		//复制到原数组
		for (int i = lo; i <= hi; i++) {
			arr[i] = temp[i];
		}
	}
	//====================================================
	/*
	 * 快速排序
	 */
	public static void QuickSort(int[] arr) {
		QuickSort(arr, 0, arr.length - 1);
	}
	private static void QuickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) return;
		int p = partition(arr, lo, hi);
		QuickSort(arr, lo, p - 1);
		QuickSort(arr, p + 1, hi);
		
	}
	private static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int num = arr[lo];
		while (true) {
			while (arr[++i] < num) if (i == hi) break;
			while (arr[--j] >= num) if (j == lo) break;
			if (i >= j) break;
			swap(arr, i, j);
		}
		swap(arr, lo, j);
		return j;
	}
	
	//====================================================
	/*
	 * 希尔排序
	 */
	public static void ShellSort(int[] arr) {
		int N = arr.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (arr[j - h] <= arr[j]) break;
					else swap(arr, j, j - h);
				}
			}
			h /= 3;
		}
	}
	//====================================================
	/*
	 * 堆排序
	 */
	public static void HeapSort(int[] arr) {
		//建堆，从右往左一半下沉
		int N = arr.length;
		for (int i = N / 2 - 1; i >= 0; i--) {
			sink(arr, i, N);
		}
		//交换堆顶元素和最后一个元素
		while (N > 1) {
			swap(arr, 0, N - 1);
			N--;
			sink(arr, 0, N);
		}
		
	}
	private static void sink(int[] arr, int j, int N) {
		while (2 * j + 1 <= N - 1) {
			int i = 2 * j + 1;
			if (i < N - 1 && arr[i] < arr[i + 1]) i++;
			if (arr[j] >= arr[i]) break;
			swap(arr, i, j);
			j = i;
		}
	}
	
	//======================================================
	/*
	 * 交换
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i] ^ arr[j];
		arr[i] = temp ^ arr[i];
		arr[j] = temp ^ arr[i];
	}
//=========================================================================	
	//测试
	private static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1]) 
				return false;
		return true;
	}
	public static void main(String[] args) {
		int[] arr = new int[20];
		//冒泡排序======================================
		Random random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		BubbleSort(arr);
		System.out.println("冒泡排序：" + isSorted(arr));
		for (int i: arr)
			System.out.print(i + " ");
		System.out.println();
		//选择排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		SelectSort(arr);
		System.out.println("插入排序：" + isSorted(arr));
		for (int i: arr)
			System.out.print(i + " ");
		System.out.println();
		//插入排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		InsertSort(arr);
		System.out.println("插入排序：" + isSorted(arr));
		for (int i: arr)
			System.out.print(i + " ");
		System.out.println();
		//归并排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		MergeSort(arr);
		System.out.println("归并排序：" + isSorted(arr));
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		// 快速排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		QuickSort(arr);
		System.out.println("快速排序：" + isSorted(arr));
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		// 希尔排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		ShellSort(arr);
		System.out.println("希尔排序：" + isSorted(arr));
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		// 堆排序=====================================
		random = new Random(100);
		for (int i = 0; i < arr.length; i++)
			arr[i] = random.nextInt(100);
		HeapSort(arr);
		System.out.println("堆排序：" + isSorted(arr));
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
