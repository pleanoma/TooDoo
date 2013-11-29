Feature: TooDoo conversion

  Scenario:  adddata to categorybox
    Given I am on the front page
    When I enter "My Cat" tbxcategory
    Then I should see "My Cat" 

    
    Scenario:  adddata to toodoobox
    Given I am on the front page
    When I enter "List TooDoo" tbxsubject
    Then I should see "List TooDoo" in toodoolist
  
    Scenario:  adddata to cat and toodoo
    Given I am on the front page
    When I enter "List TooDoo" tbxsubject 
    And I enter "My Cat" tbxcategory
    Then I should see "List TooDoo" in toodoolist
    And I should see "My Cat" 
  