package DataConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    private final Properties properties;

    /**
     * Method to read config values
     */
    public ReadConfig(){
        BufferedReader bufferedReader;
        FileReader fileReader;
        String strPropertyPath="config/configuration.properties";
        try{
            fileReader=new FileReader(strPropertyPath);
            bufferedReader=new BufferedReader(fileReader);
            properties=new Properties();
            try{
            properties.load(bufferedReader);
            bufferedReader.close();
        } catch(IOException ex){
            ex.printStackTrace();
        }

    }catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Config file not found at "+strPropertyPath);
        }
}
public String getBaseURL() {

    String strProp = properties.getProperty("Base_URL");
    if (strProp != null) {
        return strProp;
    } else {
        throw new RuntimeException("Base_URL is not present in the config property");
    }
}

    public String getRelativeCodeEndPoint() {

        String strProp = properties.getProperty("RelativeCode_EndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("RelativeCode_EndPoint is not present in the config property");
        }
    }
    public String getCharacteristicsNamesEndPoint() {

        String strProp = properties.getProperty("CharacteristicsNames_EndPoint");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("CharacteristicsNames_EndPoint is not present in the config property");
        }
    }
    public String getVeniceBaseURL() {

        String strProp = properties.getProperty("Venice_BaseURL");
        if (strProp != null) {
            return strProp;
        } else {
            throw new RuntimeException("Venice_BaseURL is not present in the config property");
        }
    }


    }

