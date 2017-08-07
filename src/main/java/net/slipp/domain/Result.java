package net.slipp.domain;

public class Result {

	private boolean valid;
	
	private String errorMessage;

	private Result(boolean valid){
		this.valid=valid;
	}
	private Result(boolean valid, String erroMessage){
		this.valid=valid;
		this.errorMessage=erroMessage;
	}
	
	public boolean isValid(){
		return valid;
	}
	
	public String getErrorMessage(){
		return errorMessage;
	}

	public static Result ok(){
		return new Result(true);
	}

	public static Result fail(String errorMessage){
		return new Result(false, errorMessage);
	}
	
	
	
}













