package es.jmgq.example.hadoop.football;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test
public class FoulsReducerTest extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void shouldReturnTheTotalNumberOfFouls() {
        Text teamName = new Text("Barcelona");

        List<IntWritable> fouls = new ArrayList<IntWritable>();
        fouls.add(new IntWritable(10));
        fouls.add(new IntWritable(12));
        fouls.add(new IntWritable(6));

        Pair<Text, IntWritable> expectedOutput = new Pair<Text, IntWritable>(teamName, new IntWritable(28));

        new ReduceDriver<Text, IntWritable, Text, IntWritable>()
            .withReducer(new FoulsReducer())
            .withInputKey(teamName)
            .withInputValues(fouls)
            .withOutput(expectedOutput)
            .runTest();
    }
}
