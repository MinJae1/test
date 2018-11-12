package ch13;

public class StorageImpl<T> implements Storage<T> {

	private T[] array;

	public StorageImpl(int num) {
		this.array = (T[]) (new Object[num]);
	}

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		array[index] = item;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return array[index];
	}

}
