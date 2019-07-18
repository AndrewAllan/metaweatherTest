# metaweatherTest
This is the repository for the metaweather test 

Librays used 
Rest-asured
Junit 
Hamcrest
cucumber 
log4j



This is the api test automation assesment for the bbc 

## Getting Started

download the project source from the repo - XX add XX

import the maven project into the eclipse IDE

### Libraries

Librays used 
Rest-asured
Junit 
Hamcrest
cucumber 
log4j


## Running the tests
Right click the TestRun class and run as junit test

### Reporting

no reporting has been provided as part of this test

### ScreenShots

no screenshot functionality has been required for this test

### logging

I have used log4j for logging purposes i have set it to output both to file(test.log) and to console

## Asumptions

1. the first entry returned from the location/woeid/date get method is the high level method for all of london this assumption is derived from the fact that the id matches the object returned for current date at location/woeid 

2. the full api is one feature. As there are multiple methods each of these could in theory be seperate features but for the prupose of this test i have grouped them under the one feature

