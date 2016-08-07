package serenitylabs.tutorials.vetclinic;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class BuilderExamples {
    @Test
    public void a_string_builder_concatenates_strings() {
        // Given
        StringBuilder stringBuilder = new StringBuilder();

        // When
        String deepThought = stringBuilder.append("The answer")
                                          .append(" is ")
                                          .append(42)
                                          .toString();

        // Then
        assertThat(deepThought, equalTo("The answer is 42"));
    }

    @Test
    public void a_guava_splitter() {
        // When
        List<String> names =
                Splitter.on(",")
                        .omitEmptyStrings()
                        .trimResults()
                        .splitToList("Alfred, Billie,,Charlie ");

        // Then
        assertThat(names, hasItems("Alfred", "Billie", "Charlie"));
    }

}
