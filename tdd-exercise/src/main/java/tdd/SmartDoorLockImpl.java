package tdd;

import java.util.Optional;

public class SmartDoorLockImpl implements SmartDoorLock {
    private final int MAXIMUM_ATTEMPTS = 3;
    private boolean isLocked = false;
    private boolean isBlocked = false;
    private int attemptsFailed = 0;
    private Integer pin;

    @Override
    public void setPin(int pin) {
        if (String.valueOf(pin).length() != 4) {
            throw new IllegalArgumentException("Pin must be 4 digits long");
        }

        if (!this.isLocked() && !this.isBlocked()) {
            this.pin = pin;
        } else {
            throw new IllegalStateException("System is not open");
        }
    }

    @Override
    public void unlock(int pin) {
        final boolean pinIsCorrect = this.pin.equals(pin);
        this.isLocked = !pinIsCorrect;
        this.attemptsFailed = !pinIsCorrect ? this.attemptsFailed + 1 : this.attemptsFailed;
        this.isBlocked = this.attemptsFailed > MAXIMUM_ATTEMPTS;

    }

    @Override
    public void lock() {
        if (Optional.ofNullable(this.pin).isEmpty()) {
            throw new IllegalStateException("Pin is empty");
        }

        this.isLocked = true;
    }

    @Override
    public boolean isLocked() {
        return this.isLocked;
    }

    @Override
    public boolean isBlocked() {
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return this.MAXIMUM_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.attemptsFailed;
    }

    @Override
    public void reset() {
        this.pin = null;
        this.isBlocked =  false;
        this.isLocked = false;
        this.attemptsFailed = 0;
    }
}
