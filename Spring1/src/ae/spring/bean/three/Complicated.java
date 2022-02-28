package ae.spring.bean.three;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Complicated {

	private List<String> list;
	private Map<String, Double> map;
	private Set<MyObject> set;

	public List<String> getList() {
		return list;
	}

	public Map<String, Double> getMap() {
		return map;
	}

	public Set<MyObject> getSet() {
		return set;
	}

	public void setList(final List<String> list) {
		this.list = list;
	}

	public void setMap(final Map<String, Double> map) {
		this.map = map;
	}

	public void setSet(final Set<MyObject> set) {
		this.set = set;
	}

}