package pset2A;

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
