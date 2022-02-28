package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {

    private List<Channel> channels;

    public VideoPlatform() {
        this.channels = new ArrayList<>();
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public int calculateSumOfVideos(){
        int sum = 0;
        for (Channel element : channels){
            sum += element.getVideos();
        }
        return sum;
    }


    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean head = true;
            while ((line = br.readLine()) != null) {
                if (head) {
                    head = false;
                } else {
                    parseLine(line);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!", e);
        }
    }


    private void parseLine(String line) {
        String[] temp = line.split(";");

        String channelName = temp[0];
        int members = Integer.parseInt(temp[1]);
        int videos  = Integer.parseInt(temp[2]);

        channels.add(new Channel(channelName, members, videos));
    }


}
