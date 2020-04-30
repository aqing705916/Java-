package com.huawei.classroom.student.lab4;

public class MatrixGenerator {
	
	public static double random_number(){
    	double number;
    	number = new java.util.Random().nextDouble()+1.0;
    	//生成1.0~100.0的随机数
    	return number;
    }
	
	public static double[][] create_Matrix(int row_number, int column_number ) {		 
		double matrixA[][] = new double[row_number][column_number];
		for (int i = 0; i <= row_number - 1; i++) {
			for (int j = 0; j <= column_number - 1; j++) {
				matrixA[i][j] = random_number();
				//System.out.print(matrixA[i][j] + " ");
			}
			//System.out.println();
		}
		return matrixA;
	}
}
