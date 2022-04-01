package  com.shanjiancaofu.interview;

public class AutoInectmentOpration {
	public static void main(String[] args) {
		int i = 1;
		i = i++;
		// i = 1
		int j = i++;
		// j = 1
		// i = 2
		int k = i + (++i * i++);
		//  k = 2 + 3 * 3
		// i = 4
		// j = 1
		System.out.println("i=" + i);
		System.out.println("j=" + j);
		System.out.println("k=" + k);


/*		int i1 = 0;
		int j1 = i1++;
		// j1= 0, i1 = 1
		System.out.println("j1 = " + j1 + ",i1 = " + i1);*/
	}
}
