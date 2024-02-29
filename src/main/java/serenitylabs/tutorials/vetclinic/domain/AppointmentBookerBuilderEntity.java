package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDateTime;

public class AppointmentBookerBuilderEntity {

	private final String petName;
	private String owner;
	private String reason;

	public AppointmentBookerBuilderEntity(String petName) {
           this.petName = petName;
       }

	public AppointmentBookerBuilderEntity ownedBy(String owner) {
		this.owner = owner;
		return this;
	}

	public AppointmentBookerBuilderEntity because(String reason) {
		this.reason = reason;
		return this;
	}

	public AppointmentEntity at(LocalDateTime appointmentTime) {
		return new AppointmentEntity(petName, owner, appointmentTime, reason);
	}

}