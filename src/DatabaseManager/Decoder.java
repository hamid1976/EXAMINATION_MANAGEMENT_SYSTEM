package DatabaseManager;

public class Decoder{

    public static String shiftDecode(String shift){

	switch(shift){
	case "M":return "MORNING";
	case "E":return "EVENING";
	case "N":return "NOON"; 	
	}
	return shift;
	}


public static String groupDecode(String group){

	switch (group) {
          case "M":return "MEDICAL";
          case "E":return "ENGINEERING";
          case "C":return "COMMERCE";
          case "G":return "GENERAL"; 			
 
	}
        
	return group;
}


public static String decodeDate(java.util.Date date){
    
    if(date==null) return "";
    
    java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("MM/dd/yyyy");
    String dateStr=f.format(date);
    System.out.println("Formatted Date: " +dateStr);
    return dateStr;  


        // Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String formattedDate = formatter.format(date);
//        System.out.println("Formatted Date: " + formattedDate);
//        
//        return formattedDate;
        

}

    

}
