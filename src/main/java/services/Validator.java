package services;

public interface Validator<T> {

    boolean isValid(T toValidate);

    void validate(T toValidate);

}
