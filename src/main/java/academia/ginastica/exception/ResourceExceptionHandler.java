
package academia.ginastica.exception;


import java.time.Instant;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler 
{


	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionReturnModel> 
	entityNotFound(BadRequestException e, HttpServletRequest request){
		ExceptionReturnModel err = new ExceptionReturnModel();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	//Capturar excecoes lancadas pelas anotações do pacote Validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionReturnModel> 
	entityNotFound(MethodArgumentNotValidException
			e, HttpServletRequest request){
		ExceptionReturnModel err = new ExceptionReturnModel();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Illegal Argument");

		String message = returnDefaultMessageErrors(e);
		
		err.setMessage(message);
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	private String returnDefaultMessageErrors( MethodArgumentNotValidException e)
	{
		BindingResult result = e.getBindingResult();
		List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
		
		String retorno = "";

		for (org.springframework.validation.FieldError fieldError: fieldErrors) 
		{
			retorno += fieldError.getDefaultMessage();
			retorno += " e ";
		}
		
		// removendo " e " solto no final d frase
		if(retorno.length() >3) retorno = retorno.substring(0, retorno.length()-3);
		
		return retorno;
	}


}
