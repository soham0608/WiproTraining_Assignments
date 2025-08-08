
package Threading;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02 {
	
	public static boolean isVowel(char ch) 
	{
		return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	
	public static void main(String[] args)
	{
		
		List<String> names = new ArrayList<>(Arrays.asList("Amit", "Jayanta", "Soham", "Ajay", "PRATHAM","Uday"));
		
		Thread vowelThread = new Thread(() -> {
            for (int i = 0; i < names.size(); i++) 
            {
                String name = names.get(i);
                if (isVowel(name.charAt(0))) {
                    names.set(i, name.toUpperCase());
                }
            }
        });
		
		Thread consonantThread = new Thread(() -> {
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (!isVowel(name.charAt(0))) {
                    names.set(i, name.toLowerCase());
                }
            }
        });
		
		vowelThread.start();
        consonantThread.start();
          
        System.out.println(names);
	}
}
