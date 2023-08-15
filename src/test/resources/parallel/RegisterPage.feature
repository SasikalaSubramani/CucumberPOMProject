Feature: Contact Us Feature

Scenario Outline: Register page scenario with different set of data
Given user navigates to register page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on continue button
Then it shows a successful message "Your Account Has Been Created!"

Examples:
|SheetName|RowNumber|
|register|0|
|register|1|
#|register|2|
#|register|3|
#|register|4|
#|register|5|