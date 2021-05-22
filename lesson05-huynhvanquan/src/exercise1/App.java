package exercise1;

public class App {
	public static void main(String[] args) {
		int[] numList = new int[]{3, 15, 21, 0, 15, 17, 21};
		int[] result = new int[getUniqueNumbers(numList).length];
		result = getUniqueNumbers(numList);
		printArray(result);
	}
	private static int[] getUniqueNumbers(int[] numList) {
		int[] temp = new int[numList.length];
		int[] result;
		int count = 0;
		boolean check;
		
		for(int i = 0; i < numList.length; i++) {
			check = true;
			for(int j = 0; j < numList.length; j++) {
				if(i == j) {
					continue;
				}
				if(numList[i] == numList[j]) {
					check = false;
					break;
				}
			}
			if(check == true) {
				temp[count++] = numList[i];
			}

		}
		
		result = new int[count];
		for(int i = 0; i < count; i++) {
			result[i] = temp[i];
		}
		sortAccending(result);
		return result;
	}
	private static void sortAccending(int[] numList) {
		for(int i = 0; i < numList.length; i++) {
			for(int j = i + 1; j < numList.length; j++) {
				if (numList[i] > numList[j]) {
					int temp = numList[i];
					numList[i] = numList[j];
					numList[j] = temp;
				}
			}
		}
	}
	private static void printArray(int[] numList) {
		for(int i = 0; i < numList.length; i++) {
			System.out.print(numList[i] + " ");
		}
	}
}
