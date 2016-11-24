package domain;

public class Message {

	private String text;

	public Message(String t) {
		this.setText(t);
	}

	public Message() {
	}

	public String getText() {
		return text;
	}

	public void setText(String t) {
		this.text = t;
	}

}
