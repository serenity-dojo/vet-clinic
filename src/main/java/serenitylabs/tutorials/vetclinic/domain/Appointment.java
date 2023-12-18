package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;
import java.util.Optional;

public class Appointment {
    private final String petName;
    private final String owner;
    private final LocalDateTime appointmentTime;
    private final Optional<String> reason;

    public static AppointmentBooker forPetCalled(String petName) {
        return new AppointmentBooker(petName);
    }

    public Appointment(String petName, String owner, LocalDateTime appointmentTime, String reason) {
        this.petName = petName;
        this.owner = owner;
        this.appointmentTime = appointmentTime;
        this.reason = Optional.ofNullable(reason);
    }
//    public Appointment(LocalDateTime appointmentTime) {
//        this.appointmentTime = appointmentTime;
//    }

    public Appointment(String petName, String owner, LocalDateTime appointmentTime) {
        this(petName, owner, appointmentTime, null);
    }
    public boolean isBefore(LocalDateTime dateTime) {
        return appointmentTime.isBefore(dateTime);
    }
    public boolean isAfter(LocalDateTime dateTime) {
        return appointmentTime.isAfter(dateTime);
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

    public static class AppointmentBooker {
        private final String petName;
        private String owner;
        private String reason;

        public AppointmentBooker(String petName) {
            this.petName = petName;
        }
        public AppointmentBooker ownedBy(String owner) {
            this.owner = owner;
            return this;
        }

        public Appointment at(LocalDateTime appointmentTime) {
            return new Appointment(petName, owner, appointmentTime,reason);
        }

        public AppointmentBooker because(String reason) {
            this.reason = reason;
            return this;
        }
    }
}
