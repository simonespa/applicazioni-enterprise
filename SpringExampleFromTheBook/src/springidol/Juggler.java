package springidol;

public class Juggler implements Performer {

	private int beanBags;
	
	public Juggler() {
		this.beanBags = 3;
	}
	
	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("JUGGLING " + beanBags + " BEANBAGS");
	}

}
