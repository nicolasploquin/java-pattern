package fr.eni.formation.geometrie.observer;

import java.util.LinkedList;
import java.util.List;

public class Observable {

    private List<Observer> observers = new LinkedList<>();

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
