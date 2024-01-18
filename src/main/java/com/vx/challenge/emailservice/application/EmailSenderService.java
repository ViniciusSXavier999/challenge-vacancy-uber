package com.vx.challenge.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;

import com.vx.challenge.emailservice.core.EmailSenderUseCase;

// Essa classe implemneta a minha interface da camada core
/*Essa camada da aplicação conecta o core da aplicação com o mundo externo é ela que vai 
 * implementar de fato o core da nossa aplicação.*/
public class EmailSenderService implements EmailSenderUseCase {
	
	private final EmailSenderGateway emailSenderGateway;
	
	@Autowired
	public EmailSenderService(EmailSenderGateway) {
		this.emailSenderGateway = emailGateway;
	}

	@Override
	public void sendEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		
	}
	
	

}
