`Feature: 
  To proceed the product for checkout after adding the product to card
	
  Scenario: 
    Checkouting functionality for the product to delivery

    Given amazone page
    And maximize the product
    When search the product
    And click the searched product
    And click add to cart
    And proceed for payment
    Then need to be in signin page
