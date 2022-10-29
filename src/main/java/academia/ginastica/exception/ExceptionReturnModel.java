package academia.ginastica.exception;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class ExceptionReturnModel implements Serializable
{

	private static final long serialVersionUID = -7734909640282930199L;
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
