package serenitylabs.tutorials.vetclinic.domain;

//Turned ofBreed method into interface, to make ofBreed parameter mandatory
    public interface WithBreed {
        WithColor ofBreed(String breed);

    }
