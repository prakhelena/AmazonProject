@test
Feature: As a user, I want to be able to buy a book, check the price and add it to cart
Background:
	Given  The user is on the homepage

Scenario: Verify if a user can choose the book, check the price from the begginning of placing order till check out
When The user enters book name "qa testing for beginners" and press enter
And The user clicks on 1st item in the listed results
And The user should verify the price for the chosen item
Then The user clicks on Add to Cart and proceed to checkout
And Verify checkout price with price on second page

