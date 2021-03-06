package  com.hem.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

public class HdfsWrite {
  public static void main(String[] args) throws IOException, URISyntaxException 
   {
      //1. Get the instance of COnfiguration
      Configuration configuration = new Configuration();
      //2. Create an InputStream to read the data from local file

	String src = "/data/home/devbld/ff210.txt";
	String hostPort = "infacdh001:8020";
	String tgtLoc = "/tmp/ff210.txt";
	if(args.length > 2){
		src = args[0];
		hostPort = args[1];
		tgtLoc = args[2];
	}else{
		System.out.println("usage is :HdfsWrite host:port targetLocation");
	}
	String tgt = "hdfs://"+ hostPort + tgtLoc;
	
      InputStream inputStream = new BufferedInputStream(new FileInputStream(src));
      //3. Get the HDFS instance
      FileSystem hdfs = FileSystem.get(new URI("hdfs://" + hostPort), configuration);
      //4. Open a OutputStream to write the data, this can be obtained from the FileSytem
      OutputStream outputStream = hdfs.create(new Path(tgt),
      new Progressable() {  
              @Override
              public void progress() {
         System.out.println("....");
              }
      });
      try
      {
        IOUtils.copyBytes(inputStream, outputStream, 4096, false); 
      }
      finally
      {
        IOUtils.closeStream(inputStream);
        IOUtils.closeStream(outputStream);
      } 
  }
}
