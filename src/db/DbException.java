package db;

public class DbException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DbException(String ex) {
		super(ex);
	}
}