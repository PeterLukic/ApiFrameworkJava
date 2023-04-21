Feature: Timestamp
  Timestamp test scenario

  #+ value
  Scenario: Convert Unix TimeStamp to Date String 1
    Given I perform GET Convert Unix TimeStamp to Date String with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=12321321"
    And  I assert value from unix timeStamp

  #- value
  Scenario: Convert Unix TimeStamp to Date String 2
    Given I perform GET Convert Unix TimeStamp to Date String with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=-12321321"
    And I assert value from unix timeStamp

  #POST
  Scenario: Convert Unix TimeStamp to Date String 3
    Given I perform POST Convert Unix TimeStamp to Date String with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=-12321321"
    And I assert value from unix timeStamp

  #DELETE
  Scenario: Convert Unix TimeStamp to Date String 3
    Given I perform DELETE Convert Unix TimeStamp to Date String with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=-12321321"
    And I assert value from unix timeStamp

  # past time
  #also testing with different format date value
  Scenario: Convert From Date String to Unix TimeStamp 1
    Given I perform GET Convert Date String to Unix TimeStamp with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=2019-01-01"
    And I assert value from date time

  # future time
  Scenario: Convert From Date String to Unix TimeStamp 2
    Given I perform GET Convert Date String to Unix TimeStamp with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=2039-01-01"
    And I assert value from date time

  # 2 dates
  Scenario: Convert From Date String to Unix TimeStamp 3
    Given I perform GET Convert Date String to Unix TimeStamp with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=2016-01-01%202:3:22&s2016-01-01%202:3:22"
    And I assert value from date time


  # invalid value
  Scenario: Convert Invalid Value
    Given I perform GET Convert Date String to Unix TimeStamp with value "https://helloacm.com/api/unix-timestamp-converter/?cached&s=null"
    And I assert invalid value


