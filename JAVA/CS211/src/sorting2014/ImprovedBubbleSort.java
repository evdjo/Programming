 
package sorting2014;

public class ImprovedBubbleSort implements Sorter {

	 
	@SuppressWarnings("unchecked")
	public void sort(Comparable[] items, int cutoff) {
		Comparable temp;
		for (int i = 0; i < items.length - 1; i++) {
			
			boolean isSorted=true;
			
			for (int j = 0; j < items.length - 1 - i; j++) {
				if (items[j].compareTo(items[j + 1]) > 0) {
					temp = items[j + 1];
					items[j + 1] = items[j];
					items[j] = temp;
					isSorted=false;
				}
			}
			
			if(isSorted)  {  break;  }  
			
		}
	}
}

