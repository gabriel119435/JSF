package controler;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import domain.Facade;
import domain.Message;

@ManagedBean
@ApplicationScoped
public class UnicoBean {
	Facade facade = new Facade();

	public void setText(String s) throws Exception {
		facade.setText(s);
		this.warn();
	}

	public String getText() {
		return "";
	}

	public List<Message> getAll() throws Exception {
		return facade.getAll();
	}

	public void erase() throws Exception {
		facade.erase();
		this.warn();
	}

	public void test() {
		System.out.println("bean called on jsf");
	}

	public void warn() {
		System.out.println("warned");
	}

}
