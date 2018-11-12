package ex07;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	java.util.List<Board> list = new ArrayList<Board>();

	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		list.add(new Board("title1", "content1"));
		list.add(new Board("title2", "content2"));
		list.add(new Board("title3", "content3"));

		return list;
	}

}
