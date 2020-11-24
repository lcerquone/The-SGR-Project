package impl;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;


public final class EmailVO {
    private static final EmailValidator validator = EmailValidator.getInstance();
    private final String value;

    public EmailVO(String value) throws Exception {
        if (!validator.isValid(value)) {
            throw new  Exception("Error:  email invalido.");
        }
        this.value = value;
    }

    public EmailVO change(String value) throws Exception {
        return new EmailVO(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmailVO that = (EmailVO) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}