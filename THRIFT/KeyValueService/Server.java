import org.apache.thrift.TException;
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
    public static kvHandler handler;
    public static kvstorage.Processor kvProcessor;

    public static void main(String [] args) {
        try {
            handler = new kvHandler();
            kvProcessor = new kvstorage.Processor(handler);

            Runnable simple = new Runnable() {
                public void run() {
                   // simple(processor);
                    networkHandler(kvProcessor);
                }
            };

            new Thread(simple).start();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void networkHandler(kvstorage.Processor kvProcessor) {
        try {
            //Create Thrift server socket
            TServerTransport serverTransport = new TServerSocket(55455);
             TTransportFactory factory = new TFramedTransport.Factory();


            //Set server arguments
            TServer.Args args = new TServer.Args(serverTransport);
            args.processor(kvProcessor);  //Set handler
             args.transportFactory(factory);  //Set FramedTransport (for performance)

            //Run server as a single thread
            TServer server = new TSimpleServer(args);
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

