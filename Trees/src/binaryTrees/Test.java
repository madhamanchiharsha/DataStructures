package binaryTrees;


interface ITest{
	static void harsha() {
		System.out.println("Harsha from ITest");
		//t();
	}
	private  void t() {
		
	}
}

class parent {
	void harsha () {
		System.out.println("Harsha from parent");
	}
	
}

class child implements ITest{
	int x_child = 2;
	final int x =0;
	public void harsha() {
		System.out.println("Harsha from child");
	}
}

public class Test extends child {
	final int x = 0;

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		child c = new child();
		c.harsha();
		ITest.harsha();
		//System.out.println();
	}

}

