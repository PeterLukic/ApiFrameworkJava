package config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    public static  void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }
    private void ReadProperty() throws IOException {
        //Create Property Object
        Properties p = new Properties();
        //Load the Property file available in same package
        InputStream inputStream = Files.newInputStream(Paths.get("src/main/resources/GlobalConfig.properties"));
        p.load(inputStream);
        //Get values from property String
        Settings.Url = p.getProperty("url");
        Settings.UsernameXmlHeader = p.getProperty("usernameXmlHeader");
        Settings.PasswordXmlHeader = p.getProperty("passwordXmlHeader");
        Settings.ExternId = p.getProperty("externId");
        Settings.EventId = p.getProperty("eventId");
        Settings.PriceId = p.getProperty("priceId");
        Settings.PriceCategoryId = p.getProperty("priceCategoryId");
        Settings.TicketTypeId = p.getProperty("ticketTypeId");
        Settings.OrderId = p.getProperty("orderId");
        Settings.TicketId = p.getProperty("ticketId");
        Settings.CustomerId = p.getProperty("customerId");
        Settings.PriceComponentId = p.getProperty("priceComponentId");
        Settings.SellerId = p.getProperty("sellerId");
        Settings.ExternalSpaceReference = p.getProperty("externalSpaceReference");
        Settings.ResponseXml = p.getProperty("responseXml");
        Settings.DecodeXml = p.getProperty("decodeXml");
    }
}
