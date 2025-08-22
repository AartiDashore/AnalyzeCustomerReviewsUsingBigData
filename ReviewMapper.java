import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class ReviewMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    private Text productId = new Text();
    private DoubleWritable rating = new DoubleWritable();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString().trim();
        if (line.isEmpty()) return;

        String[] fields = line.split(",");
        if (fields.length < 4) return; // Ensure we have all fields

        try {
            String pid = fields[0].trim();
            double rate = Double.parseDouble(fields[2].trim()); // Use double here

            productId.set(pid);
            rating.set(rate);
            context.write(productId, rating);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Skipping malformed line: " + line);
        }
    }
}