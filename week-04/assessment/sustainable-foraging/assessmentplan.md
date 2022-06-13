# Sustainable Foraging Plan
## Requirements
### Items
* Name is required.
* Name cannot be duplicated.
* Category is required.
* Dollars/Kg is required.
* Dollars/Kg must be between $0 (indedible, poisonous) and $7500.
* Item ID is a system-generated unique sequential integer.
### Foragers
* First name is required
* Last name is required
* State is required
* The combination of first name, last name, and state cannot be duplicated.
* Forager ID is a system-generated GUID (globally unique identifier).
### Forages
* Item is required and must exist.
* Forager is required and must exist.
* Date is required and must not be in the future.
* Kilograms must be a positive number not more than 250.
* The combination of Date, Item, and Forager cannot be duplicated. (Cannot forage the same item on the same day. It should be tracked as one Forage.)
* Forage ID is a system-generated GUID (globally unique identifier).
## Technical Requirements
In addition to application features, please add Spring dependency injection to the project. You may configure Spring DI with either XML or annotations. Recommend using annotations since the remainder of the course focuses on this over XML.

Generate the kilogram/item report with streams and total value/category report with loops and intermediate variables, but keep the ultimate goal in mind: using data to create accurate reports. If one approach gives you too much trouble, use the other to solve the data problem.

All financial math must use BigDecimal.

Dates must be LocalDate, never strings.
### File Format
Foragers and Items are stored in comma-delimited files with a header. You may not change the delimiter or alter the header. If possible, prevent commas from being added to data. An extra comma will prevent the repositories from reading the record.

Forage data is stored in what we call an "unfortunate decision". Each day's data is stored in a separate file with the naming convention: yyyy-MM-dd.csv.
### Testing
All new features must be thoroughly tested. You are not responsible for creating testing for existing features unless you find a bug. If you find a bug, please create a test to confirm the expected behavior and prevent regressions.
## Approach
### Overview of To-Dos:
#### Addition of Spring Dependency Injection:

1. Setup XML components.
2. Initialize all needed repositories, services, view, and finally the Controller.
3. Create App Context in App Class and call Controller.run() in order to execute the application.
****
### Specific To-Dos:
#### Debugging & Verification of Existing Features:

1. Test functionality to 'Exit'
2. Test functionality to 'View Forages By Date'
3. Test functionality to 'View Items'
4. Test functionality to 'Add a Forage'
5. Test functionality to 'Add a Forager'
6. Test functionality to 'Add an Item'
7. Test functionality to 'Report: Kilograms of Item'
8. Test functionality to 'Report: Item Category Value'
* Begin by running the application in its current state, going through each feature/functionality, and identify the missing components/bugs and make note of them. Aside from what has already been given to us in terms of functionalities that are not currently working (addForager and both reporting functionalities), I am also noticing
that there is no validation to ensure that 'poisonous' and 'inedible' item types cannot be assigned anything other than a $0 value. This needs to be addressed with another else/if statement in the ItemService class.
****
#### Implement functionality to 'Add a Forager':
1. Create new addForager() method (be sure to generate tests immediately upon creation of this method). This should add Forager to list of Foragers and also write the Forager to the data file.
****
#### Generate a report for Kilograms for every item for a given day:
1. User prompted date to generate a report. Will utilize BigDecimal in operation of multiplying number of kilos for a specific item by the dollars/kilo field.
2. Need to figure out how to test utilizing the ForageFileRepository.
#### Generate a report for total value/category for a given day:
1. User prompted message to view forages by date using the getForageDate() method that has already been given to us in the View class.
2. Create a Map<> to instantiate 'categoryValues' which will initialize a stream of forages.
3. Will call upon the necessary methods to eventually print the categories and the dollar value for each category. A new method to do this will
have to be created in the view class.