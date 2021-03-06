package sorting_algorithms;
@SuppressWarnings({"unchecked","rawtypes"})
 
/**
 *  Shell sort.
 * @author Evdzhan Mustafa enm3@aber.ac.uk
 *
 */
public class ShellSort implements Sorter {

	private Comparable[] items ;
	@Override
	public void sort(Comparable[] items, int cutoff) {
	
		this.items = items ;
		shellsort();

	}

	/**
	 * Sorts the array items.
	 * The sorting happens by using the same strategy as insertion sort,
	 * but using a gap value to let value move quicker to their correct position.
	 * After a iteration, with gap value N , every Nth value is in correct position,
	 * relative to the  (N - N)th and (N + N)th  value.	
	 *  After this iteration the array is said to be N sorted.
	 * This repeats for each gap value, which eventually drops down to one,
	 * when the sorting essentially becomes a bubble/insertion sort.
	 * 
	 * @param items The sorted array
	 */
	
	private void shellsort() {

		 
		
		for (int gap = items.length / 2 ; gap > 0; ) { //initial gap 1/2 size of the array

			for (int i = gap; i < items.length; ++i) { 
				
				Comparable temp = items[i];  //copy the value of the currently compared item

				    int o; // initial shift value, continually decremented by the gap later on
				
				for (o = i; o >= gap; o -= gap) { // continually shift values by the current gap

					if (temp.compareTo(items[o - gap]) > 0) { 
						break;  //  stop shifting 
					}
					items[o] = items[o - gap]; // shift to the left by the gap value
				}

				items[o] = temp; // put the temp in the current position

			}
			gap = gap == 2 ? 1: (int) ( gap / 2.2); // decrement the gap by some factor 
			                // eventually this will become 1, thus becoming a bubble/insertion sort
		}
	}

}
