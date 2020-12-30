package datalayer;

import java.time.Instant;

public class FileStorageStructure {
	
	private Object data ;
	private Instant time;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Instant getTime() {
		return time;
	}
	public void setTime(Instant time) {
		this.time = time;
	}

}
