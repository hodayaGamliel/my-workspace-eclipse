package agent.chen;

import java.util.ArrayList;
import java.util.Hashtable;

//import com.newrelic.api.agent.NewRelic;
import com.takipi.sdk.v1.api.Takipi;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.events.TakipiEventResult;

public class App
{
	private static Takipi takipi;
	private static TakipiEvent event;

	static
	{
		takipi = Takipi.create("NewRelic");
		event = takipi.events().createEvent("ApolloError_nonce_12");
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("Hello World!");
		
		Takipi takipi = Takipi.create("NewRelic");
		takipi.events().createEvent("noticeError");
		
		for (int i = 0; i < 1000; i++)
		{
			new InnerClass().fire_nonce_12();
			Thread.sleep(2000);
		}
	}
	
	public static class InnerClass
	{
		public void fire_nonce_12()
		{
			ArrayList<Object> list = new ArrayList<Object>();
			
			Hashtable<String, String> table = new Hashtable<String, String>();
			list.add(table);
			
			table.put("key", "value");
			
			TakipiEventResult res = event.fire(TakipiEventFireOptions.newBuilder().addExtraContext(list).withForceSnapshot(true)
					.withMessage("Life great").build());
			
			if (res.hasSnapshot())
			{
				String id = res.getSnapshotId();
				String takipiLink = "http://tkp.to/" + id;
				System.out.println("Sent NR with map: " + takipiLink);
			}

			//NewRelic.noticeError("hello world", map);
		}
	}
}