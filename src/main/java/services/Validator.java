package services;

public interface Validator<T, E extends Throwable> {

    boolean isValid(T toValidate);

    void validate(T toValidate) throws E;

}
