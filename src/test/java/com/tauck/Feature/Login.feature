
Feature: Login

	Background: Navigate to till Login Off-Canvas page
		Given I am at the page which is "HomePage"
  		"""
  		SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
  		"""
		When I click on Login Link located on header
		Then I should navigate to offcanvas which is "Login_OffCanvas"
  		"""
  		Join Now
  		"""

	@Valid_Login
	Scenario Outline: Login with valid username and password

	#	Given User at the Tuack home page "Login!A1:V"
		When I input Email as "<Email>" and Password as "<Password>" and Click on Login button
		Then I should navigate to page which is "HomePage"
  		"""
  		SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
  		"""

		Examples:
			| Email                      | Password |
			| vincents728@mailinator.com | password |

	@Invalid_Login
	Scenario Outline: Login with Invalid username and password

		When I input invalid Email as "<Email>" and Password as "<Password>" and Click on Login button
		Then I should remain on Login OffCanvas page
  		"""
  		Join Now
  		"""

		Examples:
			| Email                       | Password  |
			| vincents728@mailinatorT.com | passwordT |

	@Agent_Reward_Non_Registered_User
	Scenario Outline: Agent_Reward_Non_Registered_User

		When I input Email as "<Email>" and Password as "<Password>" and Click on Login button
		Then I should navigate to page which is "HomePage"
  		"""
  		SEE THE WORLD IN A WAY YOU NEVER THOUGHT POSSIBLE
  		"""

		Examples:
			| Email                       | Password |
			| sarajanev728@mailinator.com | password |

