package exerciseJsonToXml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonXmlConverter {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final XmlMapper XML_MAPPER = new XmlMapper();

    // Convert JSON to XML
    public static String jsonToXml(String jsonString) throws JsonProcessingException {
        JsonNode jsonNode = JSON_MAPPER.readTree(jsonString);
        return XML_MAPPER.writeValueAsString(jsonNode);
    }

    // Convert XML to JSON
    public static String xmlToJson(String xmlString) throws JsonProcessingException {
        JsonNode jsonNode = XML_MAPPER.readTree(xmlString.getBytes());
        return JSON_MAPPER.writeValueAsString(jsonNode);
    }

    // Example usage
    public static void main(String[] args) throws JsonProcessingException {
        // Serialize from JSON to XML
        String json = "{\"name\":\"yassine\",\"age\":21,\"city\":\"marrakech\"}";
        String xml = jsonToXml(json);
        System.out.println("JSON to XML:");
        System.out.println(xml);

        // Deserialize from XML to JSON
        String xml2 = "<Object><name>yassine</name><age>21</age><city>marrakech</city></Object>";
        String json2 = xmlToJson(xml2);
        System.out.println("XML to JSON:");
        System.out.println(json2);
    }
}
