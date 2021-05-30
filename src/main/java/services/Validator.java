package services;

public interface Validator<T, E extends Throwable, R> {

    boolean isValid(T toValidate);

    R validate(T toValidate) throws E;

}
