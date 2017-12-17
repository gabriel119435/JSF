package domain;

import java.util.List;

public class Facade {
	Repo repo = new Repo();

	public void setText(String string) throws Exception {
		repo.insert(string);
	}

	public List<Message> getAll() throws Exception {
		return repo.all();
	}

	public void erase() throws Exception {
		repo.clear();
	}

}
