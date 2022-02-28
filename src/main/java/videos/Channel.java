package videos;

public class Channel {
    private String channelName;
    private int members;
    private int videos;

    public Channel(String channelName, int members, int videos) {
        this.channelName = channelName;
        this.members = members;
        this.videos = videos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getMembers() {
        return members;
    }

    public int getVideos() {
        return videos;
    }
}
