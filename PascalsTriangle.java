import java.util.Scanner;
public class PascalsTriangle {

	public static void main(String[] args) {
		
		Scanner robot = new Scanner(System.in);
		System.out.println("Please input number of rows for Pascal's Triangle:");
		int numberRows = robot.nextInt();
		
		System.out.println("First Triangle:");
		
		int[][] triangleElements = pascalsTriangle(numberRows);
		
		for (int i = 0; i < numberRows; i++){
			for (int j = 0; j < numberRows; j++){
				if (triangleElements[i][j] == 0){
					System.out.print("\t");
					} else {
					System.out.print(triangleElements[i][j]);
					System.out.print("\t");
					}
				}
			System.out.println();
		}
		
		System.out.println("Second Triangle:");
			
		int[][] secondTriangle = alternativePascalsTriangle(numberRows);
		
		for (int x = 0; x < numberRows; x++){
			
			for (int y = 0; y < numberRows; y++){
				if (secondTriangle[x][y] == 0){
					System.out.print("\t");
				} else {
					System.out.print(secondTriangle[x][y]);
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		
		robot.close();
	}
	
	public static int[][] pascalsTriangle(int numberRows){
		
		int[][] triangleElements = new int[numberRows][numberRows];
	
		for (int i = 0; i < numberRows; i++){
			for (int j = 0; j < numberRows; j++){
				if (j == i || j == 0){
					triangleElements[i][j] = 1;
				} else if (j > i){
					triangleElements[i][j] = 0;
				} else {
					triangleElements[i][j] = triangleElements[i-1][j-1] + triangleElements[i-1][j];  
				}	 
			}	
		}
		return triangleElements;
	}

	// Reference: https://en.wikipedia.org/wiki/Pascal%27s_triangle
	public static int[][] alternativePascalsTriangle(int numberRows){
		
		int [][] secondTriangle = new int[numberRows][numberRows];
		
		for (int i = 0; i < numberRows; i++){
			for (int j = 0; j < numberRows; j++){
				if (j == 0){
					secondTriangle[i][j] = 1;
				} else {
				secondTriangle[i][j] = secondTriangle[i][j-1] * (i + 1 - j) / j;
				}
			}
		}
		return secondTriangle;
	}
		
}
