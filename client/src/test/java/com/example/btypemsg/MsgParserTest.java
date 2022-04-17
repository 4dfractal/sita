package com.example.btypemsg;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;

class MsgParserTest {

    @Test
    void parseTest() throws JAXBException {
        String bsmMessage = "BSM<≡" +
                ".V/1TZRH<≡" +
                ".F/SR101/18APR/JFK/F<≡" +
                ".N/0085123456003<≡" +
                "ENDBSM<≡";
        MsgParser parser = new MsgParser();
        BsmMessage message = parser.parse(bsmMessage);
        Assert.assertNotNull(message);
        Assert.assertEquals("BSM", message.getIdentifier());
    }

}