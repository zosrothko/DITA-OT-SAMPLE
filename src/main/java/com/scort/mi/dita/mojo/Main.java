package com.scort.mi.dita.mojo;


import java.io.File;

import org.dita.dost.Processor;
import org.dita.dost.ProcessorFactory;
import org.dita.dost.exception.DITAOTException;

public class Main {

	private static File tempDir;
	private static File ditaDir;
	private static File mapFile;
	private static File outDir;

	public static void main(String[] args) throws DITAOTException {
		if (args != null && args.length == 0) {
			args = new String[1]; args[0] = "pdf";
		}
		String ditaHome = System.getenv("DITA_HOME");
		ditaDir = new File(ditaHome).getAbsoluteFile();
		tempDir = new File("temp").getAbsoluteFile();
		mapFile = new File("dita");
		mapFile = new File(mapFile, "MIS_3287_Connector_PG_4.3");
		mapFile = new File(mapFile, "MIS_3287_Connector_PG_4.3.ditamap").getAbsoluteFile();
		outDir = new File("out");
		outDir = new File(outDir, args[0]).getAbsoluteFile();
		ProcessorFactory processorFactory = ProcessorFactory.newInstance(ditaDir);
		// and set the temporary directory
		processorFactory.setBaseTempDir(tempDir);
		
		// Create a processor using the factory and configure the processor
		Processor processor = processorFactory.newProcessor(args[0])
		.setInput(mapFile)
		.setOutputDir(outDir);

		processor.createDebugLog(false);
		processor.cleanOnFailure(true);
		// Run conversion
		processor.run();
	}

}
