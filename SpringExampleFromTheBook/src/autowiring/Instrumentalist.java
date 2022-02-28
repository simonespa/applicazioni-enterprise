package autowiring;

public class Instrumentalist implements Performer {

	private Instrument instrument;
	
	public Instrumentalist(Instrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public void perform() {
		instrument.play();
	}

}
