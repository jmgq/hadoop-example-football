package es.jmgq.example.hadoop.football;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class FoulsMapperTest {
    public void shouldProcessValidRecord() throws IOException {
        Text value = new Text("SP1,30/08/08,Espanol,Valladolid,1,0,H,0,0,D,10,11,2,1,18,17,1,9,3,5,0,0,2,3.3,3.8,1.8,3.25,4.1,2,3.2,3.75,1.75,3.2,4.3,1.8,3.2,4,1.85,3.2,4,1.83,3.2,3.75,2,3.2,4,1.9,3.25,3.5,1.8,3.25,4.33,37,2.09,1.9,3.4,3.25,4.5,3.99,29,2.12,2.04,1.83,1.72,20,0,1.46,1.4,3,2.77");

        Pair<Text, IntWritable> expectedOutput1 = new Pair<Text, IntWritable>(new Text("Espanol"), new IntWritable(18));
        Pair<Text, IntWritable> expectedOutput2 = new Pair<Text, IntWritable>(new Text("Valladolid"), new IntWritable(17));

        new MapDriver<LongWritable, Text, Text, IntWritable>()
            .withMapper(new FoulsMapper())
            .withInput(new LongWritable(), value)
            .withOutput(expectedOutput1)
            .withOutput(expectedOutput2)
            .runTest();
    }
}
