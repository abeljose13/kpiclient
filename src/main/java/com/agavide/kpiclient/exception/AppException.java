package com.agavide.kpiclient.exception;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public class AppException extends GenericException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3587026712477450281L;
	

	public AppException(String message, String errorCode) 
	{
		super(message, errorCode);
	}

	public AppException(String message, String errorCode, Throwable ex) 
	{
		super(message, errorCode, ex);
	}

}
