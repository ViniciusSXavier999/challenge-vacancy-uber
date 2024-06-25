package com.vx.challenge.emailservice.infra.ses;

import com.vx.challenge.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.vx.challenge.emailservice.adapters.EmailSenderGateway;

@Service
/*Estamos implementando a interface que o meu emailSenderService depende */
/* camada responsável por interagir com serviços externos!! */
public class SesEmailSender implements EmailSenderGateway {
	
	private final AmazonSimpleEmailService amazonSimpleEmailService;

	/* colocamos o autowired para dizer para o spring instanciar o meu objeto
	* automaticamente, dessa forma não precisamos ficar utilizando o operador
	* new a todo momento */
	@Autowired
	public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
		this.amazonSimpleEmailService = amazonSimpleEmailService;
	}

	@Override
	public void sendEmail(String to, String subject, String body) {
		// implementando método para enviar o email.
		SendEmailRequest request = new SendEmailRequest()
				// quem ta enviando esse email -> withSource
				.withSource("viniciusxaviersouza11@gmail.com")
				// Quem vai receber esse email -> withDestination
				.withDestination(new Destination().withToAddresses(to))
				// Qual vai ser a mensagem do email 
				.withMessage(new Message()
						// assunto da mensagem
						.withSubject(new Content(subject))
						// corpo da mensagem
						.withBody(new Body().withText(new Content(body)))
						
						);
		
		try {
			this.amazonSimpleEmailService.sendEmail(request);
		} catch (AmazonServiceException exception) {
			throw new EmailServiceException("Falha ao enviar o email.", exception);
			
		}
		
	}

}