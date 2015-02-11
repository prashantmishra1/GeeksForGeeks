package geeks.matrix;

public class CircularMatrix {
	
	public void printCurcularMatrix(int arr[][], int rows, int cols){
		int m=rows, n=cols;
		int k=0, l=0;
		
		while(k < m && l < n){
			for(int i = k; i<n; i++){
				System.out.print(arr[k][i] + " ");
			}
			
			k++;
			
			for(int j=k; j<n; j++){
				System.out.print(arr[j][n-1] + " ");
			}
			
			n--;
			
			for(int i = n-1; i>=l; i--)
				System.out.print(arr[n][i] + " ");
			
			m--;
			
			for(int j = m-1;  j >=k; j--)
				System.out.print(arr[j][l] + " ");
			
			l++;
		}
	}
	
	public void printMatrix(int arr[][], int rows, int cols){
		for(int x=0; x<rows; x++){
			for(int y=0; y<cols; y++)
				System.out.print(arr[x][y] + "\t");
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		int rows, cols;
		rows = 5;
		cols = 5;
		int arr[][] = new int[rows][cols];
		for(int x=0; x<rows; x++)
			for(int y=0; y<cols; y++)
				arr[x][y] = y+(x*cols);
		
		CircularMatrix obj = new CircularMatrix();
		obj.printMatrix(arr, rows, cols);
		obj.printCurcularMatrix(arr, rows, cols);
		
	}

}

