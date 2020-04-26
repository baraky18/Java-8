import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadExample {

	public static void main(String[] args) throws IOException {
		/*
		 * we are reading the .project file line by line till we find a line with "natures" in it 
		 * and then we replace < and > with empty strings and return the list of lines
		 */
		List<String> list = Files.lines(Paths.get("C:/Users/baraky/workspace/Java 8 Streams/.project"))
			.filter(line -> line.contains("natures"))
			.map(line -> 
				line.trim()
				.replaceAll("<", "")
				.replaceAll(">", ""))
			.collect(Collectors.toList());
		System.out.println(list);
	}

}
