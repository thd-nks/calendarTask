package services;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.containers.Century;

import java.io.*;

public class FileService {


    public void serialize(Century century,String filename){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java Projects\\calendarTask\\files\\" + filename + ".dat")))
        {
            oos.writeObject(century);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public void JSONize(Century century,String filename){

        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
        try{
            mapper.writeValue(new File("D:\\Java Projects\\calendarTask\\files\\" + filename + ".json"), century);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void XMLize(Century century,String filename) throws IOException{
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File("D:\\Java Projects\\calendarTask\\files\\" + filename + ".xml"), century);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public Century loadFromFile(String filename, String format) throws Exception{
        Century century = new Century();
        switch (format){
            case ("dat"):
                try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java Projects\\calendarTask\\files\\" + filename + ".dat")))
                {
                    century = (Century) ois.readObject();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                break;
            case ("json"):
                ObjectMapper objectMapper = new ObjectMapper();
                //File file = new File("D:\\Java Projects\\calendarTask\\files" + filename + ".json");
                try{
                    century = objectMapper.readValue(new FileInputStream("D:\\Java Projects\\calendarTask\\files\\" + filename + ".json"), Century.class);
                }
                catch (JsonGenerationException e) {
                    e.printStackTrace();
                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case ("xml"):
                XmlMapper xmlMapper = new XmlMapper();
                century = xmlMapper.readValue(new FileInputStream("D:\\Java Projects\\calendarTask\\files\\" + filename + ".xml"), Century.class);
                break;
        }

        return century;
    }
}
