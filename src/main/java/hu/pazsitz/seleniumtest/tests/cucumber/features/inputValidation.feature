@validation
Feature: Validation
 
	Scenario: jQuery Validation Page
		Given the jQuery Validation Page
		When preFill the newsletter checkbox with true value
		When fill out the Validation Form:
		| firstname	| lastname 	| username | password | password confirm | email         | privacy pol | newsletter | marketflash | lattest fuzz | mailingList | non existent field in page model |
		| asd		| lkj		| asdLkj   | pass123  | pass123          | asd@gmail.com | true        | true       | true        | yes          | false       | dummy value                      |
		When fix the email to "asdlkj@gmail.com"
		Then validate the Validation Form page content:
		| firstname	| lastname 	| username | password | password confirm | email            | privacy pol | newsletter | marketflash | lattest fuzz | mailingList |
		| asd		| lkj		| asdLkj   | pass123  | pass123          | asdlkj@gmail.com | true        | true       | true        | yes          | false       |

