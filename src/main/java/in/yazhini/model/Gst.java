package in.yazhini.model;

public class Gst {
	private double gst;
	

//create a constructor to the details
	public Double getGst() {
		return gst;
	}

	

	public Gst(Double gst) {
		super();
		this.gst = gst;
		
	}
    @Override
	public String toString() {
		return "Gst [gst=" + gst + "]";
	}


	}
