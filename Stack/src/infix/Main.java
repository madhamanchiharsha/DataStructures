package infix;

public class Main {
	stack.Main stackObj = new stack.Main();
	String priorityOperators = "()-+/*";

	private int getPriority(char input) {
		// TODO Auto-generated method stub
		return priorityOperators.indexOf(input) > 0 ? priorityOperators.indexOf(input)/2: priorityOperators.indexOf(input);
	}
	
	private void infixToPostFix(String input) {
		// TODO Auto-generated method stub
		char [] inputArray = input.toCharArray();
		String output = "";
		for (char c : inputArray) {
			int priority = getPriority(c);
			String topStackElement = stackObj.peek();
			if(priority < 0) { // it is character
				output = output.concat(Character.toString(c));
				continue;
			}else if((topStackElement == null && priority > 0)|| (topStackElement != null && priority > getPriority(topStackElement.charAt(0))) || c == '(') {
				stackObj.push(Character.toString(c));
				continue;
			} else if(c == ')') {
				while(!stackObj.peek().equals("(")) {
					String ss= stackObj.pop();
					output = output.concat(ss);
				}
				stackObj.pop();
				continue;
			}else if((topStackElement != null && priority < getPriority(topStackElement.charAt(0)))) {
				output = output.concat(stackObj.pop());
				continue;
			} else {
				System.out.println("didnt go in any for char = "+ c);
			}
		}
		
		while(stackObj.peek() != null) {
			output = output.concat(stackObj.pop());
		}
		System.out.println("output is : "+output);
		
	}
	public static void main(String[] args) {
		Main obj = new Main();
		obj.infixToPostFix("a+b");
		obj.infixToPostFix("a+(b*c)");
		obj.infixToPostFix("a+b*c");
		
	}

}
