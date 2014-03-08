package sorting2014;

public class SelectionSort implements Sorter{

	
	
	
	public void sort(Comparable[] items, int cutoff) {
		
		selectionSort(items);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public void selectionSort(Comparable[] items) {
	int min;
		for ( int i = 0 ; i < items.length ; i ++ ) {
			
			 min =  i; 
			 
			 for ( int j = i+1; j < items.length; j ++) {
				 
				 if(items[min].compareTo(items[j]) > 0  ) {
					 min = j ;
					 
				 }
  				 
			 }
			 if (min != i) {
				 
				Comparable temp = items[i];
				items[i] = items[min];
				items[min] = temp ;
				 
			 }
			
			
		}
		
	}
	 

}