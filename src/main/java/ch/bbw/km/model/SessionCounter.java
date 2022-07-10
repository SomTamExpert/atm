package ch.bbw.km.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionCounter {

    @Autowired
    ApplicationCounter myApplicationCounter;

    @PostConstruct
    public void setup() {
        myApplicationCounter.incrementSession();
        myApplicationCounter.incrementOverall();
        System.out.println("SessionCounter.setup(); " + myApplicationCounter);
    }

    @PreDestroy
    public void shutdown() {
        myApplicationCounter.decrementSession();
        System.out.println("SessionCounter.shutdown(); " + myApplicationCounter);
    }
    @Override
    public String toString() {
        return "SessionCounter [myApplicationCounter=" + myApplicationCounter + "]";
    }
}
