@LXLive
Feature: Validation
 
    Scenario: jQuery Validation Page
        Given the LX result page in Rome "http://www.expedia.com/lx/?location=rome&startDate=2014-08-19&endDate=2014-08-19&regionId=179899"
        When I select the 2 Activity
        When on the Activity Details page I book the cheapest Price 
        Then I go to the Checkout Page
        Then the user fills the necessary fields for Trip Preferences widget on Lx Checkout page
	    | ContactName       | Email                 | Phone        |
	    | Pista IIT Besenyo | ckotester@expedia.com | 894654165465 |
	    Then the user fills the necessary fields for Payment widget on Lx Checkout page
	    | CardNumber        | CardType    | ExpirationDateMonth     | ExpirationDateYear     | CID   | CardHolderName     | ZIP    |
	    | 4111111111111111  | Visa        | 07-Jul                  | 2033                   | 123   | Joe Blobbs         | 12345  |
        Then the user submits LX Booking
		Then It fails
        