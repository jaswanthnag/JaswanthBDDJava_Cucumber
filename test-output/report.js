$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression99"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Launch Chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.user_Launch_Chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL \"http://admin-demo.nopcommerce.com/login\"",
  "keyword": "When "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.user_opens_URL(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters Email as \"admin@yourstore.com\" and Password as \"admin\"",
  "keyword": "And "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.user_enters_Email_as_and_Password_as(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.click_on_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page Title should be \"Dashboard / nopCommerce administration\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.page_Title_should_be(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Log out link",
  "keyword": "When "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.user_click_on_Log_out_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Page Title should be \"Your store. Login Test\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.page_Title_should_be(java.lang.String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003cYour store. Login[ Test]\u003e but was:\u003cYour store. Login[]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:117)\r\n\tat org.junit.Assert.assertEquals(Assert.java:146)\r\n\tat Jaswanth.Automation.StepDefinitions.LoginPageSteps.page_Title_should_be(LoginPageSteps.java:125)\r\n\tat ✽.Page Title should be \"Your store. Login Test\"(file:///G:/Selenium%20BDD%20Framework/JaswanthBDDJava_Cucumber/./features/Login.feature:11)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Jaswanth.Automation.StepDefinitions.LoginPageSteps.close_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.write("this is my failure message");
formatter.embedding("image/png", "embedded0.png", "Successful_Login_with_Valid_Credentials");
formatter.after({
  "status": "passed"
});
});