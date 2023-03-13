class Student {
	String name;
	int rollno;

	public Student(String name, int rollno) {
		this.name = name;
		this.rollno = rollno;
	}
}

class Exam extends Student {
	double mark1, mark2, mark3;

	public Exam(String name, int rollno, double mark1, double mark2, double mark3) {
		super(name, rollno);
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}
}

class Result extends Exam {
	public Result(String name, int rollno, double mark1, double mark2, double mark3) {
		super(name, rollno, mark1, mark2, mark3);
	}

	double totalmarks;

	double totalmarks() {
		totalmarks += mark1 + mark2 + mark3;
		return totalmarks;
	}

	public static void main(String[] args) {
		Result resultObj = new Result("Ashok N", 2033, 95, 96, 97);
		System.out.println("Name : " + resultObj.name);
		System.out.println("Roll No : " + resultObj.rollno);
		System.out.println("Total Marks	: " + resultObj.totalmarks());
	}
}