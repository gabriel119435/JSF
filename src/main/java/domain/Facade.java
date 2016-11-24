package domain;

import java.util.ArrayList;
import java.util.List;

public class Facade {
	Repo repo = new Repo();

	public void setText(String string) throws Exception {
		repo.insert(string);
	}

	public List<Message> getAll() throws Exception {
		List<Message> list = new ArrayList<Message>();
		try {
			list = repo.all();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("failed to receive entire table");
		}
		return list;
	}

	public void erase() throws Exception {
		repo.delete();
	}

}
