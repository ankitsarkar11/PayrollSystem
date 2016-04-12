package Common;

import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by Ankit Sarkar on 4/11/2016.
 */
public class PrintJob {
    public static void print(javafx.scene.Node node){

        PrinterJob job = PrinterJob.createPrinterJob();
        if(job.showPrintDialog(Welcome.common.getOwner()) && job.printPage(node))
            job.endJob();
    }
}
