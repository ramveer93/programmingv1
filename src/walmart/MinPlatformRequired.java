package walmart;

/**
 * https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 * https://www.youtube.com/watch?v=38JLfQGVlkw
 * 
 * @author sramveer
 *
 */
public class MinPlatformRequired {

	public static void main(String args[]) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(minTrainPlatformBruteForce(arr, dep));
		System.out.println(optimal(arr, dep));
	}

	private static int minTrainPlatformBruteForce(int arr[], int dep[]) {
		int result = 1;
		int platformNeeded = 1;
		for (int i = 0; i < arr.length; i++) {
			platformNeeded = 1;

			for (int j = i + 1; j < dep.length; j++) {

				if (arr[i] >= arr[j] && arr[i] <= dep[j] || arr[j] >= arr[i] && arr[j] <= dep[i]) {
					platformNeeded++;

				}
				result = Math.max(result, platformNeeded);

			}

		}
		return result;

	}

	private static int optimal(int arr[], int dep[]) {

		int plat_needed = 1, result = 1;
		int i = 1, j = 0;
		while (i < arr.length && j < arr.length) {

			if (arr[i] <= dep[j]) {
				i++;
				plat_needed++;

			} else if (arr[i] > dep[j]) {
				j++;
				plat_needed--;

			}
			result = Math.max(plat_needed, result);
		}

		return result;
	}

}
