package springidol;

public class Instrumentalist implements Performer {

	private String song;
	private Instrument instrument;
	
	public Instrumentalist() {
		System.out.println();
	}
	
	public String getSong() {
		return song;
	}
	
	public void setSong(String song) {
		this.song = song;
	}
	
	public Instrument getInstrument() {
		return instrument;
	}
	
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.print("Playing " + song + " with ");
		instrument.play();
	}

}
