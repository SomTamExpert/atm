package ch.bbw.km.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Class Login is used to count number of pin entries during login
 * @author marco karpf
 * @version 12.07.2022
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Login {
    public int attempts = 0;

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void increaseAttempts() {
        attempts++;
    }

    public String getRemainingAttempts() {
        return String.valueOf(3 - attempts);
    }
}
