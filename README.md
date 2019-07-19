# metaweatherTest
This is the repository for the metaweather test 

## Getting Started

download the project source from the repo - https://github.com/AndrewAllan/metaweatherTest.git

import the maven project into the eclipse IDE

### Libraries
 
-Rest-asured

-Junit 

-Hamcrest

-cucumber 

-log4j

## Feature File 
The Automated Testcases are marked with @Automation the manual test cases are marked with @manual

## Running the tests
Right click the TestRun class and run as junit test

### Reporting

no reporting has been provided as part of this test

### ScreenShots

no screenshot functionality has been required for this test

### logging

I have used log4j for logging purposes

## Asumptions + additional info

1.The first entry returned from the location/woeid/date get method is the high-level method for all of London this assumption is derived from the fact that the id matches the object returned for current date at location/woeid 

2.The full API is one feature. As there are multiple methods each of these could in theory be seperate features but for the purpose of this test i have grouped them under the one feature

3.If i was fully automating the api i would have used more of a object orientated approach and read the results from a list<object> to allow me easier/greater access to the result data.
 
4.The scenarios listed in the feature file are a fraction of the available scenarios and were chosen at random 

5.API functionality could be far greater than what was tested but due to lack of documentation and the scope of the test this was not investigated
