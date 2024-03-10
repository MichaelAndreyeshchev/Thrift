./clean.sh
./make.sh

java -cp ".:./Thrift13/*" Server &

If your client is on the same machien as the server, execute the following command
  java -cp ".:./Thrift13/*" Client

Otherwise
  java -cp ".:./Thrift13/*" Client serverHostName


