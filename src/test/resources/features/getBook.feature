Feature: As an Automator I want to create the automation test
  of the service to consult book to guarantee the quality

  Scenario Outline: Consult book Happy path
    When I request book information with id "<BookId>"
    Then The service must show
      |Firstname  |Lastname  |Totalprice  |Depositpaid  |Checkin  |Checkout  |AdditionalNeeds
      |<Firstname>|<Lastname>|<Totalprice>|<Depositpaid>|<Checkin>|<Checkout>|<AdditionalNeeds>

    Examples:
      |BookId|Firstname  |Lastname|Totalprice|Depositpaid  |Checkin   |Checkout  |AdditionalNeeds|
      |11484 |Dane       |Combs   |111       |true         |2018-01-01|2019-01-01|Breakfast      |
     # |2052  |Chris      |Redfield|213       |true         |2023-02-02|2017-03-02|454adfs&*      |