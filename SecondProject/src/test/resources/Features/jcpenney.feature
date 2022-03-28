@tag
Feature: I want to verify search functionality
  
  Background: Given I am on Home Page
  #Adanya tulisan di atas ini membuat kita tidak perlu menulis Given I am on Home Page pada scenario
  
  @Smoke
  Scenario: Verify product in jcpenney
    #Given I am on Home Page
    When I search product
    Then I verify product listed succesfully on product details page

@Regression
 Scenario: verify product in application
    #Given I am on Home Page
 #   When I search product 'Nike Flex' in application
  #  Then I verify 'Nike Flex' display succesfully on page
  When I search product "<product>" in application
   Then I verify "<product>" display succesfully on page

   Examples:
   |product|
   |Nike Flex|
   |Nike Air|
   |Fieldcrest Devin|