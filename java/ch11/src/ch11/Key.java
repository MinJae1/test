package ch11;

public class Key {
	public int number;

	public Key(int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Key) {
			Key compareKey = (Key) obj;
			if (this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}
}
