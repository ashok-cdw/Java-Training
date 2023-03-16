/*
 * Without exception, 
 * when return line comes, finally block will be executed after that it returns to mth2 function call
 * 
 * output:
 * 
 * finally-mth2
 * caller
 * 
 * -------------------------
 * With exception, 
 * before return line comes, catch block will be executed,then finally block gets executed 
 * after that it returns to mth2 function call
 * 
 * output:
 * 
 * catch-mth2
 * finally-mth2
 * caller
 * 
 * */
class Sample {
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			int n = 2 / 0;
			return;
		} catch (Exception e) {
			System.out.println("catch-mth2");
		} finally {
			System.out.println("finally-mth2");
		}
	}

	public static void main(String[] args) {
		Sample s = new Sample();
		s.mth1();
	}
}
