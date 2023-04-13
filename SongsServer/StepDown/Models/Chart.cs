namespace StepDown.Models;

public class Chart {
    public int level {get; set;}
    public Difficulty? difficulty {get; set;}
    public string? name {get; set;}
    public string? author {get; set;}
    public Song? song {get; set;}
}

public enum Difficulty {
    BEGGINER, EASY, MEDIUM, HARD, EXPERT, EDIT
}