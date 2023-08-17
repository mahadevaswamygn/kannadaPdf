package com.example.kannadaPdf;

import com.example.kannadaPdf.service.KannadaPdf;
import com.example.kannadaPdf.service.PdfGenerator;
import net.sf.jasperreports.engine.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class KannadaPdfApplication {

	public static void main(String[] args) throws JRException, IOException {

		ConfigurableApplicationContext context = SpringApplication.run(KannadaPdfApplication.class, args);

//			String jrxmlFile = "/home/mahadeva/JaspersoftWorkspace/MyReports/sample.jrxml"; // Replace with the actual path
//			PdfGenerator pdfGenerator = context.getBean(PdfGenerator.class);
//			pdfGenerator.generatePdf();
		KannadaPdf kannadaPdf=context.getBean(KannadaPdf.class);
		kannadaPdf.getKannadaPdf();
			context.close();
	}

}
