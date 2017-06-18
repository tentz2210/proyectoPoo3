package mycar.library;

import java.util.List;

public abstract class Observable {
	protected List<IObserver> observers;
	protected short state;

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(IObserver observer) {
		observers.add(observer);
	}

	protected void notifyAllObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
