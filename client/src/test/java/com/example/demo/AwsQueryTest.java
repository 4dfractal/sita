package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * AwsResponceTest.
 */
class AwsQueryTest {

    @Test
    void unmarshalTest() throws JAXBException {
        String queryXml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                "<AWS_Query>\n" +
                "<Workstation>workstation name</Workstation>\n" +
                "<Operator>operator name</Operator>\n" +
                "<BID>BID</BID>\n" +
                "<Timestamp>yyyyMMddHHmmss</Timestamp>\n" +
                "</AWS_Query>";
        JAXBContext context = JAXBContext.newInstance(AwsQuery.class);
        StringReader reader = new StringReader(queryXml);
        AwsQuery queryObject = (AwsQuery) context.createUnmarshaller().unmarshal(reader);
        Assert.assertNotNull(queryObject);
        Assert.assertEquals("BID", queryObject.getBid());
    }

    @Test
    void marshalTest() throws JAXBException {
        String query = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<AWS_Query>\n" +
                "    <Workstation>workstation name</Workstation>\n" +
                "    <Operator>operator name</Operator>\n" +
                "    <BID>BID</BID>\n" +
                "    <Timestamp>20220125102030</Timestamp>\n" +
                "</AWS_Query>";

        AwsQuery awsQuery = new AwsQuery();
        awsQuery.setBid("BID");
        awsQuery.setOperator("operator name");
        AwsQuery.DateAdapter adapter = new AwsQuery.DateAdapter();
        try {
            awsQuery.setTimestamp(adapter.unmarshal("20220125102030"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        awsQuery.setWorkstation("workstation name");
        StringWriter sw = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(AwsQuery.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(awsQuery, sw);

        System.out.println(sw.toString());

        Assert.assertNotNull(sw);
        Assert.assertEquals(query, sw.toString().trim());
    }

}