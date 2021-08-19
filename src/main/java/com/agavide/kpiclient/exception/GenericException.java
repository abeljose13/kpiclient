package com.agavide.kpiclient.exception;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public abstract class GenericException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5257483686016081479L;
	
	
	private String errorCode;
	

    public GenericException(String message, String errorCode)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public GenericException(String message, String errorCode, Throwable ex)
    {
        super(message, ex);
        this.errorCode = errorCode;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

}
