package stacks;

class CheckBalancedChallenge {
	public static boolean isBalanced(String exp) {
		Stack<Character> stack = new Stack(exp.length());

		for (int i = 0; i < exp.length(); i++) {
			Character currentchar = exp.charAt(i);
			Character topChar = null;

			if (currentchar == '{' || currentchar == '(' || currentchar == '[')
				stack.push(currentchar);
			else if (stack.top() == null) {
				return false;
			} else {
				topChar = stack.top();

				if (topChar == '{' && currentchar != '}')
					return false;
				else if (topChar == '(' && currentchar != ')')
					return false;
				else if (topChar == '[' && currentchar != ']')
					return false;
				else
					stack.pop();
			}
		}

		return (stack.isEmpty() == true);
	}

	public static void main(String args[]) {

		//System.out.println(isBalanced("{[()]}"));
		//System.out.println(isBalanced("[{(}]"));
		System.out.println(isBalanced("{[}]()"));
		System.out.println(isBalanced("{{[[}}}]"));

	}
}
