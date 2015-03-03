package com.mobilend;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;


/**
 * Created by amitsaxena on 2/24/15.
 */
public class MicrobiltSample {
    private static String memberId = "CCC0007118";
    private static String memberpw = "1312141421";
    private static String baseUrl = "https://sdkstage.microbilt.com/WebServices/IBVAPI/";
    private Logger logger = LoggerFactory.getLogger(MicrobiltSample.class);

    private RestTemplate template = new TestRestTemplate();

    public static  String reqxml = "<Request xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n"+
            "\n"+
            "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"+
            "\n"+
            "  <MemberId>" + memberId +
            "</MemberId>\n"+
            "\n"+
            "  <MemberPwd>" + memberpw +
            "</MemberPwd>\n"+
            "\n"+
            "  <CallbackType>XML</CallbackType>\n"+
            "\n"+
            "  <CallbackURL>XML</CallbackURL>\n"+
            "\n"+
            "  <ContactBy>BOTH</ContactBy>\n"+
            "\n"+
            "  <Reference>XML</Reference>\n"+
            "\n"+
            "  <Customer>\n"+
            "\n"+
            "    <FirstName>Tom</FirstName>\n"+
            "\n"+
            "    <LastName>Jones</LastName>\n"+
            "\n"+
            "    <SSN>000000610</SSN>\n"+
            "\n"+
            "    <DOB>1975-03-05T00:00:00</DOB>\n"+
            "\n"+
            "    <Address>624 Springfield Lane </Address>\n"+
            "\n"+
            "    <City>Springfield</City>\n"+
            "\n"+
            "    <State>WA</State>\n"+
            "\n"+
            "    <ZIP>01234</ZIP>\n"+
            "\n"+
            "    <Country>USA</Country>\n"+
            "\n"+
            "    <Phone/>\n"+
            "\n"+
            "    <WorkPhone/>\n"+
            "\n"+
            "    <CellPhone>8883214321</CellPhone>\n"+
            "\n"+
            "    <Email>tom_jones@fake.com</Email>\n"+
            "\n"+
            "    <ABANumber>123456789</ABANumber>\n"+
            "\n"+
            "    <AccountNumber>1234</AccountNumber>\n"+
            "\n"+
            "    <AccountType>Checking</AccountType>\n"+
            "\n"+
            "    <DirectDepositAmount>1.0000</DirectDepositAmount>\n"+
            "\n"+
            "    <DirectDepositPayCycle>Every week</DirectDepositPayCycle>\n"+
            "\n"+
            "  </Customer>\n"+
            "\n"+
            "</Request>";


    public String  initiateRequest() {


        String token =  template.postForObject(baseUrl + "/api/request", reqxml , String.class);

        logger.trace(token);

        return token;
    }


public static void  main(String[] args) {

    MicrobiltSample sample = new MicrobiltSample();
    sample.initiateRequest();

}


}
