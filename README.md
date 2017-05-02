Install Maven

$mvn clean install 

	this will create download all the required jars and create hadoopclient-1.0-SNAPSHOT.jar

Run using 

	java -cp target/hadoopclient-1.0-SNAPSHOT.jar:conf:PATH_TO_REQUIRED_JARS/* com.hem.demo.HdfsRead hdfs source
	eg:
	java -cp target/hadoopclient-1.0-SNAPSHOT.jar:conf:PATH_TO_REQUIRED_JARS/* com.hem.demo.HdfsRead  hdfs://infacdh001:8020/tmp/ff27.txt


	java -cp target/hadoopclient-1.0-SNAPSHOT.jar:conf:PATH_TO_REQUIRED_JARS/* com.hem.demo.HdfsWrite source host:port targetLocation
	eg:
	java -cp target/hadoopclient-1.0-SNAPSHOT.jar:conf:PATH_TO_REQUIRED_JARS/* com.hem.demo.HdfsWrite /data/home/devbld/breakpoints infacdh001:8020 /tmp/ff27.txt


Make sure all these jars are present in the class path. (PATH_TO_REQUIRED_JARS)

activation-1.1.jar
apacheds-i18n-2.0.0-M15.jar
apacheds-kerberos-codec-2.0.0-M15.jar
api-asn1-api-1.0.0-M20.jar
api-util-1.0.0-M20.jar
asm-3.2.jar
avro.jar
avro-mapred-1.7.5-hadoop2.jar
aws-java-sdk-core-1.10.6.jar
aws-java-sdk-s3-1.10.6.jar
bonecp-0.8.0.RELEASE.jar
calcite-avatica-1.0.0-incubating.jar
calcite-core-1.0.0-incubating.jar
calcite-linq4j-1.0.0-incubating.jar
commons-beanutils-1.7.0.jar
commons-beanutils-core-1.8.0.jar
commons-cli-1.2.jar
commons-codec-1.4.jar
commons-collections-3.2.2.jar
commons-compress-1.4.1.jar
commons-configuration-1.6.jar
commons-daemon-1.0.13.jar
commons-daemon-1.0.3.jar
commons-digester-1.8.jar
commons-el-1.0.jar
commons-httpclient-3.1.jar
commons-io-2.4.jar
commons-lang-2.6.jar
commons-logging-1.1.3.jar
commons-math3-3.2.jar
commons-net-3.1.jar
commons-pool2-2.4.1.jar
curator-client-2.7.1.jar
curator-framework-2.7.1.jar
curator-recipes-2.7.1.jar
datanucleus-api-jdo-3.2.6.jar
datanucleus-core-3.2.10.jar
datanucleus-rdbms-3.2.9.jar
gson-2.2.4.jar
guava-14.0.1.jar
guice-3.0.jar
guice-servlet-3.0.jar
hadoop-annotations-2.6.0-cdh5.8.0.jar
hadoop-auth-2.6.0-cdh5.8.0.jar
hadoop-aws-2.6.0-cdh5.8.0.jar
hadoop-common-2.6.0-cdh5.8.0.jar
hadoop-distcp-2.6.0-cdh5.8.0.jar
hadoop-hdfs-2.6.0-cdh5.8.0.jar
hadoop-hdfs-nfs-2.6.0-cdh5.8.0.jar
hadoop-mapreduce-client-app-2.6.0-cdh5.8.0.jar
hadoop-mapreduce-client-common-2.6.0-cdh5.8.0.jar
hadoop-mapreduce-client-core-2.6.0-cdh5.8.0.jar
hadoop-mapreduce-client-jobclient-2.6.0-cdh5.8.0.jar
hadoop-mapreduce-client-shuffle-2.6.0-cdh5.8.0.jar
hadoop-nfs-2.6.0-cdh5.8.0.jar
hadoop-yarn-api-2.6.0-cdh5.8.0.jar
hadoop-yarn-applications-unmanaged-am-launcher-2.6.0-cdh5.8.0.jar
hadoop-yarn-client-2.6.0-cdh5.8.0.jar
hadoop-yarn-common-2.6.0-cdh5.8.0.jar
hadoop-yarn-registry-2.6.0-cdh5.8.0.jar
hadoop-yarn-server-applicationhistoryservice-2.6.0-cdh5.8.0.jar
hadoop-yarn-server-common-2.6.0-cdh5.8.0.jar
hadoop-yarn-server-nodemanager-2.6.0-cdh5.8.0.jar
hadoop-yarn-server-resourcemanager-2.6.0-cdh5.8.0.jar
hadoop-yarn-server-web-proxy-2.6.0-cdh5.8.0.jar
hamcrest-core-1.1.jar
hbase-client-1.2.0-cdh5.8.0.jar
hbase-common-1.2.0-cdh5.8.0.jar
hbase-hadoop-compat-1.2.0-cdh5.8.0.jar
hbase-it-1.2.0-cdh5.8.0.jar
hbase-prefix-tree-1.2.0-cdh5.8.0.jar
hbase-protocol-1.2.0-cdh5.8.0.jar
hbase-server-1.2.0-cdh5.8.0.jar
hbase-shell-1.2.0-cdh5.8.0.jar
hbase-thrift-1.2.0-cdh5.8.0.jar
hive-beeline-1.1.0-cdh5.8.0.jar
hive-cli-1.1.0-cdh5.8.0.jar
hive-common-1.1.0-cdh5.8.0.jar
hive-exec-1.1.0-cdh5.8.0.jar
hive-hbase-handler-1.1.0-cdh5.8.0.jar
hive-hwi-1.1.0-cdh5.8.0.jar
hive-jdbc-1.1.0-cdh5.8.0.jar
hive-metastore-1.1.0-cdh5.8.0.jar
hive-serde-1.1.0-cdh5.8.0.jar
hive-service-1.1.0-cdh5.8.0.jar
htrace-core-3.0.4.jar
htrace-core-3.2.0-incubating.jar
htrace-core4-4.0.1-incubating.jar
httpclient-4.2.5.jar
httpcore-4.2.5.jar
jackson-core-asl-1.9.2.jar
jackson-jaxrs-1.9.2.jar
jackson-mapper-asl-1.9.12.jar
jackson-xc-1.9.2.jar
jasper-compiler-5.5.23.jar
jasper-runtime-5.5.23.jar
javax.inject-1.jar
java-xmlbuilder-0.4.jar
jaxb-api-2.2.2.jar
jaxb-impl-2.2.3-1.jar
jdo-api-3.0.1.jar
jersey-client-1.9.jar
jersey-core-1.9.jar
jersey-guice-1.9.jar
jersey-json-1.9.jar
jersey-server-1.9.jar
jets3t-0.9.0.jar
jettison-1.3.3.jar
jetty-6.1.26.cloudera.4.jar
jetty-util-6.1.26.cloudera.4.jar
jline-2.12.jar
jms-1.1.jar
jopt-simple-4.4.jar
jsch-0.1.42.jar
jsp-api-2.1.jar
jsr305-3.0.0.jar
junit-4.12.jar
kafka_2.11-0.8.2.1.jar
kafka-clients-0.8.2.1.jar
leveldbjni-all-1.8.jar
libfb303-0.9.3.jar
libthrift-0.9.3.jar
log4j-1.2.17.jar
logredactor-1.0.3.jar
lz4-1.3.0.jar
metrics-core-2.2.0.jar
mockito-all-1.8.5.jar
netty-3.10.5.Final.jar
netty-all-4.0.23.Final.jar
paranamer-2.3.jar
parquet-avro-1.5.0-cdh5.8.0.jar
parquet-avro-1.6.0rc3.jar
parquet-avro.jar
parquet-column.jar
parquet-common.jar
parquet-encoding.jar
parquet-format.jar
parquet-hadoop.jar
protobuf-java-2.5.0.jar
relaxngDatatype-20020414.jar
sentry-binding-hive.jar
servlet-api-2.5.jar
slf4j-api-1.7.5.jar
slf4j-log4j12.jar
snappy-java-1.1.1.7.jar
spark-avro_2.11-3.0.1.jar
spark-streaming-kafka-0-8_2.11-2.0.0.jar
spark-xml_2.11-0.4.0.jar
sqoop-1.4.6-cdh5.8.0.jar
sqoop-1.4.6-hadoop200.jar
stax-api-1.0-2.jar
stax-stax-1.2.0.jar
xmlenc-0.52.jar
xsom-20100725.jar
xz-1.0.jar
zkclient-0.8.jar
zookeeper.jar

native:
libhadoop.so
libhadoop.so.1.0.0
libsnappy.so
libsnappy.so.1
libsnappy.so.1.1.3
