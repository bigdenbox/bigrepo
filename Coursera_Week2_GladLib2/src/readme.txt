Assignment: Verbs and Fruits
Run the GladLib.java program that is provided. You should also have a data folder with several files. This program should generate a story using the file madtemplate.txt, which is also in the data folder. This program creates a story by replacing placeholder words such as <noun> by looking for a random word of that type. This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. For example, one ArrayList stores different nouns. These nouns are initially read in from a file called noun.txt and stored in the ArrayList named nounList. Whenever the templated word <noun> is found in the story, a random noun from the nounList is used in place of <noun>.

You will now modify the GladLib.java file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:

Modify the program to handle replacing verbs with <verb> tags and fruits with <fruit> tags. You will read in choices of verbs from the file verb.txt and choices for fruit from the file fruit.txt. These files are already in the data folder. There are several parts of the program that you will need to modify.
Add private ArrayLists, one for verbs and one for fruits.
Modify the method initializeFromSource to read the data from these two files.
Modify the method getSubstitute to handle the replacements of <verb> and <fruit> with random words of those types.
Modify the file makeStory to read in the template file madtemplate2.txt that also uses the <verb> and <fruit> tags.
Run your program to make sure it works before making additional changes.
Now modify your program so that once it uses a word, it never uses that word again. You should declare and initialize an additional private ArrayList to keep track of words that have been seen. HINT: You will need to modify the method processWord. Once it finds a word to use, check to see if that word has been used before or not. You should also be sure that you clear out this new ArrayList in makeStory before each run of your program. The folder datalong with longer data files is provided.
Modify your program to print out the total number of words that were replaced right after the story is printed.

Assignment 3: Maps Version of GladLibs

Start with your GladLibs program you completed earlier in this lesson. Make a copy of it and call it GladLibMap.java. Now modify this program to use one HashMap that maps word types to ArrayList of possible words to select. Your program should still work for the additional categories verbs and fruits and should not use duplicate words from a category. Specifically, you should make the following adjustments to this program:

Replace the ArrayLists for adjectiveList, nounList, colorList, countryList, nameList, animalList, timeList, verbList, and fruitList with one HashMap myMap that maps a String representing a category to an ArrayList of words in that category. Caution: Don’t replace the ArrayList representing the words that have already been used!
Create the new HashMap in the constructors.
Modify the method initializeFromSource to create an Array of categories and then iterate over this Array. For each category, read in the words from the associated file, create an ArrayList of the words (using the method readIt), and put the category and ArrayList into the HashMap.
Modify the method getSubstitute to replace all the if statements that use category labels with one call to randomFrom that passes the appropriate ArrayList from myMap.
Run your program to make sure it works.
Write a new method named totalWordsInMap with no parameters. This method returns the total number of words in all the ArrayLists in the HashMap. After printing the GladLib, call this method and print out the total number of words that were possible to pick from.
Write a new method named totalWordsConsidered with no parameters. This method returns the total number of words in the ArrayLists of the categories that were used for a particular GladLib. If only noun, color, and adjective were the categories used in a GladLib, then only calculate the sum of all the words in those three ArrayLists. Hint: You will need to keep track of the categories used in solving the GladLib, then compute this total.
