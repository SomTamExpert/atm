package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class ApplicationCounter {
    private int countOverall = 0;
    private int countOpenSessions = 0;

    public int getCountOverall() {
        return countOverall;
    }

    public void incrementOverall() {
        countOverall++;
    }

    public void incrementSession() {
        countOpenSessions++;
    }

    public void decrementSession() {
        countOpenSessions--;
    }

    public void setCountOverall(int countOverall) {
        this.countOverall = countOverall;
    }

    public int getCountOpenSessions() {
        return countOpenSessions;
    }

    public void setCountOpenSessions(int countOpenSessions) {
        this.countOpenSessions = countOpenSessions;
    }

    public String toString() {
        return "ApplicationCounter [countOverall=" + countOverall + ", countOpenSessions=" + countOpenSessions + "]";
    }
}
