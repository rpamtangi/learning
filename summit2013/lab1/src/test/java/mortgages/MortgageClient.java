package mortgages;

import org.switchyard.component.test.mixins.http.HTTPMixIn;

/**
 * Simple client to send a SOAP message.
 */
public final class MortgageClient {

    private static final String URL = "http://localhost:8080/loans/LoanProcessing";
    private static final String XML = "src/test/resources/xml/loan-request-gold.xml";


    /**
     * Only execution point for this application.
     * @param ignored not used.
     * @throws Exception if something goes wrong.
     */
    public static void main(final String[] ignored) throws Exception {

        HTTPMixIn soapMixIn = new HTTPMixIn();
        soapMixIn.initialize();

        try {
        	soapMixIn.setDumpMessages(true);
            soapMixIn.postFile(URL, XML);
        } finally {
            soapMixIn.uninitialize();
        }
    }
}
