package academia.ginastica.exception;

public class BadRequestException extends RuntimeException
{
	private static final long serialVersionUID = -8032117858291133440L;
	
	public BadRequestException(String mensagem) {
		super(mensagem);
	}
	
}
