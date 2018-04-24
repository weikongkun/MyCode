package JianZhiOffer;

public class Eg14_RecorderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5};
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		solution(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		int[] array1 = {1, 2, 3, 4, 5};
		solution2(array1);
		
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		
		
	}
	
	private static void solution(int[] array) {
		int p1 = 0, p2 = array.length - 1; 
		while (p1 < p2) {
			while (array[p1] % 2 == 1 && p1 < p2)
				p1++;

			while (array[p2] % 2 == 0 && p1 < p2)
				p1--;
			
			if (p1 < p2) {
				int temp = array[p1];
				array[p1] = array[p2];
				array[p2] = temp;
			}
		}
		
	}
	
	private static void solution2(int[] array) {
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1 && i - index > 0) {
				int num = array[i];
				int j = i; 
				for (; j > index; j--) {
					array[j] = array[j - 1];
				}
				array[index] = num;
				index++;
			}
			else if (array[i] % 2 == 1 && i == index)
				index++;
		}
	}

}
