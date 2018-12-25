Feature: AutomationPractice


@smoke
Scenario: Verify Tabs - Women, Dresses and T-shirt are displayed on Home Page.
Given User enters the homepage
Then User checks tabs exists

@Regression
Scenario: Subscription Message
Given User on home Page
When User enters valid email address
Then Subscription message is displayed


@Sanity
Scenario Outline: Successful Navigation to Corresponding Pages
Given User is on home page
When User clicks on the <tabs>
Then user enters corresponding <tabs>

Examples:
|tabs|
|WOMEN|
|DRESSES|
|T-SHIRTS|

@sizeverify
Scenario Outline: Successful Verification of Size
Given User clicks DressesPage
Then User checks <sizes>
Examples:
|sizes|
|S|
|M|
|L|


@VerifyCount
Scenario: Successful Count Check
Given User is on DressesPage and calculate number of products present in text
When User counts number of products
Then User verify whether products are equal

@VerifyProductInCartPage
Scenario: Successful verification of Product on Cart Page
Given User is on Dresses Page
When Click the products and moves to Cart Page
Then Verify the product is displayed on the Cart Page

@VerifyTweetIsDisplayed
Scenario: Verify Tweet is Displayd
Given User is on Product Page
Then User check Tweet is Displyaed


@VerifyProductMessageIsDisplayed
Scenario: Successful display of Product Message
Given User is on the Product Message
When User checks the WebTable
Then user asserts the product message

@VerifyDressArrangedInAscendingOrder
Scenario: Dresses Arranged in Ascending Order
Given User is on Dresses Pages
When User clicks to Sort from A to Z
Then Check whether dressed appeared in the Sorted Order