package ch15;

import java.util.Stack;

public class StackExam {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();

		coinBox.push(new Coin(10));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(500));

		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("Coin Value : " + coin.getValue());
		}
	}
}
