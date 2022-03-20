package com.shanjiancaofu.study;

public class Queue8 {

	//定义一个max表示共有多少个皇后
	int max = 8;
	//定义数组array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
	int[] array = new int[max];
	static long count = 0;
	static int judgeCount = 0;

	public static void main(String[] args) {
		//测试一把 ， 8皇后是否正确
		long start = System.currentTimeMillis();
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		/*System.out.printf("一共有%d解法", count);
		System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
		System.out.println("耗时: " + (System.currentTimeMillis() - start));*/
	}

	//编写一个方法，放置第n个皇后
	//特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
	public void check(int n) {
		if (n == max) {  //n = 8 , 其实8个皇后就既然放好
			print();
			return;
		}

		//依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			//先把当前这个皇后 n , 放到该行的第1列
			array[n] = i;
			//判断当放置第n个皇后到i列时，是否冲突
			if (judge(n)) { // 不冲突
				//接着放n+1个皇后,即开始递归
				check(n + 1); //
			}
			//如果冲突，就继续执行 array[n] = i; 即将第n个皇后，放置在本行得 后移的一个位置
		}
	}


	//查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突

	/**
	 * 冲突返回false, 不冲突true
	 *
	 * @param n 表示第n个皇后
	 * @return
	 */
	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			// 说明
			//1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列

			// 例子说明上面的判断
			// 假设arr[8] = {0,4,7,5,2,6,1,3}
			// 加入 arr[0] = arr[1]
			// 就是说第一行的第一列 = 0   (坐标 [0,0]
			// 第二行的第一列也等于 = 0, 当等于= 0 的时候, 那岂不是 arr[1] 也在第一行 ?(坐标[1,0]
			// 第三行的第一列也等于 = 0, 当等于= 0 的时候, 那岂不是 arr[2] 也在第一行 ?(坐标[2,0]


			//2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
			// n = 1  放置第 2列 1 n = 1 array[1] = 1
			// Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1

			// 假设arr[8] = {0,4,7,5,2,6,1,3}
			// 加入 arr[0] = arr[1]
			// 就是说第一行的第一列 = 0   (坐标 [0,0]
			// 第二行的第一列也等于 = 1, 当等于= 0 的时候, 那岂不是 arr[1] 也在第一行 ?(坐标[1,1]

			// 假设 array[0] = 1,array[1]= 2 ,array[3] = 3 , 是否满足下面的关系 ?
//			Math(1-0) == Math.abs(array[1]-array[0 ]) = 1
//			Math.abs(2-0) = Math.ab(array[2]-array[0]) = 2
//			Math.abs(3-0) = Math.ab(array[3]-array[0]) = 3


			//3. 判断是否在同一行, 没有必要，n 每次都在递增
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	//写一个方法，可以将皇后摆放的位置输出
	private void print() {
		count++;
		/*System.out.println("--------------------------------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}*/
	}

}
