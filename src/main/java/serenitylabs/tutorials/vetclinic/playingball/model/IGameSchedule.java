package serenitylabs.tutorials.vetclinic.playingball.model;
import java.time.LocalDate;

public interface IGameSchedule {

	IPlayBall forGameOn(LocalDate someDay);

}