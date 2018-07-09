package observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList observers = new ArrayList<>();//±£´æObserver
	
	public void addObserver(Observer observer) {//×¢²áObserver
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		Iterator it = observers.iterator();
		while (it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	public abstract int getNumber();
	public abstract void execute();
}
