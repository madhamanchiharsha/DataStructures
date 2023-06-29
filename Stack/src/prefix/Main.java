package prefix;


public class Main {

	stack.Main stackObj = new stack.Main(); 
	String priorityOperators = "-+*/^";

	private int getPriority(char input) {
		// TODO Auto-generated method stub
		return priorityOperators.indexOf(input) >= 0 ? priorityOperators.indexOf(input)/2: priorityOperators.indexOf(input);
	}

	
	private String prefixToInfix(String input) {
		// TODO Auto-generated method stub
		char [] inputArr = input.toCharArray();
		for(int i = inputArr.length-1 ; i>=0 ; i--) {
			if(getPriority(inputArr[i])>=0) {
				if(stackObj.peek() == null) {
					System.out.println("Stack is Empty something Wrong with input");
				}				
				String element1 = stackObj.pop();
				String element2 = stackObj.pop();
				stackObj.push("("+element1+Character.toString(inputArr[i])+element2+")");
			} else {
				stackObj.push(Character.toString(inputArr[i]));
			}
		}
		return stackObj.pop();
	}
	public static void main(String[] args) {
		Main obj = new Main();
		System.out.println(obj.prefixToInfix("*+AB-CD"));
	}
}
