package es.jmgq.example.hadoop.football;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class FoulsDriverTest {
    public void shouldRun() throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.default.name", "file:///");
        conf.set("mapred.job.tracker", "local");

        Path input = new Path("src/test/resources");
        Path output = new Path("target/test-output");

        FileSystem fs = FileSystem.getLocal(conf);
        fs.delete(output, true);

        FoulsDriver sut = new FoulsDriver();
        sut.setConf(conf);

        int exitCode = sut.run(
            new String[] {input.toString(), output.toString()}
        );

        assertEquals(exitCode, FoulsDriver.EXIT_CODE_SUCCESS);
    }

    public void shouldNotRunIfNumberOfArgumentsIsNotTwo() throws Exception {
        FoulsDriver sut = new FoulsDriver();

        int exitCode = sut.run(new String[] {});

        assertEquals(exitCode, FoulsDriver.EXIT_CODE_INVALID_ARGUMENTS);
    }
}
