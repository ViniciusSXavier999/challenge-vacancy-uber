package com.vx.challenge.emailservice.adapters;

/* essa camada vai adptar o mundo de fora para uma interface, a minha aplicação vai depender
* dessa interface e não do mundo de fora */
public interface EmailSenderGateway {
	
	void sendEmail(String to, String subject, String body );

}
