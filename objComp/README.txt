CS542 Design Patterns
Spring 2015
PROJECT 5 README FILE

Due Date: Monday, May 4, 2015
Submission Date: Monday, May 4, 2015
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Anirudha Kadam 
e-mail(s): akadam3@binghamton.edu 


PURPOSE:

[
  To implement Java Reflection to deserialize objects and compare them to find non-duplicate objects.
]

PERCENT COMPLETE:

[
  I believe I have completed 100% of this project.
]

EXTRA CREDIT:

[

  I have used HashMap data structure to store Objects and Data type classes

  Reason: 1) HashMap is a key-value data structure which uses unique hashCode value to store object.
	  2) get(key) operation has only O(1) time complexity if the key in known. So object comparison can be done really very fast.
	  3) While populating Objects into HashMap, avoided use of map.contains(key) method which has O(n) time complexity. Simply used 
	     map.get(key) and map.put(key,value) methods (both have O(1) time complexity) as I know that map.get(key) will return null 
	     if that key is not present in map. This reduced overhead of using map.contains() method while increamening count if the key 
             is duplicate. This trick boosts performance ramarkably.
          4) Taking Object as a key and Count as a value is very easy to understand and compare objects to find non-duplicates.
          5) If I run the program for about 500 interations, it completes in just 0.008 seconds for inputbig.txt and in 0.001 seconds for 		     inputsmall.txt
	  6) Used only single data structure to store objects as it would be more generic code. If we introduce one more class, 
             we don't need to add extra data structure to code to accomodate objects of a new class. We will just need to take an 
             extra counter while interating over HashMap.
	  7) I used split operation (though it is little heavy) to make the code generic as I split over delimiters such as comma,
             colon while parsing input. I could have directly used index to extract desired part of input string to maximize 
             performance but I preferred generic code design over little performance optimization. It just makes diffrence of 
             couple of milliseconds.
]        

PARTS THAT ARE NOT COMPLETE:

[
  None.
]

BUGS:

[
  None.
]

FILES:

[
  Driver.java 
  DisplayInterface.java 
  ResultsInterface.java
  Reflection.java
  ReflectionInterface.java
  FileInterface.java
  FileProcessor.java
  MyLogger.java
  PopulateObjects.java
  First.java
  Second.java
  input files 
]

SAMPLE OUTPUT:

[

  remote04:~/dp/anirudha_kadam_assign5/objComp> ant -buildfile src/build.xml run -Darg0=inputbig.txt -Darg1=1 -Darg2=0
  Buildfile: /import/linux/home/akadam3/dp/anirudha_kadam_assign5/objComp/src/build.xml

  jar:

  run:
       [java] Number of non-duplidate First objects: 237
       [java] Total Number of First objects: 474
       [java] Number of non-duplidate Second objects: 263
       [java] Total Number of Second objects: 526
       [java]
       [java] Totat Execution Time: 0.105 Seconds

  BUILD SUCCESSFUL

]

TO COMPILE:

[
  Extract.
  Follow Path: anirudha_kadam_assign5/objComp/
  Assuming you are in the directory containing this README

  ## To compile: 
  ant -buildfile src/build.xml all
]

TO RUN:

[
  Assuming you are in the directory containing this README:
  
  ## To run
  ant -buildfile src/build.xml run -Darg0=<inputFileName.txt> -Darg1=<numberOfInterations> -Darg2=<debugValue> 
]

TO CLEAN:

[ 
  Assuming you are in the directory containing this README:
  
  ## To clean:
  ant -buildfile src/build.xml clean
]

NOTE:

[
   DEBUG_VALUE mappings
   0 = Output
   1 = Everytime Object is added to HashMap 
   2 = constructor calls
   3 = method calls   	
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Anirudha Kadam

[
  
]

ACKNOWLEDGEMENT:

[
  N/A
]
