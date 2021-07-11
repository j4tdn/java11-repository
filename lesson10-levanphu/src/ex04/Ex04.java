package ex04;


	import utils.Utils;

	public class Ex04 {
		public static void main(String[] args) {
			int[] array = {1,5,2,7,4,6,18,21,9,22,13};
			System.out.println("BubbleSort" );
			Utils.printf(bubbleSort(array));
			System.out.println("SelectionSort");
			Utils.printf(selectionSort(array));
			System.out.println("InsertionSort");
			Utils.printf(insertionSort(array));
			
	
		}
		private static int[] bubbleSort(int a[]){
			for (int i = a.length-1; i >= 1; i--){
				boolean swapped= true;
				for (int j = 0; j < i; j++){
					if (a[j] > a[j+1]){
						int temp = a[j];
						a[j] = a[j+1];
						a[j+1] = temp;
						swapped = false;
					}
				}
				if (swapped){
					break;
				}
			}
			return a;
		}
		private static int[] selectionSort(int a[]){
			int Min;
			for (int i = 0; i < a.length-1; i++){
				Min = i;
				for (int j = i+1; j < a.length; j++){
					if (a[Min] > a[j]){
						Min = j;
					}
				}
				if (i != Min){
					int temp = a[i];
					a[i] = a[Min];
					a[Min] = temp;
				}
			}
			return a;
		} 
		private static int[] insertionSort(int a[]){
			int index, value;
			for (int i = 1; i < a.length; i++){
				index = i;
				value = a[i];
				while (index > 0 && a[index - 1] > value){
					a[index] = a[index - 1];
					index --;
				}
				a[index] = value;
			}
			return a;
		} 
		
		
}
