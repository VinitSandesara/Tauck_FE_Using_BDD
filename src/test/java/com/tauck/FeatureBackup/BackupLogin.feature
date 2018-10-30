When I click on "Login Link" located on header
|Login |
|LINK>>Login |
Then I Should navigate to following page
| Page            | Expected_Result        |
| Login OffCanvas | LINK>>Forgot Password? |

	Above concept is not working that's because i have POM design pattern where it required specific page object after every action
	what i mean is after clicking on Login link i will need Login off canvas page object, If i continue with this then in that case i can prevent
	duplicate steps but what will it happen is say after say i click on Agentconnect link located on header it should return Dashboard object which will
	not happpen.



Feature: Login

	Background: Navigate to till Login Off-Canvas page
		Given I am at the home page
		When I click on "Login Link" located on header
			|Login |
			|LINK>>Login |
		Then I Should navigate to following page
			| Page            | Expected_Result        |
			| Login OffCanvas | LINK>>Forgot Password? |

	@Valid_Login
	Scenario Outline: Login with valid username and password

	#	Given User at the Tuack home page "Login!A1:V"
		When I input "<Email>" as "<Input_Username>" and "<Password>" as "<Input_Password>" and Click on "<Login>" button
		Then I Should navigate to following page
			| Page            | Expected_Result        |
			| Home Page 	  | XPATH>>//div[@class='c-hero-search__form-input'] |

		Examples:
			| Input_Username             | Input_Password | Email     | Password     | Login                 |
			| vincents728@mailinator.com | password       | ID>>email | ID>>password | ID>>btnloginoffcanvas |

	@Invalid_Login
	Scenario Outline: Login with Invalid username and password

		When I input "<Email>" as "<Input_Username>" and "<Password>" as "<Input_Password>" and Click on "<Login>" button
		Then With invalid username and password I should remain on Login Off-canvas page.


		Examples:
			| Username                   | Password  | Email     | Password     | Login                 |
			|vincents728@mailinatorT.com | passwordT | ID>>email | ID>>password | ID>>btnloginoffcanvas |

	@Agent_Reward_Non_Registered_User
	Scenario Outline: Agent_Reward_Non_Registered_User

		When I input "<Email>" as "<Input_Username>" and "<Password>" as "<Input_Password>" and Click on "<Login>" button
		Then I Should navigate to home page

		Examples:
			| Username                   | Password | Email     | Password     | Login                 |
			|sarajanev728@mailinator.com | password | ID>>email | ID>>password | ID>>btnloginoffcanvas |