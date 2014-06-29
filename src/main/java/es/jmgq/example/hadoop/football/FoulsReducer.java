package es.jmgq.example.hadoop.football;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FoulsReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int totalFouls = 0;

        for (IntWritable fouls: values) {
            totalFouls += fouls.get();
        }

        context.write(key, new IntWritable(totalFouls));
    }
}
