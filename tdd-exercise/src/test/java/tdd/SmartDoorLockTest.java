package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    private static final int TOO_SHORT_PIN = 4;
    private static final int TOO_LONG_PIN = 44444;
    private static final int LONG_ENOUGH_PIN = 4444;
    private static final int WRONG_PIN = LONG_ENOUGH_PIN + 1;
    private SmartDoorLock door;

    @BeforeEach
    public void setUp() {
        this.door = new SmartDoorLockImpl();
    }

    @Test
    public void doorShouldBeUnlockedInitially() {
        Assertions.assertFalse(door.isLocked());
    }

    @Test
    public void pinShouldBeSetOnlyIfTheSystemIsOpen() {
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();
        assertThrows(IllegalStateException.class, () -> door.setPin(LONG_ENOUGH_PIN));
    }

    @Test
    public void doorPinShouldBeFourDigitsLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            door.setPin(TOO_SHORT_PIN);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            door.setPin(TOO_LONG_PIN);
        });

        assertDoesNotThrow(() -> {
            door.setPin(LONG_ENOUGH_PIN);
        });
    }

    @Test
    public void doorShouldBeLockedOnlyIfThereIsAPin() {
        assertThrows(IllegalStateException.class, () -> {
            door.lock();
        });
    }

    @Test
    public void doorShoulfUnlockIfThePinIsCorrect() {
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();
        door.unlock(LONG_ENOUGH_PIN);
        Assertions.assertFalse(door.isLocked());
    }

    @Test
    public void doorShouldRemainLockedIfThePinIsWrong() {
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();
        door.unlock(WRONG_PIN);
        Assertions.assertTrue(door.isLocked());
    }

    @Test
    public void attemptsFailedShouldIncreaseIfThePinIsWrong() {
        final var attemptsFailed = door.getFailedAttempts();
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();
        door.unlock(WRONG_PIN);
        Assertions.assertEquals(attemptsFailed + 1, door.getFailedAttempts());
    }

    @Test
    public void doorShouldBeBlockedIfTheNumberOfAttemptsExcedeMaximum() {
        final var maxAttempts = door.getMaxAttempts();
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();

        for (int i = 0; i <= maxAttempts + 1; i++) {
            door.unlock(WRONG_PIN);
        }

        Assertions.assertTrue(door.isBlocked());
    }

    @Test
    public void resetShouldOpenTheLock() {
        final var maxAttempts = door.getMaxAttempts();
        door.setPin(LONG_ENOUGH_PIN);
        door.lock();
        for (int i = 0; i <= maxAttempts + 1; i++) {
            door.unlock(WRONG_PIN);
        }

        door.reset();

        Assertions.assertFalse(door.isLocked());
        Assertions.assertFalse(door.isBlocked());
        Assertions.assertEquals(0, door.getFailedAttempts());

    }
}