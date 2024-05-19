import java.util.HashMap;   
    import java.util.Iterator;   
    import java.util.Map;   
public class FailFastDemo {  
        public static void main(String[] args)   
        {   
            Map<String, String> empName = new HashMap<String, String>();   
            empName.put("Sam Hanks", "New york");   
            empName.put("Will Smith", "LA");   
            empName.put("Scarlett", "Chicago");   
            Iterator iterator = empName.keySet().iterator();   
            while (iterator.hasNext()) {   
                System.out.println(empName.get(iterator.next()));   
                // adding an element to Map   
                // exception will be thrown on next call   
                // of next() method.   
                empName.put("Istanbul", "Turkey");   
            }   
        }   
    }   