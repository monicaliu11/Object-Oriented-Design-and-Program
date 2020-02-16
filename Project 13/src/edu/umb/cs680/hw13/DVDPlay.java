package edu.umb.cs680.hw13;

public class DVDPlay implements State {

    private static DVDPlay instance = new DVDPlay();

    private State state;

    private DVDPlay() {
        state = DrawerClosedNotPlaying.getInstance();
    }

    public static DVDPlay getInstance() {
        return instance;
    }

    public void changeState(State state) {
        this.state = state;
    }

    @Override
    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    @Override
    public void playButtonPushed() {
        state.playButtonPushed();
    }

    @Override
    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void open() {
        System.out.println("DVD drawer opened.");
    }

    public void close() {
        System.out.println("DVD drawer closed.");
    }

    public void play() {
        System.out.println("DVD is playing.");
    }

    public void stop() {
        System.out.println("DVD stopped.");
    }
}
