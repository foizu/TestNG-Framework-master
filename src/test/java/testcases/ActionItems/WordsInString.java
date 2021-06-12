package testcases.ActionItems;

public class WordsInString {

// Create Number Of Words Method
public static void getNumberOfWords(String Word){

    // Initialize Count
    int count = 1;

    // Iterate over Word
    for (int i = 0; i < Word.length() - 1; i++){

        // Check for Uppercase Letters
        Character index = Word.charAt(i);
        if(Character.isUpperCase(index)){
            // Increment Count if Uppercase Letter is found
            count++;
        }
    }

    // Return Count
    System.out.printf("Number of words in " + Word + ": " + count + "\n");
}

    public static void main(String[] args) {

        /*

        Thought Process:
        ================

        1)  write a method
        2)  keep a counter
        3)  have a for loop
        4)  iterate over loop
        5)  have a if statement
        6)  print count
        7)  call method in main function

        Examples:
        =========

        saveChangesInTheEditor:5 words
        singleword:1 words
        welcomeToSelenium:3 words

         */

         getNumberOfWords("saveChangesInTheEditor");
         getNumberOfWords("singleword");
         getNumberOfWords("welcomeToSelenium");
    }
}
