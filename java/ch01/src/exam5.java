public class exam5 {
	public static void main(String[] args) {
		int cntArray[] = new int[10];

		for (int i = 1; i < 1001; i++) {
			String str_i = i + "";
			for (int j = 0; j < str_i.length(); j++) {
//				System.out.println(str_i.charAt(j));
				switch (str_i.charAt(j)) {
				case '0':
					++cntArray[0];
					break;
				case '1':
					++cntArray[1];
//					System.out.println(i);
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
		}

		for (int j = 0; j < cntArray.length; j++) {
			System.out.println(j + " - " + cntArray[j] + "°³");
		}
	}

}
