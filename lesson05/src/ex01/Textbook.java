package ex01;

public class Textbook extends Book{
    private Status status;
    
    public Textbook() {
	}

    public Textbook(String id,double cost,String publisher, Status status) {
    	super();
    	this.status = status;
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Textbook(Status status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "Textbook [status=" + status + "]";
	}
    
	
}
