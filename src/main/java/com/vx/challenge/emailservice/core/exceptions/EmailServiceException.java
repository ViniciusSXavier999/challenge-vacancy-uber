package com.vx.challenge.emailservice.core.exceptions;

import com.vx.challenge.emailservice.application.EmailSenderService;

public class EmailServiceException extends RuntimeException{

    public EmailServiceException(String message){
        // esse super basicamente esta chamando o construtor da classe que eu estou extends
        /* como eu estou extends a classe RunTimeException quando eu faço "super" eu chamo
        * o construtor dessa classe e monto a minha exceção*/
        super(message);
    }

    public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
