package br.com.farmacia.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.com.farmacia.dto.MensagemDeErro;

@ControllerAdvice
public class TratamentoDeErros {

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<MensagemDeErro>codigoNaoEncontrado(){
		var mensagem = new MensagemDeErro(HttpStatus.BAD_REQUEST, "Código de comanda inválido !");
		return new ResponseEntity<>(mensagem,HttpStatus.BAD_REQUEST);
	}
	

}
