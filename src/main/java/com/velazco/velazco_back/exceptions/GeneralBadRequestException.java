package com.velazco.velazco_back.exceptions;

public class GeneralBadRequestException extends RuntimeException {
  public GeneralBadRequestException(String message) {
    super(message);
  }
}
