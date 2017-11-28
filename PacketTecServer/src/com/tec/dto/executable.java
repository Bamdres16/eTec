package com.tec.dto;
import org.json.simple.JSONObject;

public class executable{

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String TEST_XML_STRING =
        "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static void main(String[] args) {
    	
        System.out.println(TEST_XML_STRING);
    }
}