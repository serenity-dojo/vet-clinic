package serenitylabs.tutorials.vetclinic.domain;
import java.time.LocalDateTime;
import java.util.Optional;

public class AppointmentEntity {

	private final String petName;
	private final String owner;
	private final LocalDateTime appointmentTime;
	private final Optional<String> reason;
	
	public AppointmentEntity(String petName, String owner, LocalDateTime appointmentTime,String reason) {
		this.petName = petName;
		this.owner = owner;
		this.appointmentTime = appointmentTime;
		this.reason = Optional.ofNullable(reason);
	}

	public AppointmentEntity(String petName, String owner, LocalDateTime appointmentTime) {
		this(petName, owner, appointmentTime, null);
	}

	public String getPetName() {
		return petName;
	}

	public String getOwner() {
		return owner;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public Optional<String> getReason() {
		return reason;
	}
	
	public boolean isBefore(LocalDateTime isBeforeLocatDt)
	{
	return true;
	}
	
	public boolean isAfter(LocalDateTime isAfterLocatDt)
	{
	return true;
	}
	
	
	public static AppointmentBookerBuilderEntity forPetCalled(String petName) {
		return new AppointmentBookerBuilderEntity(petName);

	}
	  
}