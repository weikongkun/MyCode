package JianZhiOffer;

public class Eg36_InversePairs {
	private static int[] aux;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 5, 6, 4};
		System.out.println(InversePairs(arr));
	}
	
	public static int InversePairs(int[] array) {
		aux = new int[array.length];
		
		return mergeSort(array, 0, array.length - 1);
	}
	public static int mergeSort(int[] arr, int lo, int hi) {
		if (lo >= hi) return 0;
		int mid = lo + (hi - lo) / 2;
		int a = mergeSort(arr, lo, mid);
		int b = mergeSort(arr, mid + 1, hi);
		int c = merge(arr, lo, mid, hi);
		return a + b + c;
	}
	public static int merge(int[] arr, int lo, int mid, int hi) {
		
		int num = 0;
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = arr[k];
		for (int k = lo; k <= hi; k++)
			if (i > mid) arr[k] = aux[j++];
			else if (j > hi) arr[k] = aux[i++];
			else if (aux[i] <= aux[j]) arr[k] = aux[i++];
			else {
				arr[k] = aux[j++];
				num = num + (mid - i + 1);
			}
		return num;
	}

}
