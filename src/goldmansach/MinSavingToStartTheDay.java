package goldmansach;

public class MinSavingToStartTheDay {
	
	public static void main(String args[]) {
		int arr[] = {4, -10, 4, 4, 4}; 
	    int n = arr.length; 
	    minEarning(arr);
	}

	
	private static void minEarning(int a[]) {
		int initMinEnergy = 0;
		int currEnergy = 0;
		boolean flag  = false;
		for(int i =0; i<a.length;i++) {
			currEnergy+=a[i];
			if(currEnergy<=0) {
				initMinEnergy+=Math.abs(currEnergy)+1;
				currEnergy = 1;
				flag = true;
			}
		}
		if(flag) {
			System.out.println("initial min energy: "+initMinEnergy);
		}else {
			System.out.println("initial energy required: "+1);
		}
		
	}
}
