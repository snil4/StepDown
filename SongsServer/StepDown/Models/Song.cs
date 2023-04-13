namespace StepDown.Models;
public class Song {
    public long id {get; set;}
    public string? title {get; set;}
    public string? artist {get; set;}
    public int bpm {get; set;}
    public Chart[]? charts {get; set;}
    public string[]? chartsId {get; set;}
    public User? uploader {get; set;}
    public long uploaderId {get; set;}
}