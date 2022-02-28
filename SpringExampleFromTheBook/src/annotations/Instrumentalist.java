package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("eddie")
public class Instrumentalist implements Performer {

	@Autowired
	private Instrument instrument;

	public Instrumentalist() {
	}

	@Override
	public void perform() {
		instrument.play();
	}

}
