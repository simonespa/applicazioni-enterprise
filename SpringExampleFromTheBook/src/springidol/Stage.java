package springidol;

public class Stage {

	private static final Stage INSTANCE = new Stage();
	
	private Stage() {
	}
	
	public static Stage getInstance() {
		return INSTANCE;
	}
	
}