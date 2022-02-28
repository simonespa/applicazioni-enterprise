package ae.spring.bean.three;

public class MyObject {

	private String field;

	public String getField() {
		return field;
	}

	public void setField(final String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "MyObject [field=" + field + "]";
	}

}