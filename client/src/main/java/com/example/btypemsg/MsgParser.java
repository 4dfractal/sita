package com.example.btypemsg;

import java.util.Arrays;

public class MsgParser {

    BsmMessage parse(String stringMessage) {
        BsmMessage msg = new BsmMessage();
        String[] elements = stringMessage.split("<≡");
        if ("BSM".equals(elements[0]) && "ENDBSM".equals(elements[elements.length-1])){
            msg.setIdentifier("BSM");
            for (String element : Arrays.copyOfRange(elements, 1, elements.length-1)) {

                System.out.println(element);
            }
        }
        return msg;
    }

}
