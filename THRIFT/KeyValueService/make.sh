thrift --gen java kvstorage.thrift
cp gen-java/kvstorage.java ./

javac -Xlint -cp ".:./Thrift13/*" *.java -d .



