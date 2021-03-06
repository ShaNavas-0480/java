import java.io.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.io.IntWritable;


public class speed {
	
	public static class MapClass extends Mapper<LongWritable,Text,Text,IntWritable>
	   {
	
		 
	      public void map(LongWritable key, Text value, Context context)
	      {	    	  
	         try{
	            String[] str = value.toString().split(",");	 
	            int speed = Integer.parseInt(str[1]);
	            //context.write(new Text(str[1]),new LongWritable(vol));
	         
	         context.write(new Text(str[0]),new IntWritable(speed));
	         }
	         catch(Exception e)
	         {
	            System.out.println(e.getMessage());
	         }
	      }
	   }
	
	  public static class ReduceClass extends Reducer<Text,IntWritable,Text,Text>
	   {
		
		    
		    public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
		double offence_percent = 0.00;
		int offence_count=0;
				int total=0;
				
		      
		      
		         for (IntWritable val : values)
		         {       	
		        	 
		        	 if (val.get()> 65){
		        		 offence_count++;
		        	 }
		        	      total++;
		         }
		         offence_percent = ((offence_count*100)/total);
		      String percentvalue = String.format("%f", offence_percent);
		      String valwithsign = percentvalue + "%";
		      context.write(key, new Text(valwithsign));
		      //context.write(key, new LongWritable(sum));
		      
		    }
	   }
	  public static void main(String[] args) throws Exception {
		    Configuration conf = new Configuration();
		    //conf.set("name", "value")
		    //conf.set("mapreduce.input.fileinputformat.split.minsize", "134217728");
		    Job job = Job.getInstance(conf, "speed");
		    job.setJarByClass(speed.class);
		    job.setMapperClass(MapClass.class);
		    //job.setCombinerClass(ReduceClass.class);
		    job.setReducerClass(ReduceClass.class);
		    //job.setNumReduceTasks(0);
		    job.setMapOutputKeyClass(Text.class);
		    job.setMapOutputValueClass(IntWritable.class);
		    job.setOutputKeyClass(Text.class);
		    job.setOutputValueClass(Text.class);

		    
		    FileInputFormat.addInputPath(job, new Path(args[0]));
		    FileOutputFormat.setOutputPath(job, new Path(args[1]));
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		  }
}