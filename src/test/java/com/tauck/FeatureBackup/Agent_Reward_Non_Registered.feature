@Agent_Reward
Feature: Agent_Reward

	Background: Login with valid user that meet the condition of "Agent reward non registered"
		Given I am at the home page
  """
  SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
  """
		When I click on Login Link located on header
		Then I should navigate to Login OffCanvas page
  """
  Join Now
  """
		When I input Email as "sarajanev728@mailinator.com" and Password as "password" and Click on Login button
		Then I should navigate to Home page
  """
  SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
  """
		And I click on "AgentConnect" Link located on header after successful login
		Then I Should navigate to MyAccount/Agent Dashboard landing page
  """
  Sarajane Vitali
  """
		And I click on following left navigation Menu


		Then I Should navigate to Agent Reward landing page
  """
  Agent Rewards
  """

