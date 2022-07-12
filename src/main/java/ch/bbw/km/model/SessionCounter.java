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
    ApplicationCounter applicationCounter;

    @PostConstruct
    public void setup() {
        applicationCounter.incrementSession();
        applicationCounter.incrementOverall();
        System.out.println("SessionCounter.setup(); " + applicationCounter);
    }

    @PreDestroy
    public void shutdown() {
        applicationCounter.decrementSession();
        System.out.println("SessionCounter.shutdown(); " + applicationCounter);
    }
    @Override
    public String toString() {
        return "SessionCounter [myApplicationCounter=" + applicationCounter + "]";
    }
}
