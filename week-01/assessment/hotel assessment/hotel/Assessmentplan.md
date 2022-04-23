Assessment Plan

Technical Requirements
* When the program starts up, capsules and guests will be represented by a String[] of the appropriate size.
* Unoccupied capsules are represented by a null array value.
* Occupied capsules are represented by the occupant's name as a String.
* At least one method beyond main is required. A few more methods may make your life easier.

High Level Overview

* When the program starts up we want to prompt the user for the number of capsules

* We want to display a menu

* The user should have the ability to check a guest in 

* The user should have teh ability to check a guest out

* The user should have the ability to view guests

* The user should have the ability to exit a program 

# **Plan of Attack:**

**(Main Method)**

1. Prompt of welcome message in addition to user prompt to enter in # of capsules for the hotel which will be stored in array
2. create boolean to initialize that exit = false 
3. Create do/while loop until exit = true with a switch condition for methods
4. Print the goodbye ("verfication") message upon loop exit

**(Guest Menu)**

* List all menu options for the game (check in, check out, view guests, exit (possibly additional creative implementations if time permits)
* Guest menu options will be selectable via switch and corresponding numbers for each option

**(Check In Method)**

1. Prompt for guest name and store guest name
2. Prompt for capsule # and store in array
3. Validate that input value is a valid open capsule using conditional statement
4. Validate that the capsule is currently empty using conditional statement
5. If valid, store guest name in array 


**(Check Out Method)**

1. Prompt user for capsule # to check out
2. Validate that the corresponding capsule (index) is currently occupied by a guest using for loop. If not, then return error message notifying the user via println().
3. If the inputted capsule is indeed occupied, then use the replace function to remove the guest name from the associated position (capsule #)
4. Continue through loop and notify user that the guest has been checked out successfully


**(View Guests Method)**

1. Prompt user to select a capsule number
2. Validate that the user input number is within range of selectable capsules using for loop
3. If valid, print out range to console to include +-5 from the point of the user input designation
4. Print to console for the capsules 

*** Additional Critical Elements to Consider/Include ***

Make sure to include Scanner to capture user input

Make sure that unoccupied capsules do not print null
