package Exceptions;

public class CartasInsuficientesException extends RuntimeException
{
  public CartasInsuficientesException(String message)
  {
    super(message);
  }
}
