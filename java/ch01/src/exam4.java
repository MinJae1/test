
public class exam4 {
	public static void main(String[] args) {
		String input[] = { "0123456789", "01234", "01234567890", "6789012345", "012322456789" };
		int cntArray[] = new int[10];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length(); j++) {
				switch (input[i].charAt(j)) {
				case '0':
					++cntArray[0];
					break;
				case '1':
					++cntArray[1];
					break;
				case '2':
					++cntArray[2];
					break;
				case '3':
					++cntArray[3];
					break;
				case '4':
					++cntArray[4];
					break;
				case '5':
					++cntArray[5];
					break;
				case '6':
					++cntArray[6];
					break;
				case '7':
					++cntArray[7];
					break;
				case '8':
					++cntArray[8];
					break;
				case '9':
					++cntArray[9];
					break;

				default:
					break;
				}

			}
			
//			System.out.println(cntArray.length);

//			for (int k = 0; k < cntArray.length; k++) {
//				if (cntArray[k] == 1) {
//					cnt++;
////									}
//			}

		}

//		if (cnt == 10) {
//			System.out.println("true");
//		}

	}
}
