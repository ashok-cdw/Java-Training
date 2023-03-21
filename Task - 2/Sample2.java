/*
 * Without exception, 
 * System.exit() will be executed and program will be terminated
 * 
 * output:
 * No Output
 * 
 * -------------------------
 * With exception, 
 * before System.exit() comes, catch block will be executed,then finally block gets executed 
 * after that it returns to mth2 function call
 * 
 * output:
 * 
 * catch-mth2
 * finally-mth2
 * caller
 * 
 * */
class Sample2 {
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			int n = 2 / 0;
			System.exit(0);
		} catch (Exception e) {
			System.out.println("catch-mth2");
		} finally {
			System.out.println("finally-mth2");
		}
	}

	public static void main(String[] args) {
		Sample2 s = new Sample2();
		s.mth1();
	}
}
