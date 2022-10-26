public class Sum {  
  
    public static void main(String[] args) {  
        int sum = 0;  
        for (int i = 0; i < args.length; i++) {  
            String mass = args[i];
            String num = "";  
            for (int n = 0; n < mass.length(); n++) { 
                char c = mass.charAt(n); 
                if (Character.isWhitespace(c)) { 
                    if (num != "") { 
                        sum += Integer.parseInt(num); 
                        num = "";
	            }
                } else {  
                      num += c;            
                  }  
            }  
 
            if (num != "") { 
                sum += Integer.parseInt(num);
            }         
        } 
        System.out.println(sum); 
    }
}