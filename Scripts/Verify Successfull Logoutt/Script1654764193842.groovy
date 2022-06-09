import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.media.rtsp.protocol.StatusCode

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response1 = WS.sendRequest(findTestObject('TestAPIs/Loginn'))

println(response1.getStatusCode())

WS.verifyResponseStatusCode(response1, 200)

assertThat(response1.getStatusCode()).isEqualTo(200)

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(response1.getResponseBodyContent())

Accesstoken = result.access_token

Idtoken = result.id_token

Session = result.session

//println(Accesstoken) 
GlobalVariable.accesstoken = Accesstoken

GlobalVariable.idtoken = Idtoken

GlobalVariable.session = Session

println('..........This is a accesstoken........' + GlobalVariable.accesstoken)

println('..........This is a idtoken........' + GlobalVariable.idtoken)

println('..........This is a session........' + GlobalVariable.session)

WS.sendRequest(findTestObject('TestAPIs/Logoutt'))

