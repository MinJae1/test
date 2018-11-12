
public class exam4_0828 {
public static void main(String[] args) {
	int square_add = 0;
	int add_square = 0;
	int add = 0;
	
	for (int i = 1; i < 101; i++) {
		square_add+=Math.pow(i,2);
	}
	
	for (int i = 1; i < 101; i++) {
		add += i;
	}
	add_square = (int)Math.pow(add,2);
	
	int divide;
	
	divide = add_square - square_add;
	
//	System.out.println(add);
//	System.out.println(add_square);
//	System.out.println(square_add);
	System.out.println(divide);
	
}
}
