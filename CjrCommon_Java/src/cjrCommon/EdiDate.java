package cjrCommon;

 

public class EdiDate extends DateTime {

 
	

	public EdiDate(String dteTime) throws DateParseException {
		super(dteTime);
		// TODO Auto-generated constructor stub
	}

	public EdiDate(int dte)
	{
		setEdiDate(dte);
	}
	
	public int getEdiDate()
	{
		return Utilities.ToEDIDate(_cal);
	}

	public void setEdiDate(int val)
	{
		_cal = Utilities.FromEDIDate(val);
	}

}
