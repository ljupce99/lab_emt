package finki.ukim.mk.lab_emt.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
  public InvalidUsernameOrPasswordException(String message) {
    super(message);
  }
}
