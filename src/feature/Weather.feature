@feature
Feature: Provide location and weather data 
					in order to allow external sorces to use the metaweather data 

  @Automation
  Scenario: Retrive 4 day Weather Forcast
    Given the Location endpoint is up 
    When A location is sent to the Api
    Then weather information for today is returned
    And weather information for tomorrow is returned
    And weather information for tomorrow plus1 is returned
    And weather information for tomorrow plus2 is returned		
		  
  @Automation
  Scenario: Retrive Weather Forcast by date
    Given the Location endpoint is up 
    When A location and todays date is sent to the location endpoint
    Then Weather data for today is retruned 	
  	

   @manual
   Scenario: invalid woeid sent to location endpoint
   Given the location endpoint is up  
   When a invalid woeid is sent to the location endpoint 
   Then message Not Found is returned
 
    
  @manual
  Scenario: Retrive location information by city
    Given the location search endpoint is up  
    When the name of a city is sent as part of the location search 
    Then location data is returned 
    |Responce feilds                                      |
    |title | location_type | latt_long | woeid | distance |
   
    
  @manual
  Scenario: no data returned when invalid location search parameture is used  
    Given the location search endpoint is up  
    When I send a invalid paramater(non city) as part of the location search 
    Then no data will be returned by the api
  
  @manual
  Scenario: Retrive location information by longitude , latitiude
    Given the location search endpoint is up  
    When a longitude and latitude is sent as part of the location search 
    Then location data is returned 
    |Responce feilds                                      |
    |title | location_type | latt_long | woeid | distance |
    
  @manual
  Scenario: No Data is returned when invalid longitude , latitiude is usd  
    Given the location search endpoint is up  
    When a invalid longitude,latitude is sent as part of the location search 
    Then no data will be returned by the api
