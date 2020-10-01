// Java program for the above approach 
import java.io.*; 
  
class GFG{ 
      
// Function to find the 
// maximum occurring character 
static void solve(String S) 
{ 
      
    // Initialize count of 
    // zero and one 
    int count_0 = 0, count_1 = 0; 
  
    int prev = -1; 
  
    // Iterate over the given string 
    for(int i = 0; i < S.length(); i++) 
    { 
          
        // Count the zeros 
        if (S.charAt(i) == '0') 
            count_0++; 
  
        // Count the ones 
        else if (S.charAt(i) == '1') 
            count_1++; 
    } 
  
    // Iterate over the given string 
    for(int i = 0; i < S.length(); i++)  
    { 
  
        // Check if character 
        // is * then continue 
        if (S.charAt(i) == '*') 
            continue; 
  
        // Check if first character 
        // after * is X 
        else if (S.charAt(i) == '0' && prev == -1) 
        { 
              
            // Add all * to 
            // the frequency of X 
            count_0 = count_0 + i; 
  
            // Set prev to the 
            // i-th character 
            prev = i; 
        } 
  
        // Check if first character 
        // after * is Y 
        else if (S.charAt(i) == '1' && prev == -1) 
        { 
  
            // Set prev to the 
            // i-th character 
            prev = i; 
        } 
  
        // Check if prev character is 1 
        // and current character is 0 
        else if (S.charAt(prev) == '1' && 
                 S.charAt(i) == '0')  
        { 
  
            // Half of the * will be 
            // converted to 0 
            count_0 = count_0 + (i - prev - 1) / 2; 
  
            // Half of the * will be 
            // converted to 1 
            count_1 = count_1 + (i - prev - 1) / 2; 
            prev = i; 
        } 
  
        // Check if prev and current are 1 
        else if (S.charAt(prev) == '1' && 
                 S.charAt(i) == '1') 
        { 
  
            // All * will get converted to 1 
            count_1 = count_1 + (i - prev - 1); 
            prev = i; 
        } 
  
        // No * can be replaced 
        // by either 0 or 1 
        else if (S.charAt(prev) == '0' &&  
                 S.charAt(i) == '1') 
  
            // Prev becomes the ith character 
            prev = i; 
  
        // Check if prev and current are 0 
        else if (S.charAt(prev) == '0' &&  
                 S.charAt(i) == '0')  
        { 
  
            // All * will get converted to 0 
            count_0 = count_0 + (i - prev - 1); 
            prev = i; 
        } 
    } 
  
    // If frequency of 0 
    // is more 
    if (count_0 > count_1) 
        System.out.print("0"); 
  
    // If frequency of 1 
    // is more 
    else if (count_1 > count_0) 
        System.out.print("1"); 
  
    else 
    { 
        System.out.print("-1"); 
    } 
} 
  
// Driver code 
public static void main (String[] args) 
{ 
      
    // Given string 
    String str = "**0**1***0"; 
  
    // Function call 
    solve(str); 
} 
} 
