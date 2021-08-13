package SafeHome;

import java.util.Objects;

public class AccessKey {
    private String pin;

    public AccessKey(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessKey key = (AccessKey) o;
        return Objects.equals(pin, key.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin);
    }
}
