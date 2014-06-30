package es.jmgq.example.hadoop.football;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class FoulsDriver extends Configured implements Tool {
    public static final int EXIT_CODE_SUCCESS = 0;
    public static final int EXIT_CODE_FAILURE = 1;
    public static final int EXIT_CODE_INVALID_ARGUMENTS = -1;

    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new FoulsDriver(), args);

        System.exit(exitCode);
    }

    @Override
    public int run(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.printf("Usage: %s [generic options] <input> <output>\n", getClass().getSimpleName());

            ToolRunner.printGenericCommandUsage(System.err);

            return EXIT_CODE_INVALID_ARGUMENTS;
        }

        Job job = new Job(getConf(), "Fouls");
        job.setJarByClass(getClass());

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(FoulsMapper.class);
        job.setCombinerClass(FoulsReducer.class);
        job.setReducerClass(FoulsReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        return job.waitForCompletion(true) ? EXIT_CODE_SUCCESS : EXIT_CODE_FAILURE;
    }
}
