package com.huawei.classroom.student.lab4;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class main extends Thread{
	
	private double[][] A;
	private double[][] B;
	private int index;
	private int gap;
	private double[][] result;
	private CountDownLatch countDownLatch;
 
	public main(double[][] A, double[][] B, int index, int gap, double[][] result, CountDownLatch countDownLatch) {
		this.A = A;
		this.B = B;
		this.index = index;
		this.gap = gap;
		this.result = result;
		this.countDownLatch = countDownLatch;
	}
 
	// 计算特定范围内的结果
	public void run() {
		// TODO Auto-generated method stub
		for (int i = index * gap; i < (index + 1) * gap; i++)
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < B.length; k++)
					result[i][j] += A[i][k] * B[k][j];
			}
		// 线程数减1
		countDownLatch.countDown();
	}
	
	//串行
	static double[][] serial(double [][]A, double [][]B){
		double[][] serial_result = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++)
					serial_result[i][j] += A[i][k] * B[k][j];
			}
		}
		return serial_result;
	}
 
	public static void main(String[] args) throws InterruptedException {
		// 声明和初始化
		long startTime;
		long endTime;
		
		MatrixGenerator matrix1 = new MatrixGenerator();
		System.out.print("请输入所需要的矩阵1的行和列：");	//输入矩阵的阶数
		Scanner sc_A = new Scanner(System.in);
		int row_A = sc_A.nextInt();         //矩阵的行数
    	int col_A= sc_A.nextInt(); 	 
    	
    	MatrixGenerator matrix2 = new MatrixGenerator();
		System.out.print("请输入所需要的矩阵2的行和列：");
		Scanner sc_B = new Scanner(System.in);
		int row_B = sc_B.nextInt();     
    	int col_B= sc_B.nextInt(); 
    	matrix1.create_Matrix(row_B, col_B);
		double[][] A = matrix1.create_Matrix(row_A, col_A);
		double[][] B = matrix2.create_Matrix(row_B, col_B);
		
        //存放并行计算结果
		double[][] parallel_result = new double[A.length][B[0].length];
        //存放串行计算结果
		double[][] serial_result = new double[A.length][B[0].length];
        //子线程数量
		int threadNum = 10;
        //子线程的分片计算间隔
		int gap = A.length / threadNum;
		CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		// 并行计算
		startTime = System.currentTimeMillis();
		for (int i = 0; i < threadNum; i++) {
			main ct = new main(A, B, i, gap, parallel_result, countDownLatch);
			ct.start();
		}
		countDownLatch.await();
		endTime = System.currentTimeMillis();
		System.out.println("并行计算开始时刻:" + (startTime));
		System.out.println("并行计算结束时刻:" + (endTime));
		System.out.println("并行计算运行时间:" + (endTime - startTime));
 
		// 串行计算
		startTime = System.currentTimeMillis();
		serial_result = serial(A,B);
		endTime = System.currentTimeMillis();
		System.out.println("串行计算开始时刻:" + (startTime));
		System.out.println("串行计算结束时刻:" + (endTime));
		System.out.println("串行计算运行时间:" + (endTime - startTime));
	}

}
