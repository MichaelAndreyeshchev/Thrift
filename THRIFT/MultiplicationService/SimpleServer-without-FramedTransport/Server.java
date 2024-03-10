import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TTransportFactory;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSSLTransportFactory.TSSLTransportParameters;

// Generated code
public class Server {
    public static MultiplicationHandler handler;
    public static MultiplicationService.Processor processor;

    public static void main(String [] args) {
        try {
            handler = new MultiplicationHandler();
            processor = new MultiplicationService.Processor(handler);

            Server.simpleServer(processor);

        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void simpleServer(MultiplicationService.Processor processor) {
        try {
            //Create Thrift server socket
            TServerTransport serverTransport = new TServerSocket(55455);
            TServer.Args args = new TServer.Args(serverTransport);
            args.processor(processor);  //Set handler
            TServer server = new TSimpleServer(args);
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	    
}

