package AnynoumsFunct;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Consumer;

public class ConsumerCurdate {
	
	public static void main(String[] args) {
		
		Consumer<ZoneId> printCurrentTime = zone -> {
            ZonedDateTime now = ZonedDateTime.now(zone);
            System.out.println("Current Time: "+ now);
        };

        printCurrentTime.accept(ZoneId.of("Asia/Kolkata"));
    }
}
