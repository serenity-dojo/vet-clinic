package serenitylabs.tutorials.vetclinic.collections.katas;
import java.util.LinkedList;
import java.util.Queue;
import org.testng.annotations.Test;
import serenitylabs.tutorials.vetclinic.katas.PetEntity;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWorkingWithAPetQueueTests {

	@Test
	public void should_add_Fido_to_the_end_of_the_queue() {
		Queue<PetEntity> waitingList = new LinkedList<>();

		waitingList.add(PetEntity.cat().named("Felix"));
		waitingList.add(PetEntity.dog().named("Fido"));

		PetEntity nextInLine = waitingList.poll();

		// TODO
		assertThat(nextInLine.getName(), equalTo("Felix"));
	System.out.println("\nStep-1 - TC-01 - Executing - should_add_Fido_to_the_end_of_the_queue()");
	}

	
	@Test
	public void should_see_who_is_at_the_top_of_the_queue_without_removing_it() {
		Queue<PetEntity> waitingList = new LinkedList<>();

		waitingList.add(PetEntity.cat().named("Felix"));
		waitingList.add(PetEntity.dog().named("Fido"));

		PetEntity nextInLine = waitingList.peek();

		// TODO
		assertThat(nextInLine.getName(), equalTo("Felix"));
	System.out.println("\nStep-2 - TC-02 - Executing - should_see_who_is_at_the_top_of_the_queue_without_removing_it()");
	}

}