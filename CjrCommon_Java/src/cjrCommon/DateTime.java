package cjrCommon;

import java.util.Calendar;


public class DateTime  {

	protected Calendar _cal = Calendar.getInstance();
	
	protected DateTime(){}
	
	public DateTime(String dteTime) throws DateParseException {
		String[] arr = dteTime.split("/");
		if(arr.length < 3) 
			throw new DateParseException();
		String[] timeArray = arr[2].split(" ");
		if(timeArray.length == 2)
			addTime(timeArray[1]);
		addDate(arr[0], arr[1], timeArray[0]);
	}
	
	private void addDate(String month, String day, String year) {
		if(Utilities.isNumeric(month) && Utilities.isNumeric(day) && Utilities.isNumeric(year))
		{
			_cal.set(Calendar.MONTH, Integer.parseInt(month));
			_cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			_cal.set(Calendar.YEAR, Integer.parseInt(year));
		} 
	}
	
	private void addTime(String string) throws DateParseException {
		String[] arr = string.split(":");
		if(arr.length != 3)
			throw new DateParseException();
		if(!Utilities.allNumeric(arr))
			throw new DateParseException();
		_cal.set(Calendar.HOUR, Integer.parseInt(arr[0].trim()));
		if(arr.length > 1)
			_cal.set(Calendar.MINUTE, Integer.parseInt(arr[1].trim()));
		if(arr.length > 2)
			_cal.set(Calendar.SECOND, Integer.parseInt(arr[2].trim()));
		if(arr.length > 3)
			_cal.set(Calendar.MILLISECOND, Integer.parseInt(arr[2].trim())); 
	}
	
	public int getYear()
	{
		return _cal.get(Calendar.YEAR);
	}
	public int getMonth()
	{
		return _cal.get(Calendar.MONTH);
	}
	public int getDay()
	{
		return _cal.get(Calendar.DAY_OF_MONTH);
	}
	public int getHour()
	{
		return _cal.get(Calendar.HOUR);
	}
	public int getMinute()
	{
		return _cal.get(Calendar.MINUTE);
	}
	public int getSecond()
	{
		return _cal.get(Calendar.SECOND);
	}
	public int getMillisecond()
	{
		return _cal.get(Calendar.MILLISECOND);
	}
}
