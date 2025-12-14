package com.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenpactL2Ex {

	public static void main(String[] args) throws IOException {
//		Text file 
		// frequency of each word
		
		String pathurl = "src/main/file.txt";
		Path p = Path.of(pathurl, null);
		Stream<String> filesStreamer = Files.lines(p);
		
		Map<String, Long> map =
		filesStreamer.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	}
}
