import java.util.Arrays;

import javax.swing.text.StyledEditorKit.BoldAction;


public class Search {

	private int a[] = new int[20];
	
	public Search(){
		this.initializearray();
	}
	public void initializearray(){
		this.a = new int[] {6 , 5, 3, 9, 2, 8, 11, 1, 19, 56, 5};
	}
	public boolean linear(int n) {
		for(int e: a){
			if(e == n)
				return true;
		}
		return false;
	}
	public boolean binary(int n) {
		Arrays.sort(a);
		int l = 0, h = a.length-1;
		int mid;
		while(l<=h){
			mid = l + (h-l)/2;
			if(n > a[mid]){
				l = mid+1;
			}
			else{
				h = mid-1;
			}
			if(a[mid] == n)
				return true;
		}
		return false;
	}
	
	
	
}
