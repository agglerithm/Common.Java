package cjrCommon;

import java.io.DataInput; 
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Calendar; 
import java.util.GregorianCalendar;

public class Utilities {

    public static byte[] GrowBuffer(byte[] buff, int size_to_grow_by)
    {

        byte[] temp = new byte[buff.length + size_to_grow_by]; 
        for (int i = 0; i < buff.length; i++)
        {
            temp[i] = buff[i];
        }
        return temp;
    }

    public static byte[] AppendBuffer(byte[] homebuff, byte[] appendbuff)
    {
        int homeLength = homebuff.length;
        int appendLength = appendbuff.length;
        
        byte[] temp = GrowBuffer(homebuff, appendLength); 
        for (int i = 0; i < appendLength; i++)
        {
            temp[i + homeLength] = appendbuff[i];
        }
        return temp;
    }
    
    public static byte[] FromEncodedToBuffer(String val)
    {
    	return javax.xml.bind.DatatypeConverter.parseBase64Binary(val);
    }
    public static String FromEncodedToString(String val)
    {
    	return javax.xml.bind.DatatypeConverter.parseBase64Binary(val).toString();
    }

    public static String ToEncoded(String val)
    {
        return   javax.xml.bind.DatatypeConverter.printBase64Binary(val.getBytes());

    }

    public static String ToEncoded(byte [] buff)
    {
        return ToEncoded(buff.toString());
    }
    

//    public static void CopyFileWithoutOverwrite(string source, string dest)
//    {
//        if (File.Exists(dest))
//        {
//        	String fname = Path.GetFileNameWithoutExtension(dest);
//        	String ext = Path.GetExtension(dest);
//        	String pth = dest.Replace(Path.GetFileName(dest), "");
//            dest = pth + fname + "x" + ext;
//        }
//        File.Copy(source, dest);
//    }

    public static void AppendTextToFile(String path, String text) throws IOException
    {
        //Creates a new text file with contents "text" at path "path"
        //  (Existing file is overwritten)
        FileWriter sw = new FileWriter(path, true);
        sw.write(text);
        sw.close();
    }

    public static String QuickFileText(String path) throws IOException
    {
        FileReader sr = new FileReader(path);
        StringBuffer buff = new StringBuffer();
        int val = sr.read();
        while(val >= 0)
        {
        	buff.append((char)val);
        	val = sr.read();
        } 
        sr.close();
        return buff.toString();
    }
/*
    public static void CopyFileWithOverwrite(String source, String dest)
    {
        if (File.Exists(dest))
            File.Delete(dest);
        File.Copy(source, dest);
    }

*/

    public static byte[] TrimBuff(byte[] buff, int n)
    {
        byte[] temp = new byte[n];
        for (int i = 0; i < n; i++)
            temp[i] = buff[i];
        return temp;
    }

    public static String BuffToString(byte[] buff)
    {
        return new String(buff);
    }

    public static byte [] StringToBuff(String str)
    {
        return str.getBytes();
    }

 

    public static String SkipToken(String str ,String strToken )
    {
        int sz = strToken.length();
        int pos = str.indexOf(strToken);
        if(pos >= 0 )
            str =  str.substring(pos + sz,  str.length()); 
        return str;
    }

    public static String SkipToken(String str ,String strToken, int reps)
    {
        for(int i = 0; i < reps; i++)
            str = SkipToken(str, strToken);
        return str;
    }

    public static String LeftBeforeToken(String str ,String strToken)
    { 
        if( str.indexOf(strToken) >= 0 ) 
                str = str.substring(0,  str.indexOf(strToken)); 
        return str;
    }

    public static String SkipAll( String str ,  String strToken  ) 
    {
        do
        {
            str = SkipToken(str, strToken);
        }
        while (str.indexOf(strToken) >= 0);
        return str;
    }

//    public static String GetApplicationFileName(bool withExtension)
//    {
//    	String app = Environment.CommandLine.ToString().Replace("\"","");
//        if(withExtension)
//            return System.IO.Path.GetFileName(app);
//        return System.IO.Path.GetFileNameWithoutExtension(app);
//    }
    
    
    public static Calendar Date(int year, int month, int day)
    {
    	Calendar cal = new GregorianCalendar();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month);
    	cal.set(Calendar.DAY_OF_MONTH, day);
        return cal;
    }

    public static Calendar Time(int hour, int minute, int second, int millisecond)
    {
    	Calendar cal = new GregorianCalendar();
    	cal.set(Calendar.HOUR, hour);
    	cal.set(Calendar.MINUTE, minute);
    	cal.set(Calendar.SECOND, second);
    	cal.set(Calendar.MILLISECOND, millisecond);
    	
        return cal;
    }
    public static Calendar FromEDIDate(int edi_dte)
    {
    	return Date(edi_dte / 10000,edi_dte % 10000 / 100, edi_dte % 100); 
    }

    public static int ToEDIDate(Calendar dte)
    {
        return Year(dte) * 10000 + Month(dte) * 100 + DayOfMonth(dte);
    }

    public static int Year(Calendar cal)
    {
    	return cal.get(Calendar.YEAR);
    }
    public static int Month(Calendar cal)
    {
    	return cal.get(Calendar.MONTH);
    }
    public static int DayOfMonth(Calendar cal)
    {
    	return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    public static Calendar AddDays(Calendar cal, int days)
    {
    	cal.add(Calendar.DAY_OF_MONTH, days);
    	return cal;
    }
    public static int IncrementEDIDate(int edi_dte, int delta)
    {
        Calendar dte = FromEDIDate(edi_dte);
        dte = AddDays(dte,delta);
        return ToEDIDate(dte);
    }


    public static String StripLeadingAlpha(String num)
    {
        StringBuffer temp = new StringBuffer();
        char[] arr = num.toCharArray();
        for (int i = 0; i < arr.length; i++)
        {
            int testnum;
            if(isNumeric(arr[i]))   
                return num.replace(temp.toString(),""); 
            temp.append(arr[i]);
        }
        return num;
    }
    
    private static boolean isNumeric(char num)
    {  
            	return num >47 && num < 58;
             
    }
    
    public static String StripTrailingAlpha(String num)
    {
        StringBuffer temp = new StringBuffer();
        char[] arr = num.toCharArray();
        for (int i = 0; i < num.length(); i++)
        { 
            if (isNumeric(arr[i]))
                temp.append(arr[i]);
            else
                return temp.toString();
        }
        return temp.toString();
    }

    public static String Truncate(String str, int len)
    {
        if (str == null) return "";
        if (str.length() <= len) return str;
        return str.substring(0, len);
    }

    public static byte[] BinCat(byte[] original, byte[] append)
    {
        if (original == null) return append;
        byte [] temp = new byte[original.length + append.length];
        int i;
        int offset = original.length;
        for (i = 0; i < offset; i++)
            temp[i] = original[i];
        for (i = 0; i < append.length; i++)
            temp[offset + i] = append[i];
        return temp;
    }

 


    public static String QuickStreamText(DataInput strm)
    {
    	StringBuffer strBuff = new StringBuffer();
    	boolean eof = false;
        while(!eof)
        {
        	try{
        		strBuff.append(strm.readChar());
        	}
        	catch(EOFException ex)
        	{
        		eof = true;
        		
        	} 
        	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        return strBuff.toString();
    }

    public static void printOut(String txt)
    {
    	System.out.println(txt);
    }
    
    public static Calendar FromEDITime(int stamp)
    {
        return Time (stamp/10000,stamp %10000 /100,stamp % 100, 0);
    }

	public static boolean allNumeric(String[] arr) {

		for(String str : arr)
		{
			if(!isNumeric(str))
				return false;
		}
		return true;
	}

	public static boolean isNumeric(String str) {

		char[] arr = str.toCharArray();
		for(char ch : arr)
		{
			if(!isNumeric(ch))
				return false;
		}
		return true;
	}

	public static int Hour(Calendar cal) {
    	return cal.get(Calendar.HOUR_OF_DAY);
	}
	public static int Minute(Calendar cal) {
    	return cal.get(Calendar.MINUTE);
	}

	public static int Second(Calendar cal) {
    	return cal.get(Calendar.SECOND);
	}
	
	public static int Millisecond(Calendar cal){
		return cal.get(Calendar.MILLISECOND);
	}
}
