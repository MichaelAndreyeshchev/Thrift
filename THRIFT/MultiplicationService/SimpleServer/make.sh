thrift --gen java multiply.thrift
cp gen-java/MultiplicationService.java ./

#javac -Xlint  -cp ".:./Thrift13/*" *.java  -d .
javac -Xlint  -cp ".:./Thrift13/*" *.java  -d .



