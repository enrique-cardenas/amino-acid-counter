package spring2018.lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import java.io.IOException;

public class AAReducer  extends Reducer <Text,Text,Text,Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) 
		   throws IOException, InterruptedException {
        
        // TODO: initialize integer sums for each reading frame
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        // TODO: loop through Iterable values and increment sums for each reading frame
        String compositeString;
        String[] compositeStringArray;
        for(Text value : values)
        {
            compositeString = value.toString();
            compositeStringArray = compositeString.split("_");
            if(compositeStringArray[0].equals("Frame1"))
            {
                sum1 += Integer.valueOf(compositeStringArray[1]);
            }
            if (compositeStringArray[0].equals("Frame2"))
            {
                sum2 += Integer.valueOf(compositeStringArray[1]);
            }
            if (compositeStringArray[0].equals("Frame3"))
            {
                sum3 += Integer.valueOf(compositeStringArray[1]);
            }
            
        }
        
        // TODO: write the (key, value) pair to the context
        // TODO: consider how to use tabs to format output correctly
        if(key.toString().length() < 8)
        {
            context.write(key, new Text("\t\t" + Integer.toString(sum1) + "\t\t" +
                    Integer.toString(sum2) + "\t\t" +
                    Integer.toString(sum3)));
        }
        else if (key.toString().length() >= 12)
        {
            
            context.write(key, new Text("\t" + Integer.toString(sum1) + "\t\t" +
                    Integer.toString(sum2) + "\t\t" +
                    Integer.toString(sum3)));
        }
        else 
        {
	    context.write(key, new Text(Integer.toString(sum1) + "\t\t" +
	            Integer.toString(sum2) + "\t\t" +
	            Integer.toString(sum3)));
        }
    }
}