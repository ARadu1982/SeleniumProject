package configFile.configNode;

// Library to work with xml
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "configuration")
public class ConfigurationNode {

    @XmlElement(name = "DriverConfig")
    public DriverConfigNode driverConfigNode;

    @XmlElement(name = "DatabaseConfig")
    public DatabaseConfigNode databaseConfigNode;


}
