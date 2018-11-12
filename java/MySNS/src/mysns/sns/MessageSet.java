package mysns.sns;

import java.util.ArrayList;

public class MessageSet {
	private MessageDO messageDO;
	private ArrayList<Reply> rlist;

	public MessageDO getMessageDO() {
		return messageDO;
	}

	public void setMessageDO(MessageDO messageDO) {
		this.messageDO = messageDO;
	}

	public ArrayList<Reply> getRlist() {
		return rlist;
	}

	public void setRlist(ArrayList<Reply> rlist) {
		this.rlist = rlist;
	}

}
