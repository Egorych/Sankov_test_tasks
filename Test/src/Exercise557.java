import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise557 {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {

			String amountAndSizeOfMatrixes = reader.readLine();
			String[] amountAndSizeOfMatrixesSplit = amountAndSizeOfMatrixes.split(" ");

			String itemOfInterest = reader.readLine();
			String[] itemOfInterestSplit = itemOfInterest.split(" ");

			ArrayList<int[][]> allMatrixes = new ArrayList<int[][]>();
			int matrixAmount = Integer.valueOf(amountAndSizeOfMatrixesSplit[0]);
			int matrixSize = Integer.valueOf(amountAndSizeOfMatrixesSplit[1]);
			int resultRow = Integer.valueOf(itemOfInterestSplit[0]) - 1;
			int resultColoumn = Integer.valueOf(itemOfInterestSplit[1]) - 1;

			int[][] matrix;
			String pStr = reader.readLine();
			int p = Integer.valueOf(pStr);

			for (int i = 0; i < matrixAmount; i++) {
				String emptyLine = reader.readLine();
				matrix = new int[matrixSize][matrixSize];
				for (int j = 0; j < matrixSize; j++) {

					String rowOfMatrix = reader.readLine();
					String[] rowOfMatrixSplit = rowOfMatrix.split(" ");
					for (int k = 0; k < matrixSize; k++) {
						matrix[j][k] = Integer.valueOf(rowOfMatrixSplit[k]);
					}
				}
				allMatrixes.add(matrix);
			}

			int copyOfMatrix[][] = allMatrixes.get(0);
			int resultMatrix[][] = new int[matrixSize][matrixSize];

			for (int i = 1; i < allMatrixes.size(); i++) {

				int row = resultRow;
				for (int column = 0; column < matrixSize; column++) {
					resultMatrix[row][column] = 0;
					for (int sourceColumn = 0; sourceColumn < matrixSize; sourceColumn++) {
						resultMatrix[row][column] += copyOfMatrix[row][sourceColumn]
								* allMatrixes.get(i)[sourceColumn][column];
					}
					if ((resultMatrix[row][column] > 0 && resultMatrix[row][column] >= p)
							|| (resultMatrix[row][column] < 0 && resultMatrix[row][column] <= p)) {
						resultMatrix[row][column] %= p;
					}
				}

				for (int k = 0; k < matrixSize; k++) {
					copyOfMatrix[row][k] = resultMatrix[row][k];
				}
			}

			System.out.println(copyOfMatrix[resultRow][resultColoumn]);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
