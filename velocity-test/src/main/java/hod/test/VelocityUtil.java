package main.java.hod.test;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

public class VelocityUtil 
{
	public static VelocityUtil instance;
	
	public static VelocityUtil instance()
	{
		if (instance != null)
		{
			return instance;
		}
		
		
		if (instance != null)
		{
			return instance;
		}
		
		instance = new VelocityUtil();
	
		return instance;
	}
	
	private VelocityEngine engine;
	
	private VelocityUtil()
	{
		try
		{
			Properties props = new Properties();
			props.setProperty("file.resource.loader.path", "/Users/takipimbp1/Projects/tools/shits");
			props.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem"); 
			
			this.engine = new VelocityEngine(props);
			this.engine.init();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			this.engine = null;
		}
	}
	
	public Template getTemplate(String name) throws Exception
	{
		return engine.getTemplate(name);
	}
	
	public VelocityContext createContext() throws Exception
	{
		return new VelocityContext();
	}
	
	public String eval(Template template, VelocityContext ctx) throws Exception
	{
		StringWriter writer = new StringWriter();
		template.merge(ctx, writer);
		return writer.toString();
	}
}
