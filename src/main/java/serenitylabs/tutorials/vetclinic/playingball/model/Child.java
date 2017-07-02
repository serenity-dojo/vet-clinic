package serenitylabs.tutorials.vetclinic.playingball.model;

import static serenitylabs.tutorials.vetclinic.playingball.model.Game.*;

public class Child {

    public void goPlay(Game game) {
        if (game == Football) {
            System.out.print("Kick the ball");
        } else if (game == Tennis) {
            System.out.print("Serve the ball");
        } else if (game == Cricket) {
            System.out.print("Hit the wicket");
        } else if (game == Handball) {
            System.out.print("Throw the ball");
        } else if (game == Hockey) {
            System.out.print("Hit the ball with the stick");
        }
    }
}
