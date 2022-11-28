Feature: As an Automator I want to create the automation test
  of the service to update books to guarantee the quality

  Scenario Outline: Update books Happy path
    Given I generate access token
    When I update book with the information
      |IdBook  |Firstname  |Lastname  |Totalprice  |Depositpaid  |Checkin   |Checkout  |AdditionalNeeds  |
      |<IdBook>|<Firstname>|<Lastname>|<Totalprice>|<Depositpaid>|<Checkin> |<Checkout>|<AdditionalNeeds>|
    Then The service display the updated information
      |Firstname  |Lastname  |Totalprice  |Depositpaid  |Checkin  |Checkout  |AdditionalNeeds
      |<Firstname>|<Lastname>|<Totalprice>|<Depositpaid>|<Checkin>|<Checkout>|<AdditionalNeeds>

    Examples:
      |IdBook|Firstname|Lastname    |Totalprice|Depositpaid  |Checkin   |Checkout  |AdditionalNeeds|
      |3371  |Sofka    |Technologies|65000     |false        |2022-08-10|2022-09-10|Automation Test|
     # |2052  |Chris      |Redfield|213       |true         |2023-02-02|2017-03-02|454adfs&*      |