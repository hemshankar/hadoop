import java.io.IOException;
import java.security.PrivilegedExceptionAction;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobID;
import org.apache.hadoop.mapred.RunningJob;
import org.apache.hadoop.security.UserGroupInformation;

public class TestJobClient {

	public static String jobString = "";
	public static String principal = "";
	public static String keytab = "";
	public static boolean completed = false;
	public static void setCompleted(boolean val){
		completed = val;
	}
	public static String getJobString(){
		return jobString;
	}
	public static void main(String [] args){		
		
		try{			
			if(args.length == 3){
				principal = args[0];
				keytab = args[1];
				jobString = args[2];
			}else{
				System.out.println("Usage: java -cp <required jar classPath> TestJobClient <principal> <keytab> <jobString>");
				return;
			}
			
			//logi from keytab
			UserGroupInformation.loginUserFromKeytab(principal, keytab);		
			
			//create configuration object
			Configuration conf = new Configuration();			
			conf.addResource("hive-site.xml");
			conf.addResource("hdfs-site.xml");
			conf.addResource("core-site.xml");
			conf.addResource("yarn-site.xml");
			conf.addResource("mapred-site.xml");
			
			//check if the site files loaded
			System.out.println("hive.metastore.uris=" + conf.get("hive.metastore.uris"));
			
			//create the job client
			final HadoopJobClient client = new HadoopJobClient(conf);			

			//create the UGI
			UserGroupInformation ugi = UserGroupInformation.getLoginUser();
			//UserGroupInformation ugi = UserGroupInformation.createProxyUser("adpqa", ugi1); //create proxyUGI
			
			//fetch the status till the job completes
			while(true){				
				
				ugi.doAs(new PrivilegedExceptionAction<Integer>() {
	                public Integer run() throws Exception {
	                	if(client.getJobStatus(getJobString())){
	    					setCompleted(true);
	    				} 
	                	return 0;
	                }
	            });		
				if(completed)
					break;
				Thread.sleep(1000);				
			}
			
			//close the client
			client.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	
	
	//=====================Hadoop Job Client=======================
	
	
	public static class HadoopJobClient {

	    JobClient jobClient;
	    
	    public HadoopJobClient(Configuration conf) throws RuntimeException {	        
	        try {
	            JobConf jobConf = new JobConf(conf);
	            jobClient = new JobClient(jobConf);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

	   
	    public void close() throws RuntimeException {
	        try {
	            jobClient.close();
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    
	    public boolean getJobStatus(String jobIDStr) throws RuntimeException {
	        assert jobIDStr != null && jobIDStr.isEmpty() == false;
	        
	        try {
	            final RunningJob rj = jobClient.getJob(JobID.forName(jobIDStr));
	            if (rj != null) {
	                
	                //System.out.println(jobIDStr);
	                //System.out.println(rj.getTrackingURL());
	                //System.out.println(rj.getJobState());
	                System.out.println(rj.mapProgress() *100 + "% completed");
	                System.out.println(rj.reduceProgress() *100 + "% completed");
	                
	                if(rj.isComplete()){	                	
	                	return true;
	                }	                
	            }else{
	            	throw(new RuntimeException("No job found for Job Id: " + jobIDStr));
	            }
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	        return false;
	    }
	}

}

