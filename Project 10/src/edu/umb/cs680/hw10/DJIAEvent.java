package edu.umb.cs680.hw10;

public class DJIAEvent {
    private float djia;

    public DJIAEvent(float djia) {
        this.djia = djia;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + djia;
    }
}
