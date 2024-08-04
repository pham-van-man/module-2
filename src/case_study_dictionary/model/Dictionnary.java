package case_study_dictionary.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public abstract class Dictionnary implements Serializable, Comparable<Dictionnary> {
    private String words;
    private String definition;

    public Dictionnary(String words, String definition) {
        this.words = words;
        this.definition = definition;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionnary that = (Dictionnary) o;
        return Objects.equals(words, that.words);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(words);
    }

    @Override
    public String toString() {
        return "Dictionnary{" +
                "words='" + words + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Dictionnary o) {
        return this.words.compareTo(o.words);
    }
}
