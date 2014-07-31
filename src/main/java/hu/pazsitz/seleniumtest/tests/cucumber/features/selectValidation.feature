@validation @select
Feature: Validation
 
    Scenario: jQuery Select Validation Page
        Given the jQuery Select Validation Page
        When fill out the Select Validation Form:
        | jungle | fruits | vegetable | cars     |
        | 1      | b,p    | s         | m_sl,o_c |
        Then validate the Select Validation Form page content:
        | jungle | fruits | vegetable | cars     |
        | 1      | b,p    | s         | m_sl,o_c |
