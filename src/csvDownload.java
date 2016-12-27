import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/*
 * This class creates a CSV data file based on the Ticker,
 * start and end dates.
 */
public class csvDownload {
	public static void download(String ticker) throws IOException{
		
		String ticker_url = "http://real-chart.finance.yahoo.com/table.csv?s=" + ticker + "&a=11&b=12&c=1980&d=11&e=27&f=2016&g=d&ignore=.csv";
		System.out.println(ticker_url);
		URL url = new URL(ticker_url);
		String fileName = url.getFile();

		Path targetPath = new File("data.csv").toPath();

		Files.copy(url.openStream(), targetPath,
				StandardCopyOption.REPLACE_EXISTING);

		return;
	}
	
	/*
	 * Testing code
	 */
	/*public static void main(String args[]) throws IOException{
		download("GOOG");
		
	}*/
}

