import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Sort {
	
	private int a[] = new int[20];
	
	public Sort(){
		this.initializearray();
	}
	public void initializearray(){
		this.a = new int[] {6 , 5, 3, 9, 2, 8, 11, 1, 19, 56, 5};
	}
	public void printArray(){
		System.out.println();
		for(int i :a){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public void bubbleSort(){
		int temp;
		boolean flag; //optimization
		for(int i=0;i<a.length-1;i++){
			flag = false;
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					flag = true;
				}
			}
			if(!flag)
				break;
		}
	}
	public void selectionSort(){
		int minIndex, temp;
		for(int i=0;i<a.length-1;i++){
			minIndex = i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<a[minIndex])
				{
					minIndex = j;
				}
			}
			if(minIndex != i)
			{
				temp = a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}
		}
	}
	//super efficient for smaller arrays //insert current element in an array sorted to the left.
	public void insertionSort(){
		int j, key;
		for(int i=1;i<a.length;i++){
			key = a[i];
			j = i-1;
			while(j >= 0 && a[j]>key){
				a[j+1] = a[j];
				j-=1;
			}
			a[j+1] = key;
		}
	}
	//O(nlgn), stable, but auxiliary space!!impreove by setting a cutoff and then implementing smaller with insertion sort...
	public void mergeSort(int l, int r, int[] aux){
		if(l<r){
			//middle
			int m = l + (r-l)/2;
			//sort left and right
			mergeSort(l, m, aux);
			mergeSort(m+1, r, aux);
			//merge sorted arrays
			merge(l, m, r, aux);
		}
	}
	public void merge(int l, int m, int r, int[] aux){
		for(int i=0;i<a.length;i++){
			aux[i] = a[i];
		}
		//iterators
		int i=l, j=m+1, k=l;
		//merge
		while(i<=m && j<= r){
			if(aux[i] <= aux[j]){
				a[k] = aux[i++];
			}else{
				a[k] = aux[j++];
			}
			k++;
		}
		while(i<=m){
			a[k++] = aux[i++];
		}
		//right part already there since we are merging in place
	}
	
	//O(nlgn) avg case and O(n2) worst case, in place but not stable, improve by randomizing pivot
	public void quickSortCaller(){
		quickSort(a, 0, a.length-1);
	}
	private void quickSort(int[] a, int l, int r){
		if(l<r){
			int p = partition(a, l, r);
			//before partition
			quickSort(a, l, p-1);
			//after partition
			quickSort(a, p+1, r);
		}
	}
	private int partition(int[] a, int l, int r){
		//randomize strategy could be used to increase perf
		int pivot = a[r];
		int i = l - 1, tmp;
		for(int j = l; j< r; j++){
			if(a[j] <= pivot){
				i++;
				tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		tmp = a[r];
		a[r] = a[i+1];
		a[i+1] = tmp;
		return i+1;
	}
	//Binary Max Heap - a special Complete BST, Array based repressentatin (space efficient)
	//In place, not stable, O(nlgn), not great for practical purposes
	public void heapSort(){
		int n = a.length, tmp;
		//build a heap..heapify all internal nodes
		for(int i = n/2-1; i>=0; i--){
			heapify(a, n, i);
		}
		//remove max and heapify the root
		for(int i=n-1; i>=0; i--){
			tmp = a[i];
			a[i] = a[0];
			a[0] = tmp;
			
			//heapify root of the reduced MAX heap
			heapify(a, i, 0);
		}
	}
	//heapify the subtree rooted with i
	public void heapify(int[] a, int n, int i){
		int maxIndex = i, tmp;
		int l = 2*i +1; //left child index
		int r = 2*i +2; //right child index
		
		if(l<n && a[l] > a[maxIndex])
			maxIndex = l;
		if(r<n && a[r] > a[maxIndex])
			maxIndex = r;
		//if not same swap root with largest element
		if(maxIndex != i){
			tmp = a[i];
			a[i] = a[maxIndex];
			a[maxIndex] = tmp;
			//heapify the new node and below
			heapify(a, n, maxIndex);
		}
		
	}
}
