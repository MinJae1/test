package ch13;

public class ChildProductMethode {
	public static void main(String[] args) {
		ChildProduct<Tv, String, String> pro = new ChildProduct<>();
		pro.setKind(new Tv());
		pro.setModel("Smart Tv");
		pro.setCompany("SamSung");

		Storage<Tv> storage = new StorageImpl<Tv>(100);
		storage.add(new Tv(), 0);
		Tv tv = storage.get(0);

	}
}
