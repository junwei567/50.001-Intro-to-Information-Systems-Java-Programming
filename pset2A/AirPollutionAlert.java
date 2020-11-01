package pset2A;

public class AirPollutionAlert implements Subject {
    private double airPollutionIndex;

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        if (this.airPollutionIndex > 100) notifyObservers();
    }
    private java.util.ArrayList<Observer> observers = new java.util.ArrayList<Observer>();

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
        for (Observer o: observers) o.update(airPollutionIndex);
    }
}


