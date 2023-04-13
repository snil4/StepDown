using StepDown.Models;

namespace StepDown.Models;

public class User {
    public long id {get; set;}
    public string? userName {get; set;}
    public string? password {get; set;}
    public Song[]? songs {get; set;}
}