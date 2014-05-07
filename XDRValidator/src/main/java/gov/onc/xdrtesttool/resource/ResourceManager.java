package gov.onc.xdrtesttool.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ResourceManager {
	public static final ResourceManager instance = new ResourceManager();
	List<String> conceptCodes = new ArrayList();
	List<String> conceptNameSpecialityArea = new ArrayList();
	Map<String, String> contextMetadataTypes = new HashMap(); 
	
	private ResourceManager()
	{
		loadConceptCodes("gov/onc/xdrtest/resource/ConceptCodes.properties");
		loadConceptNameSpecialityAreas("gov/onc/xdrtest/resource/ConceptNameSpecialityArea.properties");
		loadContextMetadataTypes("gov/onc/xdrtest/resource/XDSContextMetadataTypes.properties");
	}
	
	public List<String> getConceptCodes()
	{
		return conceptCodes;
	}
	
	public List<String> getConceptNameSpecialityAreas()
	{
		return conceptNameSpecialityArea;
	}

	private void loadContextMetadataTypes(String fileName)
	{
		Properties props = loadProperties(fileName);
		if(props != null)
		{
			Iterator iter = props.keySet().iterator();
			while(iter.hasNext())
			{
				String context = (String)iter.next();
				String metadata = props.getProperty(context);
				contextMetadataTypes.put(context, metadata);
			}
		}
	}

	private void loadConceptCodes(String fileName)
	{
		Properties props = loadProperties(fileName);
		if(props != null)
		{
			Iterator iter = props.keySet().iterator();
			while(iter.hasNext())
				conceptCodes.add((String)iter.next());
		}
	}
	
	private void loadConceptNameSpecialityAreas(String fileName)
	{
		Properties props = loadProperties(fileName);
		if(props != null)
		{
			Iterator iter = props.keySet().iterator();
			while(iter.hasNext())
				conceptNameSpecialityArea.add((String)iter.next());
		}
	}

	private Properties loadProperties(String fileName)
	{
    	InputStream input = null;
    	Properties props = null;
    	try {
    		input = XDRMessages.class.getClassLoader().getResourceAsStream(fileName);
    		if(input==null){
    	            System.out.println("Failed to load message text properties "+ fileName +" from the classpath");
    		    return null;
    		}
    		props = new LinkedProperties();
    		props.load(input);
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    	return props;
	}
	
	public String getMetadataType(String context)
	{
		return contextMetadataTypes.get(context);
	}
	
}
