
package assignment3_class;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class Foothill extends Exception
{
	final static int MAT_SIZE = 800;

	// -------  proof of correctness --------------
	public static void main(String[] args) throws Exception
	{

		long startTime, stopTime;
		double smallPercent;
		NumberFormat tidy = NumberFormat.getInstance(Locale.US);
		tidy.setMaximumFractionDigits(4);

		smallPercent = (MAT_SIZE * MAT_SIZE) / 10;

		ArrayList<Location> locations = new ArrayList<Location>();

		while (locations.size() < smallPercent){
			Location l = new Location(randInt(),randInt());
			if(!locations.contains(l)){
				locations.add(l);
			}
		}
		// non-sparse matrices
		double[][] mat, matAns;

		mat = new double[MAT_SIZE][MAT_SIZE];
		matAns = new double[MAT_SIZE][MAT_SIZE];
		
		for (Location loc: locations){
			mat[loc.getRow()][loc.getCol()] = randDouble();
		}
				
		matShow(mat, MAT_SIZE - 10, 10);

		startTime = System.nanoTime();
		matMult(mat, mat, matAns);
		stopTime = System.nanoTime();
		System.out.println();
		matShow(matAns, MAT_SIZE - 10, 10);

		System.out.println("\nSize = " + MAT_SIZE + " Mat. Mult. Elapsed Time: "
				+ tidy.format( (stopTime - startTime) / 1e9)
				+ " seconds.");
	}

	private static double randDouble(){
		double d = Math.random();
		return d;
	}
	private static int randInt(){
		Random rand = new Random();
		int i = rand.nextInt(MAT_SIZE);
		return i;
	}

	public static void matMult(
			double[][] matA, double[][] matB, double[][]matC){
		if (matA[0].length != matB[0].length){
			throw new IllegalArgumentException(
					"Matrix dimension incompatible.");
		}
		for (int i = 0; i < matA.length; i++){
			for (int j = 0; j < matB[0].length; j++){
				for (int k = 0; k < matA[0].length; k++){
					matC[i][j] += (matA[i][k] * matB[k][j]);
				}
			}
		}
	}
	public static void matShow(double[][] matA, int start, int size){
		if (start < 0 || start > MAT_SIZE ||
				start + size < MAT_SIZE || size < 1){
			throw new IllegalArgumentException(
					"Display dimensions incompatible.");
		}
		DecimalFormat format = new DecimalFormat("#0.00");
		for (int i = start; i < start + size; i++){
			for (int j = start; j < start +size; j++){
				System.out.print(format.format(matA[i][j]) + " ");
				if (j == start + size -1){
					System.out.print("\n");
				}
			}
		}
	}
}
class Location{
	private int row; 
	private int col;

	public Location(int row, int col){
		if (row < 0 || col < 0 ||
				row >= Foothill.MAT_SIZE || col >= Foothill.MAT_SIZE){
			throw new IllegalArgumentException(
					"Location instance values incompatible.");
		}
		this.row = row;
		this.col = col;
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
	@Override
	public boolean equals(Object o){
		if(o instanceof Location){
			Location l = (Location) o;
			return (this.row == l.row && this.col == l.col);
		}	
		return false;
	}
}
