package ch13;

public class Box<T> {
//	private Object obj;
//
//	public void setObj(Object obj) {
//		this.obj = obj;
//	}
//
//	public Object getObj() {
//		return obj;
//	}

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
