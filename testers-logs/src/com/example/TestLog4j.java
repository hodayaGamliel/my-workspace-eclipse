package com.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class TestLog4j {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public String tmp = "sdfs";
	public int nonce = 5;
	
	public static int counter =1;
	public static int asdfsadfs(String[] args) 
	{ 
		
		try 
		{
			Thread.sleep(2000);
			
			if (counter++ < 5)
			{
				logger.error("ssasasa");
				Thread.sleep(6000);
				logger.error("ssasasa");
				Thread.sleep(6000);
				logger.debug("adfassaddfsdf");
				logger.warn("afdasfdf");
				Thread.sleep(6000);
				logger.warn("afdasfdddf");
				Thread.sleep(6000);
			}
			else if (counter++ < 1000 && args.length < 1000)
			{
			
				logger.error("ssasasa");
				Thread.sleep(6000);
				logger.error("ssasasa");
				Thread.sleep(6000);

				logger.warn("afdasdfsdfdf");
				Thread.sleep(6000);
				logger.warn("afdasfsdfdf");
				Thread.sleep(6000);
				logger.warn("afdasfdf");
				Thread.sleep(6000);
				logger.error("ssasasa");
				Thread.sleep(6000);
				logger.error("ssasasa");
				Thread.sleep(6000);
				throw new Exception();
//				logger.warn("afdasfdf");
//				return 0;
			}
			else
			{
				System.out.println(5 / (args.length - args.length));
			}
			
			return 1;
		} 
		catch (Exception e) 
		{
			System.out.print("aaa\n\n");
		}
		return 1;
	}
	
	static void listFiles(Path path) throws IOException, InterruptedException 
	{
//	   try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
//	        for (Path entry : stream) 
//	        {
//	            if (Files.isDirectory(entry)) 
//	            {
//	            	System.out.print(entry.toAbsolutePath());
//	            	System.out.print(";");
//	            	Thread.sleep(100);
//	            	listFiles(entry);
//	                
//	            }
//	           
//	        }
//	    }
	}
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
//		CodeAnalysisInterface codeAnalysis = IOUtil.getCodeAnalysis();
//        byte[] bytes = codeAnalysis.getClassBytes("J277063", "UhXR8FCmMvL00");
//        
//        FileUtils.writeByteArrayToFile(new File("C:\\Users\\Hen\\Desktop\\t.class"), bytes);
//		UpdateRunningApplicationsServlet servlet = new UpdateRunningApplicationsServlet();
//		
//		
//		PUpdateRunningApplications.Builder builder =  PUpdateRunningApplications.newBuilder();
//		PApplicationKeys.Builder appKey = PApplicationKeys.newBuilder();
//		
//		List<ApplicationKey> appKeys = new ArrayList<ApplicationKey>();
//		
//		appKeys.add(new ApplicationKey("S4123", "C49625"));
//		appKeys.add(new ApplicationKey("S4123", "C51304"));
//		appKeys.add(new ApplicationKey("S4123", "C51307"));
//		appKeys.add(new ApplicationKey("S4123", "C51309"));
//		
//		List<PApplicationKey> list = new ArrayList<PApplicationKey>();
//		
//		for (ApplicationKey ak : appKeys)
//		{
//			list.add(ak.toProto());
//		}
//		
//		
//		
//		builder.setKeys(appKey);
//		builder.setServiceId("S4123");
//		
//		StringConverter convert = new UniversalHashConverter(SanitizerUtil.DEFAULT_PREFIX, null);
//		
//		String name = convert.convertClassName( "com/sparktale/bugtale/server/common/distribute/map/TakipiHazelcastMapWrapper") ;
//		
//		CodeAnalysisInterface codeAnalysisInterface = IOUtil.getCodeAnalysis();
//		
//		//Set<String> jarList = TailorJarShifter.getSourceCodeJarList("S6295", name, codeAnalysisInterface);
//		
//		System.out.println(jarList);
		
		
//		String directory = "C:\\Users\\hen\\sparktale\\Git\\takipi-dev";
//		
//		Path dir = FileSystems.getDefault().getPath( directory );
//		DirectoryStream<Path> stream = Files.newDirectoryStream( dir );
//		Path path = FileSystems.getDefault().getPath(directory);
//		
//		//listFiles(path);
//		
//	
//		Set<String> stringSet = new HashSet<String>();
//		stringSet.add(null);
//		stringSet.add("safasgsfsagsdf");
//		stringSet.add("safceassdaffsag");
//		stringSet.add("safeceasfsdfsagsdf");
//		stringSet.add("safecweassdfsdfssdfag");
//		stringSet.add("safsdfasfssdfagsdf");
//		stringSet.add("safasdfsfssdfag");
//		stringSet.add("safesadfasfssdfagsdf");
//		stringSet.add("safeasfsasdfag");
//		stringSet.add("safasfsasdfgsdf");
//		stringSet.add("saeefasfssdfag");
//		stringSet.add("safaesfsasdfgsdf");
//		stringSet.add("safasfssdfag");
//		stringSet.add("safasfesdsfaagsdf");
//		stringSet.add("safasfeseesdfasag");
//		stringSet.add("safasfsasdfagsdf");
//		stringSet.add("safasfsaseadfsfg");
//		stringSet.add("safasfsaegssadfdf");
//		stringSet.add("safasfsaeesdfsag");
//		stringSet.add("safasfeseagssdfdf");
//		stringSet.add("safaseefsaasdfg");
//		stringSet.add("safasfsagsasdf");
//		stringSet.add("safaseewefsag");
//		stringSet.add("safasefsagsdf");
//		stringSet.add("safasefesag");
//		stringSet.add("safaeseffsagsdf");
//		stringSet.add("safasesedffsag");
//		stringSet.add("safasfseadfsagsdf");
//		stringSet.add("ssdfaeefasfsag");
//		stringSet.add("safasfsfdassagsdf");
//		stringSet.add("safesfadasfsag");
//		stringSet.add("safaesfsagsdf");
//		stringSet.add("saefasfsag");
//		stringSet.add("safasfsaeecgsdf");
//		stringSet.add("safasfsecag");
//		stringSet.add("safasfsagefvesdf");
//		stringSet.add("safasfssdeag");
//		stringSet.add("safefsaasfsagsdf");
//		stringSet.add("safsfsag");
//		stringSet.add("sasdffasfsagsdf");
//		
//		Set<String> stringtempSet= new HashSet<String>();
//		
//		stringtempSet.add("tete");
//		stringtempSet.add(null);
//		
//		List<String> stringList = new LinkedList<String>();
//		
//		stringList.add("asdfasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfasfsadf");
//		stringList.add(null);
//		stringList.add("dfasdg");
//		stringList.add("asdfasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfasfsadf");
//		stringList.add("fddf");
//		stringList.add("dfadsdg");
//		stringList.add("asdfgasf");
//		stringList.add("dfagsdg");
//		stringList.add("sdfasfsadf");
//		stringList.add("fddgf");
//		stringList.add("dfasdg");
//		stringList.add("asdgfasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfgasfsadf");
//		stringList.add("fddgf");
//		stringList.add("dfasdg");
//		stringList.add("asdgfasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfagsfsadf");
//		stringList.add("fddfg");
//		stringList.add("dfasdg");
//		stringList.add("asdfgasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfdasfsadf");
//		stringList.add("fdsdf");
//		stringList.add("dfasdg");
//		stringList.add("asdfasf");
//		stringList.add("dfassdg");
//		stringList.add("sdfasfsadf");
//		stringList.add("fdsdf");
//		stringList.add("dfasdg");
//		stringList.add("assdfasf");
//		stringList.add("dfsasdg");
//		stringList.add("sdfsasfsadf");
//		stringList.add("fdsdf");
//		stringList.add("dfasdg");
//		stringList.add("asdfasf");
//		stringList.add("dfasdg");
//		stringList.add("sdfasfsadf");
//		stringList.add("fddf");
//		stringList.add("dfasdg");
////		
//		List<String> stringArrayListt = new ArrayList<String>();
//		
//		stringArrayListt.add("asdfasf");
//		stringArrayListt.add("dfasdg");
//		stringArrayListt.add("sdfasfsadf");
//		stringArrayListt.add("fddf");
//		stringArrayListt.add("dfasdg");
//		
		
		
		while (true) 
		{
				
			try
			{
				if (asdfsadfs(args) == 0)
				{
					return;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}


