package hodaya;

import java.util.ArrayList;
import java.util.Collection;

import com.takipi.sdk.v1.api.Takipi;
import com.takipi.sdk.v1.api.TakipiOptions;
import com.takipi.sdk.v1.api.core.contexts.TakipiContext;
import com.takipi.sdk.v1.api.core.events.TakipiEvent;
import com.takipi.sdk.v1.api.core.events.TakipiEventFireOptions;
import com.takipi.sdk.v1.api.core.metrics.TakipiAverageMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiCountMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiLatestMetric;
import com.takipi.sdk.v1.api.core.metrics.TakipiSumMetric;

public class AkkaTest {

	public static void main(String[] args) throws InterruptedException 
	{
	
		Takipi t1 = Takipi.create("tzofia", TakipiOptions.newBuilder().withDebugEnabled(true).build());
		Takipi t2 = Takipi.create("akka", TakipiOptions.newBuilder().withDebugEnabled(true).build());
		Takipi t3 = Takipi.create("wix-new-relic", TakipiOptions.newBuilder().withDebugEnabled(true).build());

		new Thread(new Runnable() {
	
			@Override
			public void run() 
			{
				while (true)
				{	
					try {
						mainSDK(t1, t2, t3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(1000*5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
		
	public static void mainSDK(Takipi tzofiaT, Takipi akkaT, Takipi newRelicT) throws InterruptedException
    {
        // Events
        //
        TakipiEvent tzofiaEvent = tzofiaT.events().createEvent("TzofiaEvent3");
        TakipiEvent akkaEvent = akkaT.events().createEvent("AkkaEvent3");
        TakipiEvent newRelicEvent = newRelicT.events().createEvent("NewRelicEvent5");
        
        Collection<Object> extraContext = new ArrayList<Object>();
        extraContext.add(tzofiaT);
        extraContext.add(tzofiaEvent);
        extraContext.add("text 123456789");
        extraContext.add(123456789);
        
        TakipiEventFireOptions tzofiaOptions = TakipiEventFireOptions.newBuilder()
                .withForceSnapshot(true).withMessage("This is my message").withExtraContext(extraContext)
                .build();
        
        tzofiaEvent.fire(tzofiaOptions);
        akkaEvent.fire();
        newRelicEvent.fire(tzofiaOptions);
        
//        // Metrics
//        //
//        TakipiContext context1 = tzofiaT.contexts().createContext(AkkaTest.class, "a/b/c");
//        TakipiContext context2 = tzofiaT.contexts().createContext(AkkaTest.class);
//        TakipiAverageMetric avgMetric = tzofiaT.metrics().createAverageMetric("tzofia average metric");
//        TakipiCountMetric countMetric = tzofiaT.metrics().createCountMetric("tzofia count metric");
//        TakipiSumMetric sumMetric = tzofiaT.metrics().createSumMetric("tzofia sum metric");
//        TakipiLatestMetric latestMetric = tzofiaT.metrics().createLatestMetric("tzofia latest metric");
//        
//        TakipiContext context3 = akkaT.contexts().createContext(AkkaTest.class);
//        TakipiAverageMetric akkaMetric = akkaT.metrics().createAverageMetric("akka metric");
//        
//        TakipiContext context4 = newRelicT.contexts().createContext(AkkaTest.class);
//        TakipiAverageMetric newRelicMetric = newRelicT.metrics().createAverageMetric("new relic metric");
//        
//        
//        newRelicMetric.update(context4, 1);
//        newRelicMetric.update(context4, 2);
//        newRelicMetric.update(context4, 3);
//        
//        avgMetric.update(context1, 1);
//        avgMetric.update(context1, 2);
//        avgMetric.update(context1, 3);
//        
//        countMetric.increment(context2);
//        countMetric.increment(context2);
//        
//        sumMetric.add(context1, 10);
//        sumMetric.add(context1, 10);
//        sumMetric.add(context1, 20);
//        
//        latestMetric.set(context1, 3);
//        latestMetric.set(context1, 2);
//        latestMetric.set(context1, 1);
//        latestMetric.set(context1, 2);
//        latestMetric.set(context1, 3);
//        latestMetric.set(context1, 7);
//        
//        akkaMetric.update(context3, 5);
//        
//        Thread.sleep(1000);
    }
		
}
