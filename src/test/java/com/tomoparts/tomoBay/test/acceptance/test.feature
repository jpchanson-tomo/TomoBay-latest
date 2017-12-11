Feature: test feature, doing dummy login
        testing the login functionality negative case

        Scenario: Register on Guru99 demopage without email

        Given I am on the Guru99 page

        When enter blank details for register

        Then Error email shown


