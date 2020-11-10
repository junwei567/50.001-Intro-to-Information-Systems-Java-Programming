package q3;
import java.util.ArrayList;

//starting code
public class TemperatureAlert implements Subject {
    private int temperature;
    private ArrayList<Observer> observers = new ArrayList<>();

    public TemperatureAlert() {
//        if (this.temperature > 35 || this.temperature < 10) notifyObservers();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers) {
            o.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if (this.temperature > 35 || this.temperature < 10) notifyObservers();
    }



}
