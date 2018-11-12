package ch15;

import java.util.Vector;

public class VectorExam {
	public static void main(String[] args) {
		java.util.List<Board> list = new Vector<Board>();

		list.add(new Board("title1", "content1", "author1"));
		list.add(new Board("title2", "content2", "author2"));
		list.add(new Board("title3", "content3", "author3"));
		list.add(new Board("title4", "content4", "author4"));
		list.add(new Board("title5", "content5", "author5"));

		list.remove(2);
		list.remove(3);

		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println(
					board.sub + "\t" + board.content + "\t" + board.writer);
		}
	}
}
