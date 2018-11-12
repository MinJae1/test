
public class exam3 {
	public static void main(String[] args) {
		int sec_time = 0;
//		int time = 0;

		for (int i = 0; i < 24; i++) {
			if (i % 10 == 3) {
				sec_time += 60 * 60;
			} else {
				for (int j = 0; j < 60; j++) {
					if (j / 10 == 3) {
						sec_time += 60;
//						System.out.println(j);
					} else {
						if (j % 10 == 3) {
							sec_time += 60;
//							System.out.println(j);
						}
					}
//					System.out.println(sec_time);
				}
			}
		}

//		sec_time += time;

		System.out.println(sec_time + "ÃÊ");
	}
}
