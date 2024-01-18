package com.vx.challenge.emailservice.core;


/*Caso de uso principal da nossa aplicação que é enviar email*/

// Essa interface vai ser o contrato que define o comportamento da nossa aplicação
public interface EmailSenderUseCase {
	
	void sendEmail(String to, String subject, String body);

}
