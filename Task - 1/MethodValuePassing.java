public class MethodValuePassing {
	public static void main(String[] args) {

		Quantity q = new Quantity();
		ValuePassing vp = new ValuePassing();
		System.out.println("Call By Value (Before Passing): " + q.size);
		vp.CallByValue(q.size);
		System.out.println("Call By Value (After Passing): " + q.size);

		System.out.println("Call By Reference (Before Passing): " + q.size);
		vp.CallByReference(q);
		System.out.println("Call By Reference (After Passing) : " + q.size);

		System.out.println("Array (Before Passing): ");
		for (int i : q.arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		vp.ArrayPassing(q.arr);
		System.out.println("Array (After Passing): ");
		for (int i : q.arr) {
			System.out.print(i + " ");
		}

	}
}

class Quantity {
	int size = 6;

	int arr[] = { 1, 2, 3, 4, 5 };

}

class ValuePassing {
	void CallByValue(int size) {
		size = 12;
	}

	void CallByReference(Quantity q) {
		q.size = 12;
	}

	void ArrayPassing(int arr[]) {
		arr[0] = 100;
		arr[1] = 200;
	}
}