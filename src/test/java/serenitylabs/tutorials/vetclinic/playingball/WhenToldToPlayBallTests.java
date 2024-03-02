package serenitylabs.tutorials.vetclinic.playingball;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static serenitylabs.tutorials.vetclinic.playingball.model.GameEnum.Cricket;
import static serenitylabs.tutorials.vetclinic.playingball.model.GameEnum.Football;
import static serenitylabs.tutorials.vetclinic.playingball.model.GameEnum.Handball;
import static serenitylabs.tutorials.vetclinic.playingball.model.GameEnum.Hockey;
import static serenitylabs.tutorials.vetclinic.playingball.model.GameEnum.Tennis;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.playingball.model.ChildEntity;

public class WhenToldToPlayBallTests {

	private ByteArrayOutputStream output = new ByteArrayOutputStream();

	@Before
	public void setOutput() {
		System.setOut(new PrintStream(output));
		System.out.println("\nTC-01 - executing - setOutput()");
	}

	@Test
	public void child_should_play_cricket_if_asked() {
		ChildEntity bill = ChildEntity.getChildEntity();
		bill.goPlay(Cricket);
		assertThat(output.toString(), equalTo("Hit the wicket"));
		System.out.println("\nTC-02 - executing - child_should_play_cricket_if_asked() ");
	}

	@Test
	public void child_should_play_tennis_if_asked() {
		ChildEntity bill = ChildEntity.getChildEntity();
		bill.goPlay(Tennis);
		assertThat(output.toString(), equalTo("Serve the ball"));
		System.out.println("\nTC-03 - executing - child_should_play_tennis_if_asked() ");
	}

	@Test
	public void child_should_play_football_if_asked() {
		ChildEntity bill = ChildEntity.getChildEntity();
		bill.goPlay(Football);
		assertThat(output.toString(), equalTo("Kick the ball"));
		System.out.println("\nTC-04 - executing - child_should_play_football_if_asked() ");
	}

	@Test
	public void child_should_play_handball_if_asked() {
		ChildEntity bill = ChildEntity.getChildEntity();
		bill.goPlay(Handball);
		assertThat(output.toString(), equalTo("Throw the ball"));
		System.out.println("\nTC-05 - executing - child_should_play_handball_if_asked()");
	}

	@Test
	public void child_should_play_hockey_if_asked() {
		ChildEntity bill = ChildEntity.getChildEntity();
		bill.goPlay(Hockey);
		assertThat(output.toString(), equalTo("Hit the ball with the stick"));
		System.out.println("\nTC-06 - executing - child_should_play_hockey_if_asked()");
	}

}