package es.jmgq.example.hadoop.football;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.List;

public class FoulsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private TeamStatisticsParser parser = new TeamStatisticsParser();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        List<TeamStatistics> statistics = parser.parse(line);

        for (TeamStatistics statistic: statistics) {
            context.write(new Text(statistic.getTeamName()), new IntWritable(statistic.getFouls()));
        }
    }
}
