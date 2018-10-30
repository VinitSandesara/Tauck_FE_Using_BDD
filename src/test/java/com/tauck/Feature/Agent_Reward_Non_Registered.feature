# Every button, Links will have different action associated with hence better approach to keep separate step

@Agent_Reward
Feature: Agent_Reward

  Background: Login with valid user that meet the condition of "Agent reward non registered"
    Given I am at the page which is "HomePage"
      """
      SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
      """
    When I click on Login Link located on header
    Then I should navigate to offcanvas which is "Login_OffCanvas"
      """
      Join Now
      """
    And I input Email as "sarajanev728@mailinator.com" and Password as "password" and Click on Login button
    Then I should navigate to page which is "HomePage"
      """
      SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
      """
    When I click on following menu located on header after successful login
      | HeaderMenu    |
      | Agent Connect |
    Then I should navigate to page which is "MyAccountPage"
      """
      Sara-Jane Vitali
      """
    When I click on following Menu located on left navigation
      | Menu          |
      | Agent Rewards |
    Then I should navigate to page which is "AgentReward"
      """
      AGENT REWARDS
      """

  @Veriy_earn_choose_and_travel_Flexcards
  Scenario: Verify Earn, Choose and Travel Flex Cards
    Given I am at the page which is "AgentReward"
        """
        AGENT REWARDS
        """
    And I need to verify following list of flex cards for non registered agent rewards
      | FlexCards          |
      | Earn,Choose,Travel |


  @Sign_Up_Non_Registered_Agent_Reward
  Scenario: Sign Up user
    Given I am at the page which is "AgentReward"
        """
        AGENT REWARDS
        """
    When I click on Sign Up Now button

    Then I should navigate to offcanvas which is "SignUp_OffCanvas"
         """
         Thanks!
         """


